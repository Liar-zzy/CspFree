package com.ccf.util;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作的工具类
 * @author Administrator
 *
 */
public class FileUtil {

    /**
     * 生成文件上传的时间戳，用于文件保存在服务器的路径的一部分
     * @return
     */
    public static String createFileTimestamp(){
        Date date = new Date();
        long time = date.getTime();
        return String.valueOf(time);
    }

    public static void writeFileToUrl(MultipartFile file,String fileUrl) throws IOException{
        FileOutputStream fos = new FileOutputStream(new File(fileUrl));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
    }

//	public static byte[] readFileFromUrl(String fileUrl) throws FileNotFoundException{
//		FileInputStream fis = new FileInputStream(new File(fileUrl));
//	}

    public static void main(String[] args) {
        System.out.println(FileUtil.createFileTimestamp());
    }

}


