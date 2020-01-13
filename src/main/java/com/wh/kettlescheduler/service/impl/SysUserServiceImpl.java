package com.wh.kettlescheduler.service.impl;

import com.wh.kettlescheduler.dto.UserLoginDTO;
import com.wh.kettlescheduler.entity.User;
import com.wh.kettlescheduler.repository.UserRepository;
import com.wh.kettlescheduler.service.SysUserService;
import com.wh.kettlescheduler.utils.PageHelper;
import com.wh.kettlescheduler.utils.PageOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void add(UserLoginDTO userLoginDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteBatch(List<Integer> ids) {

    }

    @Override
    public void update(UserLoginDTO userLoginDTO) {

    }

    @Override
    public PageOut<UserLoginDTO> findUserListByPage(UserLoginDTO userLoginDTO, PageHelper page) {
        return null;
    }

    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account);
    }
}
