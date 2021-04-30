package com.young.demo.service;

import com.young.demo.mapper.UserMapper;
import com.young.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public User aaa(Long id) {
        return userMapper.abc(id);
    }
}
