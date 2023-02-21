package com.kk.commons;

import com.kk.commons.enums.CodeMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * com.kk.commons.Result
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@ApiModel( value = "com.kk.commons.Result", description = "返回结果集")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3000699858540016379L;
    @ApiModelProperty("状态码, 0失败 1成功")
    private Integer status;
    @ApiModelProperty("业务码")
    private Long code;
    @ApiModelProperty("提示信息")
    private String message;
    @ApiModelProperty("返回数据集")
    private T data;

    public Result() {
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message == null ? "" : this.message;
    }

    public void success(T data) {
        this.status = StatusEnum.SUCCEED.getValue();
        this.data = data;
        this.code = 0L;
        this.message = "";
    }

    public void failure(CodeMsg codeMsg) {
        this.status = StatusEnum.FAILED.getValue();
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }

    public void failure(CodeMsg codeMsg, Object... msgParams) {
        this.status = StatusEnum.FAILED.getValue();
        this.code = codeMsg.getCode();
        this.message = String.format(codeMsg.getMessage(), msgParams);
    }

    public void failure(Long code, String message) {
        this.status = StatusEnum.FAILED.getValue();
        this.code = code;
        this.message = message;
    }

    public void failure(CodeMsg codeMsg, T data) {
        this.status = StatusEnum.FAILED.getValue();
        this.data = data;
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getCode() {
        return this.code;
    }

    static enum StatusEnum {
        FAILED(0),
        SUCCEED(1);

        private Integer value;

        private StatusEnum(Integer iValue) {
            this.value = iValue;
        }

        public Integer getValue() {
            return this.value;
        }
    }
}