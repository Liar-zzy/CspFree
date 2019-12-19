package com.ccf.service;

import com.ccf.pojo.StuGrade;

public interface StugradeService {

    /**
     * 按年份查找成绩
     * @param session
     */
    void findGradeBySession(int session);


    /**
     * 插入成绩
     * */
    boolean AddStuGrade(StuGrade stuGrade);

    /**
     * 上传学生成绩
     * @param stuGrade
     */
    void StuGradeUpload(StuGrade stuGrade);
}
