package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 有分数序列2/1, 3/2, 5/3, 8/5, 13/8, 21/13...
 * 输入n(1 < n < 50), 求前n项之和(精确到小数点后4位)
 * 样例输入: 2
 * 样例输出: 3.5
 */

import java.util.Scanner;

/**
 * 思路:把分子分母放在一起看就有如下结论:
 *从第二项起,每一项分子=前一项的分子+前一项的分母。（如第二个数中的3=2+1）
 *每一项的分母=前一项的分子(如:第二个数中的分母3与第一个数的分子3是满足数值一样的规律)
 *
 * 核心算法思想;替换。用变量t存放临时的分子值(目的是传递给后一项作分母用)，保证了a变成了后一项的分子时,变量b还能收到正确的分母值。
 * a变量:专门存放分子;b变量:专门存放分母。
 */
public class FloatSerialToSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double A =2;
        double B =1;
        f(A,B,n); //方法调用

        in.close();
    }
    public static void f(double a,double b,int n){
        double sum = 0,t=0;
        for (int i = 1;i<=n;i++){
            sum = sum + a/b;  //求出前n项和
            t = a;//用变量t存放临时的分子值
            a = a+b; //从第二项起每一项分子= 前一项分子加前一项分母
            b = t; //从第二项起每一项分母 = 前一项分子
        }
        System.out.println("前"+ n +"项和为:" + sum);
    }

}
