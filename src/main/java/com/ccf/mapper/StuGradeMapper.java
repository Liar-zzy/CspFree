package com.ccf.mapper;

import com.ccf.pojo.StuGrade;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

public interface StuGradeMapper {
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


    /**
    * 上传场次以及成绩
    * */
    int AddGrade(@Param("stuGrade") StuGrade stugrade);

    /**
     * 导入excel文件写入数据库
     */
    @Update("insert into studentgrade(sid,grade,session,First,Second,Third,Fourth,Fifth) values(#{sid},#{grade},#{session},#{First},#{Second},#{Third},#{Fourth},#{Fifth})")
    void StuGradeUpload(StuGrade stuGrade);
}
