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
    private String errormessage;
    @ApiModelProperty(value = "是否成功", example = "true")
    private boolean success;
//    @ApiModelProperty(value = "返回信息", )
    private Object data;

    public Result(String errormessage, Object data, boolean success) {
        this.errormessage = errormessage;
        this.success = success;
        this.data = data;
    }


    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
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

    public static Result buildError(String errormessage, Object errorData) {
        return new Result(errormessage, errorData, false);
    }

    public static Result buildSuccess(Object data) {
        return new Result(null, data, true);
    }
}
