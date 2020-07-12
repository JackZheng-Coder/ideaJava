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
 * 思路：由于题目与字符出现的次数相关，我们可以统计每个字符在该字符串中出现的次数 要打到这么目的，
 * 我们需要一个数据容器来存储每个字符在字符串中出现的次数，这个数据可以根据字符来查找出现的次数。
 */
public class OnlyOneCharTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = FindOnlyOneChild(str);
        if (n >= 0){
            System.out.println(str.charAt(n));
        }else
            System.out.println("no");
        in.close();
    }
    //查找出现1次的字符
    public static int FindOnlyOneChild(String str){
        int[] hash = new int[256]; //定义数组保存当前字符的个数
        int len = str.length();
        for (int i = 0;i<len;i++){
            char temp = str.charAt(i);
            hash[temp]++;
        }
        int i;
        for (i = 0;i<len;i++){
            char temp = str.charAt(i);
            //如果只出现1次返回该下标
            if (hash[temp] == 1){
                return i;
            }
        }
        return -1;
    }
}
