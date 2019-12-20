package com.ccf.service;

import com.ccf.pojo.FreeList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FreeListService {

    /**
     * 获取免费名单
     */
    List<FreeList> getFreelist();

    /**
     * 获取单个学生免费名单
     */
    List<FreeList> getAFreelist(@Param("name") String name);

}
