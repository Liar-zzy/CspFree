package com.ccf.service;

import com.ccf.pojo.User;
import org.apache.ibatis.annotations.Param;

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
    boolean userSignUp(String isSignUp,String sid);

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

    /**
     * 权限设置 老师->管理员
     * */
    boolean ChangeRightOfTeacher(String tid);

    /**
     * 删除用户
     * */
    boolean deleteUser(String id);

    /**
     * 查询个人信息
     * */
    User GetAUser(String id);
}
