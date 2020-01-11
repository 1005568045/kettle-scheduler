package com.wh.kettlescheduler.controller;

import com.wh.kettlescheduler.dto.UserLoginDTO;
import com.wh.kettlescheduler.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录和注销controller
 * @author wuhe
 * @date 2020年1月11日15:14:05
 */
@Api(tags = "登录鉴权API")
@RestController
@RequestMapping("/sys")
public class LoginController {


    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public ResultVo login( @ApiParam(name = "userLoginDTO", value = "userLoginDTO", required = true)
                               @Validated UserLoginDTO userLoginDTO){
        //获取当前主题
        Subject subject = SecurityUtils.getSubject();
        //根据用户名密码获取token认证信息
        UsernamePasswordToken token = new UsernamePasswordToken(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        //是否自动登录
        if(userLoginDTO.isRememberMe()){
            token.setRememberMe(true);
        }
        subject.login(token);
        Assert.state(subject.isAuthenticated(), "登录失败");
        return ResultVo.success();
    }

    @ApiOperation(value = "用户退出")
    @GetMapping("/out")
    public ResultVo loginOut(){
        //获取当前主题
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultVo.success();
    }
}
