package com.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cassie on 2018/4/8.
 */
@Controller
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return  "This is  first springboot demo";
    }
}
