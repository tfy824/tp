package com.tp.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TP on 2018/4/25.
 */
@RestController
public class TestController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
