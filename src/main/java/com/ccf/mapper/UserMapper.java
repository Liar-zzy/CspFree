package com.ccf.mapper;

import com.ccf.pojo.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 登录
     */
    @Select("select * from user where id=#{sid} and password = #{password}")
    User userLogin(@Param("sid") String sid, @Param("password") String password);

    /**
     * 修改密码
     */
    @Update("update user set password = #{password}")
    void userChangePasswd(String password);

    /**
     * 修改身份证
     */
    @Update("update user set identify = #{identify}")
    void userChangeIdentify(String identify);

    /**
     * 修改报名状态
     */
    @Update("update user set isSignUp = #{isSignUp} where id = #{sid}")
    void userSignUp(int isSignUp,String sid);

    /**
     * 上传成绩
     */
    @Update("update studentgrade set session = #{session},grade = #{grade}")
    void userUpdateScore(int grade,int session);
    //怎么上传不了啊，我裂开了

    /**
     * 修改信息
     * */
    int UpdateInfo(@Param("updateInfo") User user);

    /**
     * 查询所有学生
     * */
    List<User> getAllStu();

    /**
     * 查询所有老师
     * */
    List<User> getAllTeacher();
}
