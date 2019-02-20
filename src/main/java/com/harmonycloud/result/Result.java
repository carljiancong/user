package com.harmonycloud.result;


import com.harmonycloud.dto.UserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author qidong
 * @date 2019/2/15
 */

@ApiModel(value = "返回结果")
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "错误信息", example = "null")
    private Object errorMessage;
    @ApiModelProperty(value = "是否成功", example = "true")
    private boolean success;
    private Object data;


    public Result(CodeMsg errorMessage, Boolean success) {
        this.errorMessage = errorMessage.getMsg();
        this.success = success;
    }

    public Result(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result buildError(CodeMsg errorData){
        return new Result(errorData,false);
    }

    public static Result buildSuccess(Object data){
        return new Result(true, data);
    }

}
