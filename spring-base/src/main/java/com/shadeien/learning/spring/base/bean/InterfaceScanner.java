package com.shadeien.learning.spring.base.bean;

import javassist.bytecode.MethodInfo;
import org.reflections.scanners.AbstractScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class InterfaceScanner extends AbstractScanner {
    private Logger logger = LoggerFactory.getLogger(InterfaceScanner.class);

    private ConcurrentHashMap<String, List<MethodParamsInfo>> map = new ConcurrentHashMap<>();

    @Override
    public void scan(Object cls) {
        try {
            String className = getMetadataAdapter().getClassName(cls);
            ClassLoader classLoader = getConfiguration().getClassLoaders()[0];
            Class<?> aClass = Class.forName(className, false, classLoader);
            if (null != aClass && aClass.isInterface() && !aClass.isAnnotation()) {
                Method[] declaredMethods = aClass.getDeclaredMethods();
                List<MethodParamsInfo> methodParamsInfos = new ArrayList<>(declaredMethods.length);
                Arrays.stream(declaredMethods).forEach(method -> {

                    Parameter[] params = method.getParameters();
                    List<GwServiceParamDO> list = Arrays.stream(params).map(parameter -> {
                        GwServiceParamDO gwServiceParamDO = new GwServiceParamDO();
                        gwServiceParamDO.setParamClass(parameter.getType().getName());
//                        gwServiceParamDO.setParamClass(parameter.getParameterizedType().getTypeName());
                        gwServiceParamDO.setParamName(parameter.getName());
                        return gwServiceParamDO;
                    }).collect(Collectors.toList());
                    MethodParamsInfo methodParamsInfo = new MethodParamsInfo();
                    methodParamsInfo.setGwServiceParamDOList(list);
                    methodParamsInfo.setMethodName(method.getName());
                    methodParamsInfos.add(methodParamsInfo);
                });
                map.put(className, methodParamsInfos);
            }
        } catch (Throwable e) {
            logger.error("", e);
        }
    }

    public ConcurrentHashMap<String, List<MethodParamsInfo>> getMap() {
        return map;
    }
}
