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
    public static CodeMsg PASSWORD_ERROR = new CodeMsg("password wrong");
    public static CodeMsg LOGIN_FAIL = new CodeMsg("login failed");

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    /**
//     * clinic service
//     */
//    public static CodeMsg LIST_FAIL = new CodeMsg("list failed");

    @Override
    public String toString() {
        return "msg=" + msg;
    }
}
