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
import javax.servlet.http.HttpSession;
import java.util.*;

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

    @RequestMapping("/insertIntoRedList")
    @ResponseBody
    public ModelAndView insertIntoRedList(@Param("num")String num , @Param("name")String name,
                                          @Param("score") String score , HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("SESSION_USER");

        List<RedList> ListRed = new ArrayList<>();
        ModelAndView mv = new ModelAndView();
        System.out.println("num :"+num);
        System.out.println("score :"+score);
        System.out.println("name :"+name);

        int limitScore = 0;
        int scoreNum = 0;
        int sum;
        if (num==null || score==null)
        {
            num="150";
            score="300";
        }
        sum = Integer.parseInt(num);
        limitScore = Integer.parseInt(score);

        List<StuGrade> list = stuGradeService.ListAllGradeBySession(19);
        List<FreeList> freeLists = freeListService.getFreelist();

        for (int i = 0; i < list.size(); i++)
        {
            User user = userService.GetAUser(list.get(i).getSid());
            RedList redList = new RedList();
            int grade = list.get(i).getGrade();
            System.out.println(user.getName()+"aaaaa");
            if(user.getIsSignUp().equals("1") && grade >= limitScore)
            {
                System.out.println(user.getName());
                System.out.println(grade);
                redList.setName(user.getName());
                redList.setIdentify(user.getIdentify());
                redList.setMoney(0);
                ListRed.add(scoreNum++,redList);
            }
        }
        scoreNum--;
        System.out.println("score ending!!!");

        for (int i = 0; i < freeLists.size(); i++) {
            int flag = 1;
            if(scoreNum >= sum-1){
                break;
            }
            String fname = freeLists.get(i).getName();
            for (int j = 0; j < ListRed.size(); j++) {
                if(ListRed.get(j).getName().equals(fname))
                {
                    System.out.println("Repeat !!!");
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
            {
                RedList redList = new RedList();
                User user = userService.GetAUser(freeLists.get(i).getSid());
                scoreNum++;

                System.out.println("add");
                System.out.println(user.getName());

                redList.setName(user.getName());
                redList.setIdentify(user.getIdentify());
                redList.setMoney(0);
                ListRed.add(scoreNum, redList);
            }
        }
        /**
         * 红名单选取结束
         * */

        /**
         * 先清除数据
         * */
         boolean success = redListService.ClearRedList();
         if(success){
             System.out.println("clear success!");
         }else {
             System.out.println("claer fail");
         }
        /**
         * 开始添加团报码并插入数据库
         * */
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        for (int i = 0; i < ListRed.size(); i++) {
            ListRed.get(i).setGroupCode(uuid.toString());
            success = redListService.addIntoRedList(ListRed.get(i));
            if(success){
                System.out.println("insert success!");
            }else
            {
                System.out.println("insert fail!");
            }
        }

        boolean isExist=false;
        List<RedList>  redOne= new ArrayList<>();

        //查看是否存在 name
        for(int i=0;i<ListRed.size();i++)
        {
            if(ListRed.get(i).getName().equals(name))
            {
                isExist=true;

                RedList red=new RedList();
                red.setName(ListRed.get(i).getName());
                red.setIdentify(ListRed.get(i).getIdentify());
                red.setMoney(ListRed.get(i).getMoney());
                redOne.add(red);
                break;
            }
        }

        if(isExist)
        {
            mv.addObject("RedList", redOne);
            System.out.println("redOne");
        }
        else {
            mv.addObject("RedList", ListRed);
            System.out.println("ListRed");
        }

        if(u.getRole()=="老师")
        {
            mv.setViewName("page/teacher-freelist");
        }
        else {
            mv.setViewName("page/admin-freelist");
        }
        return mv;
    }

}

