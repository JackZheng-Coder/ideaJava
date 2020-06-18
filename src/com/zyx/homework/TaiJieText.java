package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Scanner;

/**
 * 张三在爬楼梯时发现, 每次自己可以走一阶或者两阶
 * 这样3阶的楼梯就有111, 12, 21三种方式去走
 * 4阶就有1111  112 121 211 22 5种方式
 * 学校楼梯有11阶, 于是他开始一个一个尝试, 想试试有多少种走法
 * 半小时后, 张三没力气了
 * 希望强壮的小伙伴能帮他继续爬楼梯
 * 输入: 楼梯的阶数(1 < n < 50)
 * 输出: 一共有多少种爬楼梯方式
 * 样例输入: 5
 * 样例输出: 8
 */
//思路：类似斐波那契数列，找规律;如果是1阶楼梯，共有1种走法。如果是两阶楼梯，共有 1 1、2两种走法。
// 如果是3阶楼梯，共有111、12、21这3种走法 以此类推n阶则有f(n-1)+f(n-2)种走法
public class TaiJieText {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入楼梯阶数:");
        int n = in.nextInt();
        System.out.println(n+"阶"+"共有"+fun(n)+"种方法");
    }
    //递归求出n阶的走法
    public static long fun(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        else return fun(n-1)+fun(n-2); //对于3阶时递归求出
    }
}
