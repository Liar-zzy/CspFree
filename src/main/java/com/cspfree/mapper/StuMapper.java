package com.cspfree.mapper;

import com.cspfree.pojo.student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper {
    /**
     * 登录
     */
    @Select("select * from student where sid=#{sid} and password = #{password}")
    student studentLogin(@Param("sid") String sid,@Param("password") String password);
}
