package com.cspfree.service.impl;

import com.cspfree.mapper.StuMapper;
import com.cspfree.pojo.student;
import com.cspfree.service.stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stuService")
public class stuServiceImpl implements stuService {
    @Autowired
    private StuMapper sMapper;

    @Override
    public student studentLogin(String sid, String password) {
        return sMapper.studentLogin(sid,password);
    }
}
