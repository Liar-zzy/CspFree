package com.cspfree.mapper;

import com.cspfree.pojo.Student;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper {
    /**
     * 登录
     */
    @Select("select * from student where sid=#{sid} and password = #{password}")
    Student studentLogin(@Param("sid") String sid, @Param("password") String password);

    /**
     * 修改密码
     */
    @Update("update student set password = #{password}")
    void stuChangePasswd(String password);

    /**
     * 修改身份证
     */
    @Update("update student set identify = #{identify}")
    void stuChangeIdentify(String identify);

    /**
     * 修改报名状态
     */
    @Update("update student set isSignUp = #{isSignUp} where sid = #{sid}")
    void stuSignUp(int isSignUp,String sid);

    /**
     * 上传成绩
     */
    @Update("update studentgrade set session = #{session},grade = #{grade}")
    void stuUpdateScore(int grade,int session);
}
