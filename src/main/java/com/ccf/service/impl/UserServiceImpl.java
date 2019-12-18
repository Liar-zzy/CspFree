package com.ccf.service.impl;

import com.ccf.mapper.UserMapper;
import com.ccf.pojo.User;

import com.ccf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper sMapper;

    @Override
    public User userLogin(String sid, String password) {
        return sMapper.userLogin(sid,password);
    }

    @Override
    public void userChangePasswd(String password) {
        sMapper.userChangePasswd(password);
    }

    @Override
    public void userChangeIdentify(String identify) {
        sMapper.userChangeIdentify(identify);
    }

    @Override
    public void userSignUp(int isSignUp, String sid) {
        sMapper.userSignUp(isSignUp, sid);
    }

    @Override
    public void userUpdateScore(int grade, int session) {
        sMapper.userUpdateScore(grade, session);
    }
}
