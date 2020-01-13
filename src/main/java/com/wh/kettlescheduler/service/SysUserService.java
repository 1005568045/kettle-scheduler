package com.wh.kettlescheduler.service;

import com.wh.kettlescheduler.dto.UserLoginDTO;
import com.wh.kettlescheduler.entity.User;
import com.wh.kettlescheduler.utils.PageHelper;
import com.wh.kettlescheduler.utils.PageOut;

import java.util.List;

/**
 * 用户接口
 */
public interface SysUserService {
    void add(UserLoginDTO userLoginDTO);
    void delete(Integer id);
    void deleteBatch(List<Integer> ids);
    void update(UserLoginDTO userLoginDTO);
    PageOut<UserLoginDTO> findUserListByPage(UserLoginDTO userLoginDTO, PageHelper page);
    User getUserByAccount(String account);
}
