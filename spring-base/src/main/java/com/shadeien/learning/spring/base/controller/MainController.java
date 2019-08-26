package com.shadeien.learning.spring.base.controller;

import com.shadeien.learning.spring.base.jpa.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    DeviceInfoService deviceInfoService;

    @RequestMapping("/")
    public String root() {
        deviceInfoService.saveNewDevice();
        return "index";
    }

    @RequestMapping("/user")
    public String userIndex() {
        deviceInfoService.saveNewDevice1();
        return "user";
    }
}
