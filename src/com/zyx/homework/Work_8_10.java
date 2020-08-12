package com.zyx.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Work_8_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int n = in.nextInt(); //输入指定的数字
        Map<Integer,String> map = new HashMap<>(); //用hashmap保存26个字母
        for (int i = 0;i<26;i++){
            map.put(i,String.valueOf((char)(65+i)));
        }
        String str = "A";//初始的字符串
        if (n == 1){ //n为1直接输出A
            System.out.println("A");
        }else { //不为1就拼接字符串
            for (int i = 1;i<n;i++){
                str = str + map.get(i) + str;
            }
            System.out.println("外星人的语言为:");
            System.out.println(str);

        }
        in.close();
    }

}
