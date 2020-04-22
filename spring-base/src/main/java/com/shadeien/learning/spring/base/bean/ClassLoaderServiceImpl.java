package com.shadeien.learning.spring.base.bean;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ClassLoaderServiceImpl {
    private Logger logger = LoggerFactory.getLogger(ClassLoaderServiceImpl.class);

    @Autowired
    InterfaceScanner interfaceScanner;

    public void loadJar(String jarPath, String packageName) {
        URLClassLoader myClassLoader = null;
        try {
            URL url = null;
            if(jarPath.startsWith("http:")){
                url = new URL(jarPath);
            }else {
                File jarFile = new File(jarPath);
                url = jarFile.toURI().toURL();
            }
            myClassLoader = new URLClassLoader(new URL[]{url}, Thread.currentThread().getContextClassLoader());
            new Reflections("com.wwwarehouse" , interfaceScanner, myClassLoader);
        } catch (Exception exp) {
            logger.error("", exp);
        } finally {
            if (myClassLoader != null) {
                try {
                    myClassLoader.close();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }
        }
    }
}
