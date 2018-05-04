package com.tp.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tp.admin.configer.Audience;
import com.tp.admin.entity.User;
import com.tp.admin.service.IUserService;
import com.tp.common.controller.BaseController;
import com.tp.common.utils.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author TP
 * @date 2018/5/4
 */
@RestController
public class LoginController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private Audience audience;
    @PostMapping("login")
    public Map<String, Object> login(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password) {
        User user = userService.findByNameAndPassword(username, password);
        if(null != user){
            String jwtToken = JwtHelper.createJWT(user.getLoginName(),
                    user.getIdUser(),
                    "",
                    audience.getClientId(),
                    audience.getName(),
                    audience.getExpiresSecond()*1000,
                    audience.getBase64Secret());
            String result_str = JwtHelper.TOKEN_PRE + jwtToken;
            return successMap(result_str);
        }else {
            return failMap("用户名密码不正确");
        }

    }
}
