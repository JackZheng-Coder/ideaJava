package com.zyx.homework;

import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class StringEdit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); //输入字符串
        char[] ch = str.toCharArray(); //将字符串转为字符数组

        String mingLing = in.nextLine();//命令操作符 D I R
        switch (mingLing){
            case "D": //删除字符
                String zifu = in.nextLine(); //要删除的字符
                char a  = zifu.charAt(0);
                delectChar(ch,a);
                break;
            case "I": //插入字符
                String zifu1 = in.nextLine(); //插入到指定字符前面的字符
                char a1  = zifu1.charAt(0);
                String zifu2 = in.nextLine();//要插入的字符
                char a2  = zifu2.charAt(0);
                insertChar(ch,a1,a2);
                break;
            case "R"://替换字符
                String zifu3 = in.nextLine();  //原字符
                char a3  = zifu3.charAt(0);
                String zifu4 = in.nextLine();
                char a4  = zifu4.charAt(0); //要替换的字符
                replaceChar(ch,a3,a4);
                break;
        }

    }
    //删除字符串中的某个字符
    public static void delectChar(char[] ch,char a) {
        int count = 0;//统计操作次数，来验证有没有进行删除
       for (int i = 0;i<ch.length;i++){
           if (ch[i] == a){
               String string = String.valueOf(ch); //将字符数组重新化为字符串 这里不能使用tostring
               StringBuilder sb = new StringBuilder(string); //用StringBuilder包装string
               sb.deleteCharAt(i);//删除该字符
               System.out.println(sb);
               count++;
               break;
           }
       }
       if (count <= 0){
           System.out.println("没有该字符");
       }

    }
    //插入字符
    public static void insertChar(char[] ch,char a1,char a2){
        int count = 0;//统计操作次数，来验证有没有进行插入
        for (int i = ch.length-1;i>=0;i--){
            if (ch[i] == a1){ //找到指定字符
                String string = String.valueOf(ch);
                StringBuilder sb = new StringBuilder(string);
                sb.insert(i,a2); //插入
                System.out.println(sb);
                count++;
                break;
            }
        }
        if (count <= 0){
            System.out.println("没有该字符");
        }

    }
    //替换字符
    public static void replaceChar(char[] ch, char a1,char a2){
        int count = 0; //统计操作次数，来验证有没有进行替换
        for (int i = 0;i<ch.length;i++){
            if (ch[i] == a1){
                String string = String.valueOf(ch);
                StringBuilder sb = new StringBuilder(string);
                sb.replace(i,i+1, String.valueOf(a2)); //替换
                string = sb.toString();
                ch = string.toCharArray();//将插入后的字符串重新赋值给字符数组
                count++;
            }

        }
        if(count > 0){ //有替换操作情况下
            System.out.println(ch);
        }else{
            System.out.println("没有该字符");
        }

    }
}