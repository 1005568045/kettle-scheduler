package com.wh.kettlescheduler.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局接口返回代码
 * @author wuhe
 * @date 2020年1月11日15:19:58
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(0000, "成功"),
    FAIL(0001, "未找到数据"),
    /**
     * 系统处理业务的执行状态：参数校验失败
     */
    ERROR_PARAM(0002, "参数校验失败"),
    /**
     * 系统处理业务的执行状态：非法请求
     */
    ILLEGAL_REQUEST(0003, "非法请求"),
    /**
     * 系统处理业务的执行状态：未登录或登录Session过期
     */
    NOT_LOGIN(0004, "未登录或登录Session过期"),
    /**
     * 系统处理业务的执行状态：未登录或登录Session过期
     */
    ILLEGAL_STATE(0005, "无效状态"),
    /**
     * 系统处理业务的执行状态：超时
     */
    TIMEOUT(1111, "超时"),
    /**
     * 系统保存数据的时候违反唯一值约束
     */
    DATA_INTEGRITY_ERROR(9996, "违反唯一值约束"),
    /**
     * 系统处理quartz定时任务执行状态：失败
     */
    QUARTZ_ERROR(9997, "定时任务执行异常"),
    /**
     * 系统处理ETL执行状态：失败
     */
    KETTLE_ERROR(9998, "ETL执行异常"),
    /**
     * 系统处理业务的执行状态：系统错误
     */
    SYS_ERROR(9999, "系统错误");
    ;
    private int code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
