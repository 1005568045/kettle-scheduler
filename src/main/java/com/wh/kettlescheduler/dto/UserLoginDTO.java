package com.wh.kettlescheduler.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录参数
 * @author wuhe
 * @date 2020年1月11日15:28:55
 */
@Data
@ApiModel(value = "用户登录-入参")
public class UserLoginDTO {

    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号")
    @NotBlank(message = "登录账号不能是空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能是空")
    private String password;

    /**
     * 自动登录
     */
    @ApiModelProperty(value = "自动登录")
    private boolean rememberMe;
}
