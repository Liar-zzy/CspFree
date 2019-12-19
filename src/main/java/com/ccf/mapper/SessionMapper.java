package com.ccf.mapper;

import com.ccf.pojo.Session;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionMapper {

    /**
     * 获取届数
     * */
    Session getSession(@Param("sessionId") int sessionId);
}
