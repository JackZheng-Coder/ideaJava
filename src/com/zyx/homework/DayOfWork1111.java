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
 * 思路:本题就是01背包问题，使用动态规划求解。
 *
 * */
public class DayOfWork1111 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//电脑配件数量
        int m = in.nextInt(); //张三的钱
        int[] N = new int[n];//回收站老板标的价格
        int[] V = new int[n];//配件的实际价值
        for (int i = 0;i<n;i++){
            N[i] = in.nextInt();
            V[i] = in.nextInt();
        }
        System.out.println(max_Value(N,V,m));
    }
    public static int max_Value(int[] weight,int[] value,int W){
        //weight和values数组长度总是一致的
        int n = weight.length;
        if (n == 0)
            return 0;
        int[][] dp = new int [n+1][W+1];
        for (int i = 1;i<=n;i++){
            for (int k = 1;k<=W;k++){
                // 存放 i 号物品（前提是放得下这件物品）
                int valueWith_i = (k-weight[i-1] >= 0)?(value[i-1]+dp[i-1][k-weight[i-1]]):0;
                // 不存放 i 号物品
                int valueWithout_i = dp[i - 1][k];
                dp[i][k] = Math.max(valueWith_i, valueWithout_i);
            }
        }
        return dp[n][W]; //返回配件总价值
    }
}
