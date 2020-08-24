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
 * 里面有 n*n 个 边长1
 * （n-1） * （n-1) 个 边长2
 * （n-2） * （n-2）个边长3
 * 所以一共有 1^2 + 2^2+ 3^2+...+n^2
 * 根据数列求和公式 所以是 n(n+1)(2n+1)/6 个正方形
 */
public class SquareTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //大正方形边长
        int square_Num = (n*(n+1)*(2*n+1))/6; //大正方形总正方形个数
        System.out.println("正方形个数为:"+square_Num);
    }
}
