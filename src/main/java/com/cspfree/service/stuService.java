package com.cspfree.service;

import com.cspfree.pojo.student;

public interface stuService {
    /**
     * 学生登录
     */
    student studentLogin(String sid,String password);
}
