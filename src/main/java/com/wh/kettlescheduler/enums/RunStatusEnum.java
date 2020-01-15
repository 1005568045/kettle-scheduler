package com.wh.kettlescheduler.enums;

import com.wh.kettlescheduler.enums.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 运行状态枚举类
 *
 * @author lyf
 */
@Getter
@AllArgsConstructor
public enum RunStatusEnum implements BaseEnum<Integer> {
    /**
     * 运行
     */
    RUN(1, "运行"),
    /**
     * 停止
     */
    STOP(2, "停止");

    private Integer code;
    private String desc;

    public static RunStatusEnum getEnum(Integer code) {
        return Arrays.stream(values()).filter(b -> Objects.equals(b.code, code)).findFirst().orElse(null);
    }

    public static String getEnumDesc(Integer code) {
        RunStatusEnum e = getEnum(code);
        return e != null ? e.desc : null;
    }
}
