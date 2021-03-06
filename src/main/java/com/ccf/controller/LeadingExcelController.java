package com.ccf.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccf.pojo.FreeList;
import com.ccf.pojo.Grade;
import com.ccf.pojo.User;
import com.ccf.service.FreeListService;
import com.ccf.service.StuGradeService;
import com.ccf.util.ImportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ccf.pojo.StuGrade;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/uploadExcel")
public class LeadingExcelController {

    @Autowired
    private FreeListService freeListService;

    @Autowired
    private StuGradeService stuGradeService;

    @RequestMapping("/ajax")
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {

        System.out.println("ajaxdoing...");

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

            String sid = String.valueOf(lo.get(5));
            sid = sid.substring(0,12);
            stuGrade.setSid(sid);
            //学号

            String grade=String.valueOf(lo.get(9));
            //总成绩
            stuGrade.setGrade(Integer.parseInt(grade));
//
            String session=String.valueOf(lo.get(7));
            //成绩单编号
            session = session.substring(7,9);
            //截取到的7，到9-1的内容
            stuGrade.setSession(Integer.parseInt(session));

            String first =String.valueOf(lo.get(10));
            //第一题分数
            stuGrade.setFirst(Integer.parseInt(first));

            //第二题分数
            String second=String.valueOf(lo.get(11));
            stuGrade.setSecond(Integer.parseInt(second));

            //第三题分数
            String third =String.valueOf(lo.get(12));
            stuGrade.setThird(Integer.parseInt(third));

            //第四题分数
            String fourth =String.valueOf(lo.get(13));

            stuGrade.setFourth(Integer.parseInt(fourth));

            //第五题分数
            String fifth =String.valueOf(lo.get(14));
            stuGrade.setFifth(Integer.parseInt(fifth));

            boolean success = stuGradeService.StuGradeUpload(stuGrade);
            System.out.println("update :" +success);

            System.out.println("打印信息-->"+stuGrade.toString());
        }

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");
        //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

    @RequestMapping("/FreeList")
    public void ajaxUploadFreeList(HttpServletRequest request,HttpServletResponse response) throws Exception {

        System.out.println("FreeList...");

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

            FreeList freeList=new FreeList();

            //学号
            String sid = String.valueOf(lo.get(0));
            sid = sid.substring(0,12);
            freeList.setSid(sid);


            //Rank分数
            String grade=String.valueOf(lo.get(1));
            freeList.setRank(Integer.parseInt(grade));

            //名字
            String session=String.valueOf(lo.get(2));
            freeList.setName(session);

            //班级号
            String first =String.valueOf(lo.get(3));
            freeList.setClassNom(first);

            boolean success = freeListService.UpAllGrade(freeList);

            System.out.println("update FreeList:" +success);

            System.out.println("打印信息-->"+freeList.toString());
        }

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");
        //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

    @RequestMapping("/upGrade")
    @ResponseBody
    public Map<String,String> updateAUser(@RequestBody StuGrade stuGrade , HttpServletRequest request){
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("SESSION_USER");
        stuGrade.setSid(u.getId());

        boolean success;
        success = stuGradeService.AddStuGrade(stuGrade);

        if(success) {
            System.out.println("upGrade success");
        } else {
            System.out.println("upGrade fail");
        }

        Map<String, String > map = new HashMap<>();
        map.put("upGrade","success");
        return map;
    }
}