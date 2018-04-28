package com.tp.admin.controller;


import com.tp.admin.service.IUserService;
import com.tp.common.constant.OperateConstant;
import com.tp.common.controller.BaseController;
import com.tp.common.exception.BizException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author tp
 * @since 2018-04-28
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @GetMapping(value = "/listUser")
    @ApiOperation(httpMethod = "GET", value = "用户列表")
    public Map<String, Object> listUser() {
        try {
            return  successMap(userService.listUsers());
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.OPERATION_FAIL);
        }
    }

}

