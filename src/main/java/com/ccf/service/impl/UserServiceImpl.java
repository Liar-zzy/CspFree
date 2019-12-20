package com.ccf.service.impl;

import com.ccf.mapper.UserMapper;
import com.ccf.pojo.User;

import com.ccf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean UpdateInfo(User user) {
        int row = sMapper.UpdateInfo(user);
        return row == 1? true : false;
    }

    @Override
    public List<User> getAllStu() {
        List<User> list = sMapper.getAllStu();
        return list;
    }

    @Override
    public List<User> getAllTeacher() {
        List<User> list = sMapper.getAllTeacher();
        return list;
    }

    @Override
    public boolean ChangeRightOfTeacher(String tid) {
        int row = sMapper.ChangeRight(tid);
        return row == 1 ? true : false;
    }

    @Override
    public boolean deleteUser(String id) {
        int row = sMapper.deleteUser(id);
        return row == 1 ? true : false;
    }
}
