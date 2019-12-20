package com.ccf.controller;


import com.ccf.pojo.StuGrade;
import com.ccf.pojo.User;
import com.ccf.service.StuGradeService;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/resources/stuGrade")
public class StuGradeController {

    @Autowired
    private StuGradeService stuGradeService;

    @RequestMapping("/ListAllGradeBySession")
    @ResponseBody
    public ModelAndView ListAllGradeBySession(Model model, @Param("session") int session)
    {
        List<StuGrade> list = stuGradeService.ListAllGradeBySession(session);
        ModelAndView me = new ModelAndView();
        model.addAttribute("ListAllGrade",list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getSid());
        }
        System.out.println("ListAllGrade");
        me.setViewName("page/stuGradeAll");
        return me;
    }

    @RequestMapping("/ListSelfGrade")
    public ModelAndView ListSelfGrade(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("SESSION_USER");

        List<StuGrade> list = stuGradeService.ListSelfGrade(user.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("ListSelfGrade",list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getSid());
        }
        System.out.println("ListSelfGrade");
        mv.setViewName("page/stuGradeAll");
        return mv;
    }
}
