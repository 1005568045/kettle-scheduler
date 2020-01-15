package com.wh.kettlescheduler.controller;

import com.wh.kettlescheduler.entity.User;
import com.wh.kettlescheduler.exception.MyMessageException;
import com.wh.kettlescheduler.service.SysUserService;
import com.wh.kettlescheduler.utils.BeanUtil;
import com.wh.kettlescheduler.vo.response.ResultVo;
import com.wh.kettlescheduler.vo.response.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 * @author wuhe
 */
@RestController
@RequestMapping("/sys/user")
@Api(tags = "用户管理API")
public class UserController {
    @Autowired
    private SysUserService userService;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    @ApiOperation(value = "查询用户明细")
    @GetMapping("/getUserByUsername")
    public ResultVo getUserByUsername(@RequestParam("username") String username){
        User user = userService.getUserByAccount(username);
        if (user!=null) {
            return ResultVo.success(BeanUtil.copyProperties(user, UserRes.class));
        } else {
            throw new MyMessageException("用户信息不存在");
        }
    }


}
