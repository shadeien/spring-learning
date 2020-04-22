package com.shadeien.learning.spring.base.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutoSyncModel implements Serializable {
    private String url;
    private String module;
}
