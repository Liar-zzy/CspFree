package com.ccf.controller;

import com.ccf.pojo.User;
import com.ccf.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody User user, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        System.out.println("传入的 User Id :   " + user.getId() + "  password: " + user.getPassword());

        user = userService.userLogin(user.getId(), user.getPassword());

        if (user != null) {
            System.out.println("login success");

            session.setAttribute("SESSION_USER", user);

            map.put("logincheck", "success");

            //成功后 传回角色信息
            map.put("logincheck", "success");
        } else {
            System.out.println("login failure");
            map.put("logincheck", "failure");
        }

        return map;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Map<String, String> ModifyInfo(@RequestBody User user,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userold = (User)session.getAttribute("SESSION_USER");


        Map<String, String> map = new HashMap<>();
        boolean success;

        success = userService.UpdateInfo(user);

        userold.setPassword(user.getPassword());
        userold.setIdentify(user.getIdentify());
        userold.setPhone(user.getPhone());
        userold.setEmail(user.getEmail());

        session.setAttribute("SESSION_USER",userold);

        if (success == true) {
            map.put("update", "success");
            System.out.println("update success");
        } else {
            map.put("update", "fail");
            System.out.println("update fail");
        }
        return map;
    }

    @RequestMapping("/signUp")
    @ResponseBody
    public ModelAndView signUp(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("SESSION_USER");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("page/getFree");
        user.setIsSignUp("1");
        System.out.println("sign : "+user.getId());
        if(userService.UpdateInfo(user))
        {
            System.out.println("OKK");
        }

        user.setIsSignUp("1");
        session.setAttribute("SESSION_USER", user);

        return modelAndView;
    }

    @RequestMapping("/ListAllStu")
    public ModelAndView ListAllStu(@Param("name")String name) {
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.getAllStu();
        List<User> list1= new ArrayList<>();
        User user = new User();
        boolean isOne=false;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            if (list.get(i).getName().equals(name))
            {
                isOne=true;
                user.setIsSignUp(list.get(i).getIsSignUp());
                user.setId(list.get(i).getId());;
                user.setEmail(list.get(i).getEmail());
                user.setIdentify(list.get(i).getIdentify());
                user.setName(list.get(i).getName());
                user.setPassword(list.get(i).getPassword());
                list1.add(user);
                break;
            }
        }
        if (isOne){
            mv.addObject("SESSION_STU",list1);
        }
        else{
            mv.addObject("SESSION_STU",list);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getRole());
        }

        mv.setViewName("page/student_list");
        return mv;
    }

    @RequestMapping("/ListAllTeacher")
    public ModelAndView ListAllTeacher(@Param("name")String name) {
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.getAllTeacher();
        List<User> list1= new ArrayList<>();
        User user = new User();
        boolean isOne=false;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            if (list.get(i).getName().equals(name))
            {
                isOne=true;
                user.setId(list.get(i).getId());;
                user.setEmail(list.get(i).getEmail());
                user.setIdentify(list.get(i).getIdentify());
                user.setName(list.get(i).getName());
                user.setPassword(list.get(i).getPassword());
                list1.add(user);
                break;
            }
        }
        if (isOne){
            mv.addObject("SESSION_TEA",list1);
        }
        else{
            mv.addObject("SESSION_TEA",list);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getRole());
        }

        mv.setViewName("page/teacher_list");
        return mv;
    }


    @RequestMapping("/ChangeRightOfTeacher")
    @ResponseBody
    public Map<String, String> changeRightOfTeacher(@RequestBody User user) {

        boolean success;
        System.out.println("授权 : "+user.getId());
        success = userService.ChangeRightOfTeacher(user.getId());
        Map<String, String> map = new HashMap<>();

        if (success == true) {
            map.put("RightUpdate", "success");
            System.out.println("RightUpdate success");
        } else {
            map.put("RightUpdate", "fail");
            System.out.println("RightUpdate fail");
        }
        return map;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String, String> deleteUser(@RequestBody User user) {
        boolean success;

        System.out.println("删除同学 ： "+user.getId());
        success = userService.deleteUser(user.getId());
        Map<String, String> map = new HashMap<>();

        if (success == true) {
            map.put("deleteUser", "success");
            System.out.println("deleteUser success");
        } else {
            map.put("deleteUser", "fail");
            System.out.println("deleteUser fail");
        }
        return map;
    }


}
