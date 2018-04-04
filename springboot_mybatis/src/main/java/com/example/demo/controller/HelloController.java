package com.example.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cassie on 2018/4/3.
 */
@Controller
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        System.out.println("welcome");
        return "hello,this is a springboot demo";
    }

}
