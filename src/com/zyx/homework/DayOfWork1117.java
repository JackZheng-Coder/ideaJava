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
 * 本题是完全背包类型问题，使用动态规划求解(与01背包不同,01背包问题是指每一种物品都只有一件，可以选择放或者不放。
 *  而完全背包问题中，只要背包装得下，每件物品可以选择任意多件。从每件物品的角度来说，
 *  与之相关的策略已经不再是选或者不选了，而是有取0件、取1件、取2件...直到取⌊T/Vi⌋（向下取整）件。)
 *  用dp(i,j)表示前i种物品放入一个容量为j的背包获得的最大价值，那么对于第i种物品，
 *  我们有k种选择，0 <= k * V[i] <= j，即可以选择0、1、2...k个第i种物品，所以表达式为：
 *  dp[i,t] = max{dp(i-1, j - V[i] * k) + P[i] * k}; （0 <= k * V[i] <= t）
 *  V代表重量(体积) p代表价值
 */
public class DayOfWork1117 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n种配件
        int m = in.nextInt();//张三手上的钱
        int[] N = new int[n]; //回收站老板标的价格
        int[] V = new int[n]; //配件的实际价值
        for (int i = 0;i<n;i++){
            N[i] = in.nextInt();
            V[i] = in.nextInt();
        }
       int[] dp = new int[m+1]; //保存最大配件总价值
        //优化过的使用一维数组来进行保存
        for (int i =0;i<n;i++){
            for (int j = N[i];j<=m;j++){
                dp[j] =  Math.max(dp[j],dp[j-N[i]] + V[i]);
            }
        }
        System.out.println(dp[m]); //输出最大的配件价值
    }
}
