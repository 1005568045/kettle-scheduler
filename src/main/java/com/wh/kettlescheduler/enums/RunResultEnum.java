package com.wh.kettlescheduler.enums;

import com.wh.kettlescheduler.enums.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 运行结果枚举类
 *
 * @author lyf
 */
@Getter
@AllArgsConstructor
public enum RunResultEnum implements BaseEnum<Integer> {
    /**
     * 资源库方式运行
     */
    SUCCESS(1, "运行成功"),
    /**
     * 文件方式运行
     */
    FAIL(0, "运行失败");

    private Integer code;
    private String desc;

    public static RunResultEnum getEnum(Integer code) {
        return Arrays.stream(values()).filter(b -> Objects.equals(b.code, code)).findFirst().orElse(null);
    }

    public static String getEnumDesc(Integer code) {
        RunResultEnum e = getEnum(code);
        return e != null ? e.desc : null;
    }
}
