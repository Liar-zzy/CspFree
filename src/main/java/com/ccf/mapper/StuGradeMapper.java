package com.ccf.mapper;

import com.ccf.pojo.StuGrade;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuGradeMapper {
    /**
     * 查询成绩（按不同的届数）session
     */
    @Select("select grade from studentgrade where session = #[session]")
    void findGradeBySession(int session);
    /**
    * 上传场次以及成绩
    * */
    int AddGrade(@Param("stuGrade") StuGrade stugrade);

    /**
     * 按届数查询成绩
     * */
    List<StuGrade> getAllGrade(@Param("getAll") int session);

    /**
     * 查询自己的成绩
     */
    List<StuGrade> getSelfGrade(@Param("selfGrade") String sid);

}
