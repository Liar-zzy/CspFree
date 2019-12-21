package com.ccf.controller;


import com.ccf.pojo.FreeList;
import com.ccf.pojo.RedList;
import com.ccf.pojo.StuGrade;
import com.ccf.pojo.User;
import com.ccf.service.FreeListService;
import com.ccf.service.RedListService;
import com.ccf.service.StuGradeService;
import com.ccf.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/RedList")
public class RedListController {

    @Autowired
    private RedListService redListService;

    @Autowired
    private StuGradeService stuGradeService;

    @Autowired
    private UserService userService;

    @Autowired
    private FreeListService freeListService;

    @RequestMapping("insertIntoRedList")
    @ResponseBody
    public ModelAndView insertIntoRedList(@Param("num")String num, @Param("name")String name,
                                          @Param("score") String score , HttpServletRequest request)
    {
        List<RedList> ListRed = new ArrayList<>();
        ModelAndView mv = new ModelAndView();
        System.out.println("num :"+num);


        int scoreNum = 0;
        int sum;

        sum = Integer.parseInt(num);
        List<StuGrade> list = stuGradeService.ListAllGradeBySession(19);
        List<FreeList> freeLists = freeListService.getFreelist();

        for (int i = 0; i < list.size(); i++)
        {
            User user = userService.GetAUser(list.get(i).getSid());
            RedList redList = new RedList();

            if(user.getIsSignUp().equals("1"))
            {
                redList.setName(user.getName());
                redList.setIdentify(user.getIdentify());
                redList.setMoney(0);
                ListRed.add(scoreNum++,redList);
            }
        }
        scoreNum--;

        for (int i = 0; i < freeLists.size(); i++) {
            int flag = 1;
            if(scoreNum >= sum) break;
            String fname = freeLists.get(i).getName();
            for (int j = 0; j < ListRed.size(); j++) {
                if(ListRed.get(j).getName().equals(fname))
                {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
            {
                RedList redList = new RedList();
                User user = userService.GetAUser(freeLists.get(i).getSid());
                scoreNum++;
                redList.setName(user.getName());
                redList.setIdentify(user.getIdentify());
                redList.setMoney(0);
                ListRed.add(scoreNum, redList);
            }
        }
        mv.addObject("RedList", ListRed);
        mv.setViewName("");
        return mv;
    }

}
