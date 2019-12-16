package com.ccf.service.impl;

import com.ccf.mapper.StuMapper;
import com.ccf.pojo.Student;

import com.ccf.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper sMapper;

    @Override
    public Student studentLogin(String sid, String password) {
        return sMapper.studentLogin(sid,password);
    }

    @Override
    public void stuChangePasswd(String password) {
        sMapper.stuChangePasswd(password);
    }

    @Override
    public void stuChangeIdentify(String identify) {
        sMapper.stuChangeIdentify(identify);
    }

    @Override
    public void stuSignUp(int isSignUp, String sid) {
        sMapper.stuSignUp(isSignUp, sid);
    }

    @Override
    public void stuUpdateScore(int grade, int session) {
        sMapper.stuUpdateScore(grade, session);
    }
}
