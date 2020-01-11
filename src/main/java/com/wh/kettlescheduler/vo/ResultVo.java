package com.wh.kettlescheduler.vo;

import com.wh.kettlescheduler.enums.ResultCode;
import lombok.Data;

/**
 * 全局接口返回对象
 * @author wuhe
 * @date 2020年1月11日15:19:58
 */
@Data
public class ResultVo {
    private Object data;
    private int code;
    private String msg;
    private long timestamp;

    public ResultVo(ResultCode resultCode, Object data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static ResultVo success(Object data){
        return new ResultVo(ResultCode.SUCCESS, data);

    }
    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo failure(Object data){
        return new ResultVo(ResultCode.FAIL, data);

    }
    public static ResultVo failure(){
        return failure(null);

    }
}
