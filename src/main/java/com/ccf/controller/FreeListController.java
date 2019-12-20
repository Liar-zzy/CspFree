package com.ccf.controller;

import com.ccf.pojo.FreeList;
import com.ccf.pojo.User;
import com.ccf.service.FreeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/FreeList")
public class FreeListController {

    @Autowired
    private FreeListService freeListService;

    @RequestMapping("/getFreeList")

    public ModelAndView ListAllFreeList(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("SESSION_USER");

        List<FreeList> list;
        list = freeListService.getFreelist();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("FreeList",list);

        if(user.getRole()=="老师")
        {
            modelAndView.setViewName("page/teacher-freelist");
        }
        else {
            modelAndView.setViewName("page/admin-freelist");
        }



        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getName());
        }
        System.out.println("free list");

        return modelAndView;

    }
}
