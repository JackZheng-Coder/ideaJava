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

/**
 * 输入两串字符串, 无视空格和大小写, 判断其是否相等
 * 样例输入:
 * 1abc 2a3bc abc
 * 1ABC2A3B Cabc
 * 样例输出
 * true
 */
public class StringEqualsTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入第一个字符串:");
        String str1 = in.nextLine();
        System.out.print("请输入第二个字符串:");
        String str2 = in.nextLine();
        compare(str1,str2);

    }
    //比较两个字符串
    static boolean compare(String str1,String str2){
        System.out.println(compareTwoStringIgnoreCases(str1,str2));
        return  str1.equalsIgnoreCase(str2);
    }
    //忽视大小写判断是否相等
    static boolean compareTwoStringIgnoreCases(String a,String b){
        //将字符串转为字符数组，比较ascii码判断是否相等
        char[] a1 = a.toCharArray();
        char[] b1 = a.toCharArray();
        int i,j;
        for (i=0,j=0;i < a1.length && j < b1.length;){
            if (a1[i] == b1[j] || Math.abs(a1[i] -b1[j] ) == 32){//ascii码：大写小写差32;空格的ascii码对应十进制为32
                i++;
                j++;
            }else  if (a1[i] == 32){
                i++;
            }else  if (b1[j] ==32){
                j++;
            }
            else return false;
        }
        return true;
    }
}
