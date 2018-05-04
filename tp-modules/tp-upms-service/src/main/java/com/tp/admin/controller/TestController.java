package com.tp.admin.controller;

import com.tp.admin.configer.Audience;
import com.tp.common.controller.BaseController;
import com.tp.common.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by TP on 2018/4/25.
 */
@RestController
public class TestController extends BaseController{
    @Autowired
    private Audience audience;
    @GetMapping("/")
    public String index(){
        return "index";
    }


}
