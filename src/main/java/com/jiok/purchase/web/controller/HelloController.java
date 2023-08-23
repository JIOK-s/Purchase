package com.jiok.purchase.web.controller;

import com.jiok.purchase.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    private String hello() {
        return "hello " + helloService.getName();
    }
}
