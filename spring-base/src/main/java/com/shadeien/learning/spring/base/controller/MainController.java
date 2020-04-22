package com.shadeien.learning.spring.base.controller;

import com.shadeien.learning.spring.base.bean.AutoSyncModel;
import com.shadeien.learning.spring.base.bean.ClassLoaderServiceImpl;
import com.shadeien.learning.spring.base.jpa.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    DeviceInfoService deviceInfoService;

    @Autowired
    ClassLoaderServiceImpl classLoaderService;

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

    @RequestMapping("/syncInterface")
    public String syncInterface(@RequestBody AutoSyncModel autoSyncModel) {
        classLoaderService.loadJar(autoSyncModel.getUrl(), autoSyncModel.getModule());
        return "";
    }

}
