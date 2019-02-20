package com.harmonycloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "access_right")
@ApiModel(value = "access_right")
public class AccessRight {
    @Id
    @ApiModelProperty(value = "accessRightId",example = "1")
    private Integer accessRightId;
    @Column(name = "access_right_type")
    @ApiModelProperty(value = "accessRightType",example = "menu_function")
    private String accessRightType;
    @Column(name = "access_right_name")
    @ApiModelProperty(value = "accessRightName",example = "Registration")
    private String accessRightName;

    public AccessRight() {
    }
    public AccessRight(Integer accessRightId, String accessRightType, String accessRightName) {
        this.accessRightId = accessRightId;
        this.accessRightType = accessRightType;
        this.accessRightName = accessRightName;
    }

    public Integer getAccessRightId() {
        return accessRightId;
    }

    public void setAccessRightId(Integer accessRightId) {
        this.accessRightId = accessRightId;
    }

    public String getAccessRightType() {
        return accessRightType;
    }

    public void setAccessRightType(String accessRightType) {
        this.accessRightType = accessRightType;
    }

    public String getAccessRightName() {
        return accessRightName;
    }

    public void setAccessRightName(String accessRightName) {
        this.accessRightName = accessRightName;
    }
}
