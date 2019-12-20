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
    List<StuGrade> ListAllGradeBySession(@Param("getAll") int session);
}
