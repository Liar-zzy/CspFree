package com.ccf.mapper;

import com.ccf.pojo.RedList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RedListMapper {

    /**
     * 红名单插入
     * */
    int addIntoRed(@Param("addRed") RedList redList);


    /**
     * 清楚数据
     * */
    int ClearRed();
}
