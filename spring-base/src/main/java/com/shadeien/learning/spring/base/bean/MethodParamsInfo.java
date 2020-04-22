package com.shadeien.learning.spring.base.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MethodParamsInfo implements Serializable {
    private String methodName;
    private List<GwServiceParamDO> gwServiceParamDOList;
}
