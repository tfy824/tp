package com.tp.common.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseController {

    public static final String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;

    private final String RESULT_CODE = "resultCode";
    private final String RESULT_MSG = "resultMsg";
    /**请求成功*/
    private final String SUCCESS_MSG = "请求成功";
    private final String RESULT_DATA = "resultData";

    public static Map<String, String> resultCodeMap = new HashMap<String, String>();
    /**系统繁忙，请稍后再试*/
    public final static String SYSTEM_BUSY = "-1";//
    public final static String SUCCESS_CODE = "0";//请求成功
    //--------------增、删、改、查提示【10开头】-----
    /**修改成功*/
    public final static String UPDATE_SUCCESS = "10";
    /**修改失败*/
    public final static String UPDATE_FAIL = "11";
    /**添加成功*/
    public final static String ADD_SUCCESS = "12";
    /**新增失败*/
    public final static String ADD_FAIL = "13";
    /**删除成功*/
    public final static String DELETE_SUCCESS ="14";
    /**删除失败*/
    public final static String DELETE_FAIL = "15";
    /**系统参数错误*/
    public final static String SYSTEM_PARAM_ERROR = "16";
    /**查询失败*/
    public final static String SELECT_FAIL = "17";
    /**系统处理错误*/
    public static final String FAIL_CODE = "40001";//

    public Map<String, Object> successMap(Object result) {
        return successMap(result, SUCCESS_MSG);
    }

    public Map<String, Object> successMap() {
        return successMap(null, resultCodeMap.get(SUCCESS_CODE));
    }

    public Map<String, Object> successMap(Object result, String msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(RESULT_CODE, SUCCESS_CODE);
        resultMap.put(RESULT_MSG, msg);
        if (result != null) {
            resultMap.put(RESULT_DATA, result);
        } else {
            resultMap.put(RESULT_DATA, "");
        }
        return resultMap;
    }

    public Map<String, Object> failMap(String msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(RESULT_CODE, FAIL_CODE);
        resultMap.put(RESULT_MSG, msg);
        return resultMap;
    }

    /**
     * 通用错误返回
     * 如果希望使用系统通用的错误返回码，直接设置错误码，并将错误信息设置为null即可。
     * @param errorCode 返回错误码
     * @param msg 错误描述
     * @return
     */
    public Map<String, Object> failMap(String errorCode, String  msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(RESULT_CODE, errorCode);
        if(msg == null || msg.equals("")){
            String otherMsg = resultCodeMap.get(errorCode);
            resultMap.put(RESULT_MSG, otherMsg);
        }else{
            resultMap.put(RESULT_MSG, msg);
        }
        return resultMap;
    }

}
