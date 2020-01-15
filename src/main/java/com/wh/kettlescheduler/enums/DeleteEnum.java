package com.wh.kettlescheduler.enums;

import com.wh.kettlescheduler.enums.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 删除标记枚举
 *
 * @author lyf
 */
@Getter
@AllArgsConstructor
public enum DeleteEnum implements BaseEnum<Integer> {
    /**
     * 未删除
     */
    YES(1, "已删除"),
    /**
     * 已删除
     */
    NO(0, "未删除");

    private Integer code;
    private String desc;

    public static DeleteEnum getEnum(Integer code) {
        return Arrays.stream(values()).filter(b -> Objects.equals(b.code, code)).findFirst().orElse(null);
    }

    public static String getEnumDesc(Integer code) {
        DeleteEnum e = getEnum(code);
        return e != null ? e.desc : null;
    }
}
