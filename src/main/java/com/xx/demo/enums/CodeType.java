package com.xx.demo.enums;

public enum CodeType {

    /**
     * 状态码
     */
    SUCCEED(0,"Succeed"),
    INTERNAL_ERROR(1,"Internal Error"),
    PARAM_ERROR(2,"Param Error"),
    REQUEST_ERROR(3,"request Error");


    private int code;
    private String msg;

    CodeType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
