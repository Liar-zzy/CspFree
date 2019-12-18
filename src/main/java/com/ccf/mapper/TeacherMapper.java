package com.ccf.mapper;

import com.ccf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    /**
     * 添加用户
     * */
    int AddTeacher(@Param("SignUp")Teacher teacher);
    /**
     * 删除用户
     * */
    int deleteTeacher(@Param("SignOut") String aid);
    /**
     * 登陆检查
     * */
    Teacher QueryTeacher(@Param("tSignIn")Teacher teacher);

}
