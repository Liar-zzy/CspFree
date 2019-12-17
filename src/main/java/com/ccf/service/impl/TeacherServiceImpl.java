package com.ccf.service.impl;

import com.ccf.mapper.TeacherMapper;
import com.ccf.pojo.Teacher;
import com.ccf.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    public TeacherMapper teacherMapper;

    @Override
    public boolean AddTeacher(Teacher teacher) {
        int row = teacherMapper.AddTeacher(teacher);
        return row == 1 ? true : false;
    }

    @Override
    public boolean DeleteTeacher(Teacher teacher) {
        int row = teacherMapper.deleteTeacher(teacher.getTid());
        return row == 1 ? true : false;
    }

    @Override
    public Teacher TeacherSignIn(Teacher teacher) {
        Teacher t = teacherMapper.QueryTeacher(teacher);
        return t;
    }
}
