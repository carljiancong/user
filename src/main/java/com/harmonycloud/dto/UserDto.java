package com.harmonycloud.dto;

import com.harmonycloud.entity.AccessRight;
import com.harmonycloud.entity.UserRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.List;

@ApiModel(value = "UserDto")
public class UserDto {
    @ApiModelProperty(value = "userid",example = "1")
    private Integer userId;
    @ApiModelProperty(value = "englishSurname",example = "a")
    private String englishSurname;
    @ApiModelProperty(value = "englishGivenName",example = "a")
    private String englishGivenName;
    @ApiModelProperty(value = "loginName",example = "a")
    private String loginName;
    private List<UserRole> userRoles;
    private List<AccessRight> accessRights;

    public UserDto(Integer userId, String englishSurname, String englishGivenName, String loginName, List<UserRole> userRoles, List<AccessRight> accessRights) {
        this.userId = userId;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.loginName = loginName;
        this.userRoles = userRoles;
        this.accessRights = accessRights;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEnglishSurname() {
        return englishSurname;
    }

    public void setEnglishSurname(String englishSurname) {
        this.englishSurname = englishSurname;
    }

    public String getEnglishGivenName() {
        return englishGivenName;
    }

    public void setEnglishGivenName(String englishGivenName) {
        this.englishGivenName = englishGivenName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<AccessRight> getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(List<AccessRight> accessRights) {
        this.accessRights = accessRights;
    }
}
