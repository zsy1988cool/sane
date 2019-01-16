package com.sane.partake.core.result;

public class ResultModel {
    public static final String SUCCESS_CODE;
    public static final String ERROR_CODE;
    public static final String WARN_CODE;
    public static final String WARN_OPERATOR_CODE;
    private String code;
    private Object data;
    private String message;
    private String error;

    public ResultModel() {
        this.code = SUCCESS_CODE;
    }

    public ResultModel(String code, Object data, String message, String error) {
        this.code = SUCCESS_CODE;
        this.code = code;
        this.data = data;
        this.message = message;
        this.error = error;
    }

    public static ResultModel success(String message, Object data) {
        return new ResultModel(SUCCESS_CODE, data, message, "");
    }

    public static ResultModel success(Object data) {
        return new ResultModel(SUCCESS_CODE, data, "", "");
    }

    public static ResultModel success() {
        return new ResultModel(SUCCESS_CODE, (Object)null, "", "");
    }

    public static ResultModel fail(String message, String error) {
        return new ResultModel(ERROR_CODE, (Object)null, message, error);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return null != this.data && !"null".equals(this.data) ? this.data : "";
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    static {
        SUCCESS_CODE = ResponseCodeEnum.SUCCESS.getCode();
        ERROR_CODE = ResponseCodeEnum.BIZ_ERROR.getCode();
        WARN_CODE = ResponseCodeEnum.WARN.getCode();
        WARN_OPERATOR_CODE = ResponseCodeEnum.WARN_OPERATOR.getCode();
    }
}
