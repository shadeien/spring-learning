package com.shadeien.learning.spring.base.jpa.service;

import com.shadeien.learning.spring.base.jpa.entity.DeviceInfo;
import com.shadeien.learning.spring.base.jpa.repository.DeviceInfoRepository;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Administrator on 2017/6/22.
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class DeviceInfoService {

    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @Transactional(readOnly = false)
    public void saveNewDevice() {
        ((DeviceInfoService)AopContext.currentProxy()).saveNewDevice1();
        saveNewDevice2();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void saveNewDevice1() {
        DeviceInfo deviceInfo = new DeviceInfo();
//        deviceInfo.setId(111111);
        deviceInfo.setClientSn("111111");
        deviceInfo.setDeviceType("111111");
        deviceInfo.setRemarks("111111");
        deviceInfo.setUserId(ThreadLocalRandom.current().nextInt());
        deviceInfo.setVersion("111111");
        deviceInfoRepository.save(deviceInfo);
    }

    @Transactional(readOnly = false)
    public void saveNewDevice2() {
        DeviceInfo deviceInfo = new DeviceInfo();
//        deviceInfo.setId(222222);
        deviceInfo.setClientSn("222222");
        deviceInfo.setDeviceType("222222");
        deviceInfo.setRemarks("222222");
        deviceInfo.setUserId(222222);
        deviceInfo.setVersion("222222");
        deviceInfoRepository.save(deviceInfo);
        throw new RuntimeException("error");
    }
}
