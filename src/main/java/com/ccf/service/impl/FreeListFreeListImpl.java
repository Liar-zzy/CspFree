package com.ccf.service.impl;

import com.ccf.mapper.FreeListMapper;
import com.ccf.pojo.FreeList;
import com.ccf.service.FreeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FreeListService")
public class FreeListFreeListImpl implements FreeListService {

    @Autowired
    private FreeListMapper freeListMapper;

    @Override
    public List<FreeList> getFreelist() {
        List<FreeList> list = freeListMapper.getFreeList();
        return list;
    }

    @Override
    public List<FreeList> getAFreelist(String name) {
        List<FreeList> list = freeListMapper.getAFreeList(name);
        return list;
    }

}
