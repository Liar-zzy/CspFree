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
    public List<Grade> ListFirstToFifth()
    {
        int session =19;
        int size;
        int[] sumScore = new int[5];
        int[] right = new int[5];
        double[] accuracy = new double[5];


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
            sumScore[0] += list.get(i).getFirst();
            sumScore[1] += list.get(i).getSecond();
            sumScore[2] += list.get(i).getThird();
            sumScore[3] += list.get(i).getFourth();
            sumScore[4] += list.get(i).getFifth();
            if(list.get(i).getFirst() == 100) {
                right[0]++;
            }
            if(list.get(i).getSecond() == 100) {
                right[1]++;
            }
            if(list.get(i).getThird() == 100) {
                right[2]++;
            }
            if(list.get(i).getFourth() == 100) {
                right[3]++;
            }
            if(list.get(i).getFifth() == 100) {
                right[4]++;
            }
        }

        Grade grade1 = new Grade();
        grade1.setName("First");
        grade1.setAverage(sumScore[0]/size);
        grade1.setAccuracy((double)(right[0])/(double)(size));
        gradeList.add(0,grade1);

        Grade grade2 = new Grade();
        grade2.setName("Second");
        grade2.setAverage(sumScore[1]/size);
        grade2.setAccuracy(right[1]/(double)(size));
        gradeList.add(1,grade2);

        Grade grade3 = new Grade();
        grade3.setName("Third");
        grade3.setAverage(sumScore[2]/size);
        grade3.setAccuracy((double)(right[2])/(double)(size));
        gradeList.add(2,grade3);

        Grade grade4 = new Grade();
        grade4.setName("Fourth");
        grade4.setAverage(sumScore[3]/size);
        grade4.setAccuracy((double)(right[3])/(double)(size));
        gradeList.add(3,grade4);

        Grade grade5 = new Grade();
        grade5.setName("Fifth");
        grade5.setAverage(sumScore[4]/size);
        grade5.setAccuracy((double)(right[4])/(double)(size));
        gradeList.add(4,grade5);

        for(int i=0;i<gradeList.size();i++)
        {
            System.out.println(gradeList.get(i).toString());
        }

        return gradeList;
    }
}
