package com.harmonycloud.result;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class CodeMsg {
    private String msg;

    public CodeMsg(String msg) {
        this.msg = msg;
    }

    /**
     * user service
     */
    public static CodeMsg USER_NOT_EXIST = new CodeMsg("User not exist");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg("Password is wrong");
    public static CodeMsg FAIL = new CodeMsg("Service error");

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
