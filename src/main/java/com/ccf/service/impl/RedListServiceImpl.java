package com.ccf.service.impl;

import com.ccf.mapper.RedListMapper;
import com.ccf.pojo.RedList;
import com.ccf.service.RedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("RedListService")
public class RedListServiceImpl implements RedListService {

    @Autowired
    private RedListMapper redListMapper;

    @Override
    public boolean addIntoRedList(RedList redList) {
        int row = redListMapper.addIntoRed(redList);
        return row == 1 ? true : false;
    }
}
