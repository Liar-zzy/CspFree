package com.ccf.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class FileController {
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importLogisticsCcode(@RequestParam("fileName") MultipartFile file) throws Exception {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)){
            return "文件不能为空"; 
        }
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        if (!prefix.toLowerCase().contains("xls") && !prefix.toLowerCase().contains("xlsx") ){
            return "文件格式异常，请上传Excel文件格式";
        }
        // 防止生成的临时文件重复-建议使用UUID
        //使用给定的后缀及前缀生成名称，前缀使用UUID，后缀从文件获取

        //UUID的生成
        UUID uuid  =  UUID.randomUUID();
        String uuidString = UUID.randomUUID().toString();
        final File excelFile = File.createTempFile(uuidString+"", prefix);
        file.transferTo(excelFile);

        //由于2003和2007的版本所使用的接口不一样，所以这里统一用Workbook做兼容
        boolean isExcel2003 = prefix.toLowerCase().endsWith("xls")?true:false;
        Workbook workbook = null;
        if(isExcel2003){
            workbook = new HSSFWorkbook(new FileInputStream(excelFile));
        }else{
            workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        }
        //Excel表中的内容
        List<Map<String,Object>> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);//引用第0个表格
        //这里从1开始，跳过了标题，直接从第二行开始解析
        for(int i=1; i<sheet.getLastRowNum()+1; i++) {
            Row row =sheet.getRow(i);
            //设置行格式和验证start 这里最好做成一个方法，免得代码多处复制
            if(row.getCell(0)!=null){//0是获取序号
                row.getCell(0).setCellType(CellType.STRING);//统一将单元格里的内容当作字符串
            }
            if(row.getCell(1)!=null){//1是获取姓名(第2列)
                row.getCell(1).setCellType(CellType.STRING);
            }
            if(row.getCell(2)!=null){
                row.getCell(2).setCellType(CellType.STRING);
            }
            if(row.getCell(6)!=null){//获取学校
                row.getCell(6).setCellType(CellType.STRING);
            }
            if(row.getCell(9)!=null){//获取成绩单编号
                row.getCell(9).setCellType(CellType.STRING);
            }
            if(row.getCell(11)!=null){//获取成绩单编号
                row.getCell(11).setCellType(CellType.STRING);
            }
            String orderCode = row.getCell(0).getStringCellValue(); //订单编号
            if (StringUtils.isEmpty(orderCode)){
                return "第" + i+"行，第1列不能为空!";
            }

            String logisticsCompanyCode = row.getCell(1).getStringCellValue();
            if (StringUtils.isEmpty(logisticsCompanyCode)){
                return "第" + i+"行，第2列不能为空!";
            }
            String logisticsCode = row.getCell(2).getStringCellValue();
            if (StringUtils.isEmpty(logisticsCode)){
                return "第" + i+"行，第3列不能为空!";
            }
            //设置行格式和验证end

            //组装列表
            Map<String,Object> map = new HashMap<>();
            map.put("orderCode",orderCode);
            map.put("logisticsCompanyCode",logisticsCompanyCode);
            map.put("logisticsCode",logisticsCode);
            list.add(map);
        }
        //删除临时转换的文件
        if (excelFile.exists()) {
            excelFile.delete();
        }
        //list就是具体内容，剩下的就是自己处理具体业务了
        System.out.println("上传的内容就是这个了：" + list);

        return null;

    }
}
