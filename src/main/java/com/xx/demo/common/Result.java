package com.xx.demo.common;

import com.xx.demo.enums.CodeType;
import lombok.Data;

/**
 * @author Lwx
 * @apiNote 响应结果
 */
@Data
public class Result {

    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result createResultError(CodeType codeType){
        return new Result(codeType.getCode(),codeType.getMsg());
    }

    public static Result succeedResult(Object data){
        return new Result(CodeType.SUCCEED.getCode(), CodeType.SUCCEED.getMsg(),data);
    }

    public static Result customResult(int code, String msg){
        return new Result(code,msg);
    }
}
