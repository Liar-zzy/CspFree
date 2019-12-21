package com.ccf.service;

import com.ccf.pojo.RedList;

public interface RedListService {

    /**
     * 红名单插入
     * */
    boolean addIntoRedList(RedList redList);

    /**
     * 清楚数据
     * */
    boolean ClearRedList();
}

