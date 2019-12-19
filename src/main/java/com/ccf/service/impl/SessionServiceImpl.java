package com.ccf.service.impl;

import com.ccf.mapper.SessionMapper;
import com.ccf.pojo.Session;
import com.ccf.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SessionService")
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public String getSession(int sessionId) {
        Session session = sessionMapper.getSession(sessionId);
        return session.getName();
    }
}
