package com.ccf.controller;

import com.ccf.pojo.FreeList;
import com.ccf.pojo.User;
import com.ccf.service.FreeListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView ListAllFreeList(@Param("num")String num,@Param("name")String name,
                                        @Param("score") String score ,HttpServletRequest request)
    {
        System.out.println("num :"+num);


        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("SESSION_USER");
        ModelAndView modelAndView = new ModelAndView();
        List<FreeList> list;

        boolean isgetAFreeList=true;

        list = freeListService.getAFreelist(name);

        if (list.size()==0)
        {
            isgetAFreeList=true;
        }
        else{
            isgetAFreeList=false;
        }

        if( isgetAFreeList)
        {
            //用到 num 和 score
            list = freeListService.getFreelist();
            modelAndView.addObject("FreeList",list);
        }
        else {
            System.out.println("name : "+name);
            list = freeListService.getAFreelist(name);
            modelAndView.addObject("FreeList",list);
        }

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
            System.out.println(list.get(i).getClassNom());
            System.out.println(list.get(i).getRank());
        }
        System.out.println("free list");

        return modelAndView;
    }

}
