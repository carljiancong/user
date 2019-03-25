package com.harmonycloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer clinicId;

    public UserRole() {
    }

    public UserRole(Integer roleId, String userRoleName, String userRoleDesc, String userRoleStatus, Integer clinicId) {
        this.roleId = roleId;
        this.userRoleName = userRoleName;
        this.userRoleDesc = userRoleDesc;
        this.userRoleStatus = userRoleStatus;
        this.clinicId = clinicId;
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

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", userRoleName='" + userRoleName + '\'' +
                ", userRoleDesc='" + userRoleDesc + '\'' +
                ", userRoleStatus='" + userRoleStatus + '\'' +
                ", clinicId=" + clinicId +
                '}';
    }
}
