package com.ccf.service;

import com.ccf.pojo.Student;


public interface StuService {
    /**
     * 学生登录
     */
    Student studentLogin(String sid, String password);

    /**
     * 学生修改密码
     */
    void stuChangePasswd(String password);

    /**
     * 修改身份证号
     */
    void stuChangeIdentify(String identify);

    /**
     * 修改报名状态
     */
    void stuSignUp(int isSignUp,String sid);

    /**
     * 上传成绩
     */
    void stuUpdateScore(int grade,int session);
}
