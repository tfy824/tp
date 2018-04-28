package com.tp.common.constant;

/**
 * Created by TP on 2018/4/28.
 */
public class OperateConstant {

    public static final String PAGE_SIZE="2";

    /**通用信息**/
    public static final String SESSION_WEB_USER="webUser";
    public static final String OPERATION_FAIL = "操作失败";
    public static final String OPERATION_SUCCESS = "操作成功";
    public static final Long REDIS_SEESION_TIMEOUT=10L;//设置redis共享session失效时间（秒）
    public static  final String QUERY_FAIL="查询失败";

    /***************************请求返回的操作*******************/
    //返回类型code属性
    public static final String RESULT_CODE = "resultCode";
    //返回msg属性
    public static final String RESULT_MSG = "resultMsg";
    //返回内容属性
    public static final String RESULT_DATA = "resultData";

    /**code相关**/
    //请求成功
    public static final String SUCCESS_CODE = "0";
    //请求失败
    public static final String FAIL_CODE = "4001";
    //token验证失败
    public static final String TOKEN_FAIL_CODE = "4002";
    //非法token
    public static final String TOKEN_EXCE_CODE = "4003";
    //token过期
    public static final String TOKEN_EXPIRED_CODE="4004";

    /**************************文本内容******************/
    //请求成功
    public static final String SUCCESS_MSG = "请求成功";

    public static final String FAIL_MSG = "未知错误";

    public static final String FAIL_TOKEN_ISS = "token签发者错误";

    public static final String TOKEN_EXCE_MSG = "非法token";

    public static final String TOKEN_EXPIRED_MSG = "token过期";

    /***************************token******************************/
    /**secret**/
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    /**过期时间**/
    public static final long EXPIRATION_TIME=0;  //millisecond 0代表没有过期时间
    /**签发者**/
    public static final String ISSUER="i2";

    public static final String MD5_PREFIX = "i2";





}
