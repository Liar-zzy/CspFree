package com.cspfree.service.impl;

import com.cspfree.mapper.StugradeMapper;
import com.cspfree.service.StugradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("stugradeService")
public class StugradeServiceImpl implements StugradeService {

    @Autowired
    private StugradeMapper sMapper;

    @Override
    public void findGradeBySession(int session) {
        sMapper.findGradeBySession(session);
    }
}
