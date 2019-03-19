package com.harmonycloud.enums;


public enum ErrorMsgEnum {

    SERVICE_ERROR("Internal service error"),
    USER_NOT_EXIST("User not exist"),
    PASSWORD_ERROR("Password error"),
    PARAMETER_ERROR("Parameter error");
    private String message;

    ErrorMsgEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
