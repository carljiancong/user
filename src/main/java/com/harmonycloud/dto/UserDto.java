package com.harmonycloud.dto;

import com.harmonycloud.entity.AccessRight;
import com.harmonycloud.entity.UserRole;
import io.swagger.annotations.ApiModel;


import java.util.List;

@ApiModel(value = "UserDto")
public class UserDto {
    private Integer userId;

    private String englishSurname;

    private String englishGivenName;

    private String loginName;

    private List<UserRole> userRoleList;

    private List<AccessRight> accessRightList;

    public UserDto() {
    }

    public UserDto(Integer userId, String englishSurname, String englishGivenName, String loginName,
                   List<UserRole> userRoleList, List<AccessRight> accessRightList) {
        this.userId = userId;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.loginName = loginName;
        this.userRoleList = userRoleList;
        this.accessRightList = accessRightList;
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

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<AccessRight> getAccessRightList() {
        return accessRightList;
    }

    public void setAccessRightList(List<AccessRight> accessRightList) {
        this.accessRightList = accessRightList;
    }
}
