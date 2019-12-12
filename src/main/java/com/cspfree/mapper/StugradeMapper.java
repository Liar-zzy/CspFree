package com.cspfree.mapper;

import org.apache.ibatis.annotations.Select;

public interface StugradeMapper {
    /**
     * 查询成绩（按不同的届数）session
     */
    @Select("select grade from studentgrade where session = #[session]")
    void findGradeBySession(int session);
}
