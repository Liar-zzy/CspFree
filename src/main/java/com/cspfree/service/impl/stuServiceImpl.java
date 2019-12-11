package com.cspfree.service.impl;

import com.cspfree.mapper.StuMapper;
import com.cspfree.pojo.Student;

import com.cspfree.service.stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stuService")
public class stuServiceImpl implements stuService {
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
