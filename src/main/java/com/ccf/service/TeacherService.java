package com.ccf.service;

import com.ccf.pojo.Teacher;

public interface TeacherService {
    /**
     * 添加教师
     * */
    boolean AddTeacher(Teacher teacher);

    /**
     * 删除
     * */
    boolean DeleteTeacher(Teacher teacher);

    /**
     * 登录查询
     * */
    Teacher TeacherSignIn(Teacher teacher);
}
