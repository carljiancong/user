package com.harmonycloud.entity;

import javax.persistence.*;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Entity
@Table(name = "user_role")
public class UserUserrole {
    @Id
    private Integer userRoleId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;

    public UserUserrole() {
    }

    public UserUserrole(Integer userRoleId, Integer userId, Integer roleId) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
