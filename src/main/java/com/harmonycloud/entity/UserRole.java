package com.harmonycloud.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(value = "userrole")
public class UserRole {
    @Id
    @ApiModelProperty(value = "roleid",example = "1")
    private Integer roleId;
    @Column(name = "role_name")
    @ApiModelProperty(value = "userRoleName",example = "Clerical staff")
    private String userRoleName;
    @Column(name = "role_desc")
    @ApiModelProperty(value = "userRoleDesc",example = "1")
    private String userRoleDesc;
    @Column(name = "role_status")
    @ApiModelProperty(value = "userRoleStatus",example = "1")
    private String userRoleStatus;
    @Column(name = "clinic_id")
    @ApiModelProperty(value = "clinicId",example = "1")
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

}
