package com.kk.commons.enums;

import java.io.Serializable;

/**
 * com.kk.commons.enums.CodeMsg
 *
 * @author juejin
 * @datetime 2023/2/21
 */
public class CodeMsg implements Serializable {
    private static final long serialVersionUID = -7241354606203046592L;
    private Long code;
    private String message;

    public Long getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public CodeMsg() {
    }

    public CodeMsg(Long code, String message) {
        this.code = code;
        this.message = message;
    }

}