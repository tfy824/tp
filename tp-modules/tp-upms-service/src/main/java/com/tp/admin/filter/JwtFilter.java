package com.tp.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.tp.admin.configer.Audience;
import com.tp.common.constant.OperateConstant;
import com.tp.common.controller.BaseController;
import com.tp.common.exception.BizException;
import com.tp.common.utils.JwtHelper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.io.PrintWriter;

import static com.tp.common.constant.OperateConstant.RESULT_CODE;

/**
 *
 * @author TP
 * @date 2018/5/3
 */
@Order(1)
@WebFilter(filterName = "jwfFilter", urlPatterns = "/*" )
public class JwtFilter extends GenericFilterBean {
    @Autowired
    private Audience audience;

    private final String METHOD_OPTIONS = "OPTIONS";

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/logout", "/register")));
    /**
     *  Reserved claims（保留），它的含义就像是编程语言的保留字一样，属于JWT标准里面规定的一些claim。JWT标准里面定好的claim有：

     iss(Issuser)：代表这个JWT的签发主体；
     sub(Subject)：代表这个JWT的主体，即它的所有人；
     aud(Audience)：代表这个JWT的接收对象；
     exp(Expiration time)：是一个时间戳，代表这个JWT的过期时间；
     nbf(Not Before)：是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的；
     iat(Issued at)：是一个时间戳，代表这个JWT的签发时间；
     jti(JWT ID)：是JWT的唯一标识。
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        //得到请求头信息Authorization信息
        final String authHeader = request.getHeader(JwtHelper.AUTHORIZATION);
        if (METHOD_OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {
            String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
            boolean allowedPath = ALLOWED_PATHS.contains(path) || excludeSwagger(path);

            if (allowedPath) {
                chain.doFilter(req, res);
            }else {
                if (authHeader == null || !authHeader.startsWith(JwtHelper.TOKEN_PRE)) {
                    unLogin(res);
                    return;
                }
                final String token = authHeader.substring(JwtHelper.TOKEN_PRE.length());
                try {
                    if(audience == null){
                        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                        audience = (Audience) factory.getBean("audience");
                    }
                    final Claims claims = JwtHelper.parseJWT(token,audience.getBase64Secret());
                    if(claims == null){
                        unLogin(res);
                        return;
                    }
                    request.setAttribute("CLAIMS", claims);
                } catch (final Exception e) {
                    unLogin(res);
                    return;
                }
                chain.doFilter(req, res);
            }
        }
    }

    private Boolean excludeSwagger(String path){
         if (path.contains("swagger")|| path.startsWith("/v2/api-docs") || path.startsWith("/webjars") || path.endsWith(".js")|| path.endsWith(".html")|| path.endsWith(".css")){
             return true;
         }
         return false;
    }

    /**
     * 未登录
     * @param response
     */
    private void unLogin(final ServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try{
            JSONObject res = new JSONObject();
            res.put(OperateConstant.RESULT_CODE,OperateConstant.UNLOGIN_CODE);
            res.put(OperateConstant.RESULT_MSG,OperateConstant.UNLOGIN_MSG);
            out = response.getWriter();
            out.append(res.toString());
        }
       catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != out) {
                out.close();
            }
        }
    }
}