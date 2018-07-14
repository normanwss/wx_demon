package com.example.wc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AuthRole implements Serializable {

    private String roleId;

    private Integer businessId;

    private String parentId;

    private String roleName;

    private Boolean enabled;

    private Boolean isStore;

    private Boolean isStoreMultiple;

    private String remark;

    private Boolean delFlag;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

}