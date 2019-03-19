package com.harmonycloud.bo;

public class UserBo {
    private Integer userId;
    private String englishSurname;
    private String englishGivenName;
    private String loginName;
    private Integer roleId;
    private String roleName;
    private String userRoleDesc;
    private String userRoleStatus;
    private Integer clinicId;
    private Integer accessRightId;
    private String accessRightType;
    private String accessRightName;

    public UserBo(Integer userId, String englishSurname, String englishGivenName, String loginName, Integer roleId, String roleName,
                  String userRoleDesc, String userRoleStatus, Integer clinicId, Integer accessRightId, String accessRightType, String accessRightName) {
        this.userId = userId;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.loginName = loginName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoleDesc = userRoleDesc;
        this.userRoleStatus = userRoleStatus;
        this.clinicId = clinicId;
        this.accessRightId = accessRightId;
        this.accessRightType = accessRightType;
        this.accessRightName = accessRightName;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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


}
