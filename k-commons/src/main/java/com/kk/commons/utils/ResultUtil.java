package com.kk.commons.utils;

import com.kk.commons.Result;
import com.kk.commons.enums.CodeMsg;

/**
 * ResultUtils
 *
 * @author juejin
 * @datetime 2023/2/21
 */
public class ResultUtil {
    private ResultUtil() {
    }

    public static <T> Result<T> buildSuccessResult(T data) {
        Result<T> result = new Result();
        result.success(data);
        return result;
    }

    public static Result buildFailureResult(CodeMsg codeMsg) {
        Result result = new Result();
        result.failure(codeMsg);
        return result;
    }

//    public static Result buildFailureResult(String message) {
//        Result result = new Result();
//        result.failure(ErrorCodeEnum.ERROR_CONTEXT.getCode(), message);
//        return result;
//    }

    public static Result buildFailureResult(Long code, String message) {
        Result result = new Result();
        result.failure(code, message);
        return result;
    }

//    public static Result buildFailureResult(PlainResult plainResult) {
//        String message = plainResult.sysError() ? String.format(ErrorCodeEnum.SERVER_GAP.getMessage(), "[" + TraceUtil.getGlobalRequestId() + "]") : plainResult.getMessage();
//        return buildFailureResult(ErrorCodeEnum.ERROR_CONTEXT.getCode(), message);
//    }
//
//    public static Result buildFailureResult(PlainResult plainResult, String defaultMessage) {
//        String message = plainResult.sysError() ? defaultMessage : plainResult.getMessage();
//        return buildFailureResult(ErrorCodeEnum.ERROR_CONTEXT.getCode(), message);
//    }

    public static <T> Result<T> buildFailureResult(CodeMsg codeMsg, T data) {
        Result<T> result = new Result();
        result.failure(codeMsg, data);
        return result;
    }
}