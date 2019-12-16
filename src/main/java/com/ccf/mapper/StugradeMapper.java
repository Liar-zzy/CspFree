package com.ccf.mapper;

import org.apache.ibatis.annotations.Select;

public interface StugradeMapper {
    /**
     * 查询成绩（按不同的届数）session
     */
    @Select("select grade from studentgrade where session = #[session]")
    void findGradeBySession(int session);

    /**
     * 查询最佳成绩
     */
    void findBestGrade(String sid);

    /**
     * 查找上一次成绩，按找学生的账号
     */
    void findLastGrade(String sid);

}
