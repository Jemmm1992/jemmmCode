package com.utils;


import java.io.*;

/**
 * Created by BIG-JIAN on 2017/7/15.
 */
public class FileUtils {
    public static void main(String[] args) throws IOException {
        String filePath = "pom.xml";
        readFile(filePath);
    }

    public static void readFile(String filePath)  {
        File file = new File(filePath);//file为文件句柄
        FileReader fis = null;
        try {
            fis = new FileReader(file);
            BufferedReader bis = new BufferedReader(fis);
            String s = "";
            while ((s = bis.readLine())!=null){
                System.out.println(s);
            }
            bis.close();
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定的文件");
        } catch (IOException e) {
            System.out.println("读取内容出错");
        }
    }
}
