package com.harmonycloud.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author qidong
 * @date 2019/2/13
 */


@Entity
@Table(name = "role")
public class UserRole {
    @Id
    private Integer roleId;
    @Column(name = "role_name")
    private String userRoleName;
    @Column(name = "role_desc")
    private String userRoleDesc;
    @Column(name = "role_status")
    private String userRoleStatus;
    @Column(name = "clinic_id")
    private Integer clincId;

    public UserRole() {
    }

    public UserRole(Integer roleId, String userRoleName, String userRoleDesc, String userRoleStatus, Integer clincId) {
        this.roleId = roleId;
        this.userRoleName = userRoleName;
        this.userRoleDesc = userRoleDesc;
        this.userRoleStatus = userRoleStatus;
        this.clincId = clincId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserRoleDesc() {
        return userRoleDesc;
    }

    public void setUserRoleDesc(String userRoleDesc) {
        this.userRoleDesc = userRoleDesc;
    }

    public String getUserRoleStatus() {
        return userRoleStatus;
    }

    public void setUserRoleStatus(String userRoleStatus) {
        this.userRoleStatus = userRoleStatus;
    }

    public Integer getClincId() {
        return clincId;
    }

    public void setClincId(Integer clincId) {
        this.clincId = clincId;
    }
}
