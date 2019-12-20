package com.ccf.service.impl;

import com.ccf.mapper.StuGradeMapper;
import com.ccf.pojo.StuGrade;
import com.ccf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StuGradeService")
public class StuGradeServiceImpl implements StuGradeService {

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
    public List<StuGrade> ListAllGradeBySession(int session) {
        List<StuGrade> list = sMapper.getAllGrade(session);
        return list;
    }

    @Override
    public List<StuGrade> ListSelfGrade(String sid) {
        List<StuGrade> list = sMapper.getSelfGrade(sid);
        return list;
    }

    @Override
    public void StuGradeUpload(StuGrade stuGrade) {
        sMapper.StuGradeUpload(stuGrade);
        System.out.println("StuGradeUpload doing");
    }
}
