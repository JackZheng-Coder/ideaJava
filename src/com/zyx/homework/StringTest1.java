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
public class StringTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String str = in.nextLine();
        char[] ch1 = str.toCharArray(); //将字符串转为字符数组
        char ch2 = ' ' ; //保存字符
        int max = 0 ; //最大距离
        int count = 0; //字符出现的次数
        for (int i = 0;i<ch1.length;i++){
            for (int j = 0;j<ch1.length;j++){
                if (ch1[j] == ch1[i]){ // 碰到相同的字符
                    count++;//数量+1
                    if (count == 3) break; //如果出现三次 不符合要求
                    if (count == 2){  //出现两次,进行比较取最大
                        int temp = j -i-1;
                        if (temp > max){
                            max = temp;
                            ch2 = ch1[j];
                        }
                        count = 0; //一次完之后 要重新归0
                    }
                }
            }
        }
        System.out.println("字符:"+ch2 + "\t" +"最大距离:" + max); //打印字符 和最大距离
    }
}
