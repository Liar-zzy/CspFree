package com.ccf.controller;

import com.ccf.pojo.Student;
import com.ccf.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StuService stuService;

    /**
     * 更新学生3种信息的接口：手机号、身份证、邮箱
     */
    @RequestMapping("/update")
    ModelAndView update3(Student student, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        ModelAndView mav = new ModelAndView();
        stuService.stuChangeIdentify(student);
        mav.setViewName("userinfo");
        return mav;
    }

}
