package com.ccf.service;

import com.ccf.pojo.User;

import java.util.List;


public interface UserService {
    /**
     * 学生登录
     */
    User userLogin(String sid, String password);

    /**
     * 学生修改密码
     */
    void userChangePasswd(String password);

    /**
     * 修改身份证号
     */
    void userChangeIdentify(String identify);

    /**
     * 修改报名状态
     */
    void userSignUp(int isSignUp,String sid);

    /**
     * 上传成绩
     */
    void userUpdateScore(int grade,int session);

    /**
     * 更新个人信息
     * */
    boolean UpdateInfo(User user);

    /**
     * 查询所有学生
     * */
    List<User> getAllStu();

    /**
     * 查询所有老师
     * */
    List<User> getAllTeacher();
}
