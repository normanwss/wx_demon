package com.example.wc.model;

import java.io.Serializable;
import java.util.Date;

public class AuthOrg implements Serializable {
    private Integer orgId;

    private Integer parentId;

    private String orgName;

    private String orgType;

    private String orgTypeVal;

    private Integer level;

    private Boolean enabled;

    private Integer businessId;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getOrgTypeVal() {
        return orgTypeVal;
    }

    public void setOrgTypeVal(String orgTypeVal) {
        this.orgTypeVal = orgTypeVal == null ? null : orgTypeVal.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}