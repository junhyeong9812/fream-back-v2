package com.fream.back.global.entity;

public class BaseAuditEntity extends BaseTimeEntity {
    private String createdBy;
    private String updatedBy;

    public String getCreatedBy(){
        return createdBy;
    }

    public String getUpdatedBy(){
        return updatedBy;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
}
