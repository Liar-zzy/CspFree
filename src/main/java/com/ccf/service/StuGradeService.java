package com.ccf.service;

import com.ccf.pojo.StuGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuGradeService {

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
     * 按届数查询成绩
     * */
    List<StuGrade> ListAllGradeBySession(int session);

    /**
     * 查询自己成绩
     * */
    List<StuGrade> ListSelfGrade(String sid);

    /**
     * 上传学生成绩
     * @param stuGrade
     */
    void StuGradeUpload(StuGrade stuGrade);
}
