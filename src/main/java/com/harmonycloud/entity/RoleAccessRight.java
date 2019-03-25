package com.harmonycloud.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_accessright")
public class RoleAccessRight {
    @Id
    private Integer roleAccessRightId;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "access_right_id")
    private Integer accessRightId;

    public RoleAccessRight() {
    }

    public RoleAccessRight(Integer roleAccessRightId, Integer roleId, Integer accessRightId) {
        this.roleAccessRightId = roleAccessRightId;
        this.roleId = roleId;
        this.accessRightId = accessRightId;
    }

    public Integer getRoleAccessRightId() {
        return roleAccessRightId;
    }

    public void setRoleAccessRightId(Integer roleAccessRightId) {
        this.roleAccessRightId = roleAccessRightId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAccessRightId() {
        return accessRightId;
    }

    public void setAccessRightId(Integer accessRightId) {
        this.accessRightId = accessRightId;
    }
}
