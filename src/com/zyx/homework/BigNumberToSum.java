package com.zyx.homework;

import java.math.BigInteger;
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
 * 思路：1.反转两个字符串，便于从低位到高位相加和最高位的进位导致和的位数增加；
 * 2.对齐两个字符串，即短字符串的高位用‘0’补齐，便于后面的相加；
 * 3.从头遍历，把两个正整数的每一位都相加，并加上进位；
 * 4.最高位有进位则补上进位；
 * 5.逆序输出；
 */
public class BigNumberToSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入两个整数的字符串
        String s1 = in.next();
        String s2 = in.next();

        //反转字符串
        String n1 = new StringBuffer(s1).reverse().toString();
        String n2 = new StringBuffer(s2).reverse().toString();

        int L1 = n1.length();
        int L2 = n2.length();
        int maxL = L1>L2? L1:L2;

        //补齐0
        if (L1<L2){
            for (int i = L1;i<L2;i++){
                n1 += "0";
            }
        }else {
            for (int i = L2;i<L1;i++){
                n2 += "0";
            }
        }

        StringBuffer res = new StringBuffer();//存放的结果
        int c = 0; //进位
        for (int i = 0;i<maxL;i++){
            int num = Integer.parseInt(n1.charAt(i) +"") + Integer.parseInt(n2.charAt(i)+"")+c;
            int temp = num % 10; //如果得到num值为两位数，则取个位数存放到结果中，十位作为进位
            res.append(temp);
            c = num / 10; //取进位
             }
        if (c > 0){ //最高位有进位则补上进位
            res.append(c);
        }
        System.out.println(res.reverse());//逆序输出
        in.close();
    }
}
