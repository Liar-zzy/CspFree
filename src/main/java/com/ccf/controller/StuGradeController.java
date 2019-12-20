package com.ccf.controller;


import com.ccf.pojo.StuGrade;
import com.ccf.service.StuGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/StuGrade")
public class StuGradeController {

    @Autowired
    private StuGradeService stuGradeService;

    @RequestMapping("/ListAllGradeBySession")
    @ResponseBody
    public ModelAndView ListAllGradeBySession(Model model, int session)
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
    @ResponseBody
    public ModelAndView ListSelfGrade(Model model, String sid)
    {
        List<StuGrade> list = stuGradeService.ListSelfGrade(sid);
        ModelAndView mv = new ModelAndView();
        model.addAttribute("ListSelfGrade",list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getSid());
        }
        System.out.println("ListSelfGrade");
        mv.setViewName("page/");
        return mv;
    }
}
