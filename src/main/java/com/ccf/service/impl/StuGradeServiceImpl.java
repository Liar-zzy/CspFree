package com.ccf.service.impl;

import com.ccf.mapper.StuGradeMapper;
import com.ccf.pojo.StuGrade;
import com.ccf.service.StugradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("StuGradeService")
public class StuGradeServiceImpl implements StugradeService {

    @Autowired
    private StuGradeMapper sMapper;

    @Override
    public void findGradeBySession(int session) {
        sMapper.findGradeBySession(session);
    }

    @Override
    public boolean AddStuGrade(StuGrade stuGrade) {
        int row = sMapper.AddGrade(stuGrade);
        return row == 1 ? true : false;
    }

    @Override
    public void StuGradeUpload(StuGrade stuGrade) {
        sMapper.StuGradeUpload(stuGrade);
        System.out.println("StuGradeUpload doing");
    }
}
