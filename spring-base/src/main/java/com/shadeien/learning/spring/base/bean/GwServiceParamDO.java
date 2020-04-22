package com.shadeien.learning.spring.base.bean;

public class GwServiceParamDO {
    private Long paramUkid;

    private String paramName;

    private String paramClass;

    private String paramType;

    private Byte paramInoutype;

    private Long serviceUkid;

    private Integer paramOrder;

    private Long paramParentUkid;

    public Long getParamUkid() {
        return paramUkid;
    }

    public void setParamUkid(Long paramUkid) {
        this.paramUkid = paramUkid;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamClass() {
        return paramClass;
    }

    public void setParamClass(String paramClass) {
        this.paramClass = paramClass == null ? null : paramClass.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public Byte getParamInoutype() {
        return paramInoutype;
    }

    public void setParamInoutype(Byte paramInoutype) {
        this.paramInoutype = paramInoutype;
    }

    public Long getServiceUkid() {
        return serviceUkid;
    }

    public void setServiceUkid(Long serviceUkid) {
        this.serviceUkid = serviceUkid;
    }

    public Integer getParamOrder() {
        return paramOrder;
    }

    public void setParamOrder(Integer paramOrder) {
        this.paramOrder = paramOrder;
    }

    public Long getParamParentUkid() {
        return paramParentUkid;
    }

    public void setParamParentUkid(Long paramParentUkid) {
        this.paramParentUkid = paramParentUkid;
    }
}