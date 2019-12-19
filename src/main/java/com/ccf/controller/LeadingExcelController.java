package com.ccf.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccf.service.StugradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ccf.pojo.StuGrade;
import com.ccf.util.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/uploadExcel")
public class LeadingExcelController {

    @Autowired
    private StugradeService stugradeService;

    @RequestMapping("/form")
    public ModelAndView form(HttpServletRequest request)throws Exception{
        ModelAndView mav = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");

        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        in.close();

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++)
        {
            List<Object> lo = listob.get(i);
            StuGrade stuGrade = new StuGrade();
//            Family family = new Family();
//            family.setJtbh(String.valueOf(lo.get(0)));
//            family.setXm(String.valueOf(lo.get(1)));
//            family.setHy(String.valueOf(lo.get(2)));
//            family.setBz(String.valueOf(lo.get(3)));

            String sid = String.valueOf(lo.get(5));
            sid = sid.substring(0,12);
            stuGrade.setSid(sid);//学号

            String grade=String.valueOf(lo.get(9));//总成绩
            stuGrade.setGrade(Integer.valueOf(grade));

            String session=String.valueOf(lo.get(7));//成绩单编号
            session = session.substring(7,9);//截取到的7，到9-1的内容
            stuGrade.setSession(Integer.valueOf(session));

            String First=String.valueOf(lo.get(10));//第一题分数
            stuGrade.setFirst(Integer.valueOf(First));

            String Second=String.valueOf(lo.get(11));//第二题分数
            stuGrade.setSecond(Integer.valueOf(Second));

            String Third=String.valueOf(lo.get(12));//第三题分数
            stuGrade.setFifth(Integer.valueOf(Third));

            String Fourth=String.valueOf(lo.get(13));//第四题分数
            stuGrade.setFourth(Integer.valueOf(Fourth));

            String Fifth=String.valueOf(lo.get(14));//第五题分数
            stuGrade.setFifth(Integer.valueOf(Fifth));

            stugradeService.StuGradeUpload(stuGrade);

            System.out.println("打印信息-->"+stuGrade.toString());
        }

        mav.setViewName("../index");
        return mav;
    }

    @RequestMapping(value="/ajax")
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;


        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            StuGrade stuGrade=new StuGrade();
            stuGrade.setSid(String.valueOf(lo.get(5)));//第7列表示学号

            String grade=String.valueOf(lo.get(9));//总成绩
            stuGrade.setGrade(Integer.valueOf(grade));
//
            String session=String.valueOf(lo.get(7));//成绩单编号
            session = session.substring(7,9);//截取到的7，到9-1的内容
            stuGrade.setSession(Integer.valueOf(session));

            String First=String.valueOf(lo.get(10));//第一题分数
            stuGrade.setFirst(Integer.valueOf(First));

            String Second=String.valueOf(lo.get(11));//第二题分数
            stuGrade.setSecond(Integer.valueOf(Second));

            String Third=String.valueOf(lo.get(12));//第三题分数
            stuGrade.setFifth(Integer.valueOf(Third));

            String Fourth=String.valueOf(lo.get(13));//第四题分数
            stuGrade.setFourth(Integer.valueOf(Fourth));

            String Fifth=String.valueOf(lo.get(14));//第五题分数
            stuGrade.setFifth(Integer.valueOf(Fifth));

            stugradeService.StuGradeUpload(stuGrade);

            System.out.println("打印信息-->"+stuGrade.toString());
        }

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

}