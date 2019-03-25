package com.harmonycloud.entity;

import javax.persistence.*;

@Entity
@Table(name = "access_right")
public class AccessRight {
    @Id
    private Integer accessRightId;
    @Column(name = "access_right_type")
    private String accessRightType;
    @Column(name = "access_right_name")
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
