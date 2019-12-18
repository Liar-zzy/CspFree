package com.ccf.controller;

import com.ccf.pojo.Teacher;
import com.ccf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public TeacherService teacherService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody Teacher teacher, HttpSession session)
    {
        Map<String,String> map=new HashMap<>();
        System.out.println("传入的 User :   "+teacher.getName() + "password: "+teacher.getPassword() );

        teacher = teacherService.TeacherSignIn(teacher);

        if(teacher!=null){
            System.out.println("login success");

            session.setAttribute("SESSION_USER", teacher);
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
