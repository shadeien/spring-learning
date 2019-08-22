package com.shadeien.learning.spring.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/user")
    public String userIndex() {
        return "user";
    }
}
