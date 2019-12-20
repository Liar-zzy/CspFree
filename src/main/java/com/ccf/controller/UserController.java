package com.ccf.controller;

import com.ccf.pojo.User;
import com.ccf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody User user, HttpSession session)
    {
        Map<String,String> map=new HashMap<>();
        System.out.println("传入的 User Id :   "+user.getId() + "  password: "+user.getPassword() );

        user = userService.userLogin(user.getId(),user.getPassword());

        if(user!=null){
            System.out.println("login success");

            session.setAttribute("SESSION_USER", user);

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

    @RequestMapping("/modify")
    @ResponseBody
    public Map<String, String> ModifyInfo(@RequestBody User user, HttpSession session)
    {
        Map<String, String> map = new HashMap<>();
        boolean success;
        success = userService.UpdateInfo(user);

        if(success == true)
        {
            map.put("update", "success");
            System.out.println("update success");
        }
        else
        {
            map.put("update", "fail");
            System.out.println("update fail");
        }
        return map;
    }
}
