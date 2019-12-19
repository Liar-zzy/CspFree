package com.ccf.service;

import com.ccf.pojo.FreeList;

import java.util.List;

public interface FreeListService {


    /**
     * 获取免费名单
     * */
    List<FreeList> getFreelist();
}
