package com.ccf.controller;


import com.ccf.pojo.Student;
import com.ccf.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    public StuService stuService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody Student student, HttpSession session)
    {
        Map<String,String> map=new HashMap<>();
        System.out.println("传入的 User :   "+student.getName() + "password: "+student.getPassword() );

        student = stuService.studentLogin(student.getSid(),student.getPassword());

        if(student!=null){
            System.out.println("login success");

            session.setAttribute("SESSION_USER", student);
            map.put("logincheck","success");

            //成功后 传回角色信息
            map.put("logincheck","success");
        }
        else{
            System.out.println("login failure");
            map.put("logincheck","failure");
        }
        return map;
    }

}
