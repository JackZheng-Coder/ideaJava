package com.zyx.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class DayOfWork1015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n种颜色
        int m = in.nextInt();//m个珍珠
        int[] pearl_color = new int[m]; //保存珍珠颜色
        HashSet<Integer> set = new HashSet<>(); //定义一个hashset来保存一串珍珠
        ArrayList<Integer> list = new ArrayList<>(); //保存重复颜色的珍珠
        String str ="";
        for (int i = 0;i<pearl_color.length;i++){
            pearl_color[i] = in.nextInt();  //初始化
        }
        for (int i = 0;i<m;i++){
            if (!set.contains(pearl_color[i])){
                set.add(pearl_color[i]); //将珍珠颜色放进set
            }else {
                list.add(pearl_color[i]); //如果重复了 放进list当中
            }
            if (set.size() == n) { //当珍珠符合形成一串
                str += "1"; //在符合条件的出设为1
                set.clear();//同时清空set 接着往下寻找
               for (int j = 0;j<list.size();j++){
                   if (!set.contains(list.get(j))){ //将之前list保存重复的珍珠放进set里
                       set.add(list.get(j));
                   }
                   if (set.size() == n-1){ //set的容量一定会满足n-1这一条件
                       break;
                   }
               }
            }else {
                str += "0"; //不满足条件设0
            }

        }
        System.out.println(str);
    }
}
