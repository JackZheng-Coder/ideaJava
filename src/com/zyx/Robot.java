package com.zyx;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Robot {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        //        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//url匹配规则
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("http://wiki.xuetang9.com/?p=");//爬取的网址

            urlconn = url.openConnection();
            //将爬取到的链接放到D盘的SiteURL文件中
            pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"),true);
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            String buf = null;
            while ((buf = br.readLine())!=null){
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()){
                    pw.println(buf_m.group());
                }
            }
            System.out.println("爬去成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
