package com.ccf.controller;

import com.ccf.pojo.Grade;
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

import java.util.ArrayList;

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

    @RequestMapping("/ListFirstToFifth")
    @ResponseBody
    public List<Grade> ListFirstToFifth(Model model, int session)
    {
        int size;
        int[] sumScore = new int[5];
        int[] right = new int[5];
        double[] accuracy = new double[5];

        Grade grade = new Grade();
        List<Grade> gradeList = new ArrayList<>();
        List<StuGrade> list = stuGradeService.ListAllGradeBySession(session);

        System.out.println("ListFirstToFifth");

        for (int i = 0; i < 5; i++) {
            accuracy[i] = 0;
            sumScore[i] = 0;
            right[i] = 0;
        }

        size = list.size();
        for (int i = 0; i < size; i++)
        {
            System.out.println(list.get(i).getSid());
            sumScore[0] += list.get(i).getFirst();
            sumScore[1] += list.get(i).getSecond();
            sumScore[2] += list.get(i).getThird();
            sumScore[3] += list.get(i).getFourth();
            sumScore[4] += list.get(i).getFifth();
            if(list.get(i).getFirst() == 100) right[0]++;
            if(list.get(i).getSecond() == 100) right[1]++;
            if(list.get(i).getThird() == 100) right[2]++;
            if(list.get(i).getFourth() == 100) right[3]++;
            if(list.get(i).getFifth() == 100) right[4]++;
        }
        grade.setName("First");
        grade.setAverage(sumScore[0]/size);
        grade.setAccuracy(right[0]/(double)(size));
        gradeList.add(0,grade);

        grade.setName("Second");
        grade.setAverage(sumScore[1]/size);
        grade.setAccuracy(right[1]/(double)(size));
        gradeList.add(1,grade);

        grade.setName("Third");
        grade.setAverage(sumScore[2]/size);
        grade.setAccuracy(right[2]/(double)(size));
        gradeList.add(2,grade);

        grade.setName("Fourth");
        grade.setAverage(sumScore[3]/size);
        grade.setAccuracy(right[3]/(double)(size));
        gradeList.add(3,grade);

        grade.setName("Fifth");
        grade.setAverage(sumScore[4]/size);
        grade.setAccuracy(right[4]/(double)(size));
        gradeList.add(4,grade);

        return gradeList;
    }
}
