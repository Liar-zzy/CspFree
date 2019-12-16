package com.ccf.service.impl;

import com.ccf.mapper.StugradeMapper;
import com.ccf.service.StugradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("StugradeService")
public class StugradeServiceImpl implements StugradeService {

    @Autowired
    private StugradeMapper sMapper;

    @Override
    public void findGradeBySession(int session) {
        sMapper.findGradeBySession(session);
    }
}
