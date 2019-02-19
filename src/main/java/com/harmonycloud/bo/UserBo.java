package com.harmonycloud.bo;

public class UserBo {
    private Integer userId;
    private String englishSurname;
    private String englishGivenName;
    private String loginName;
    private String role;

    public UserBo(Integer userId, String englishSurname, String englishGivenName,
                   String loginName, String role) {
        this.userId = userId;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.loginName = loginName;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
