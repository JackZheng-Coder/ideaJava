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
 * 思路:本题是求最长不下降子序列的最大长度，设dp[i]为以i为结尾(必须包括i)的最长不下降子序列的长度
 * 如果i前面的j符合条件(i的导弹长度len比j大)，那么dp[i] = dp[j] + 1
 */
public class DayOfWork1126 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] missile = new int[N];//保存导弹
        int[] dp = new int[N+1];//保存最大序列即最多能拦截的导弹数量
        for (int i = 0;i<N;i++){
            missile[i] = in.nextInt();
        }
        dp[0] = 1;//一开始子序列是从1开始
        for (int i = 1;i<N;i++){
            int maxL = 1;//保存每次最大寻找的最多能拦截的导弹数量
            for (int j = 0;j<i;j++){
                if (missile[i] <= missile[j]){
                    maxL = Math.max(maxL,dp[j] +1);
                }
            }
            dp[i] = maxL;//将本次保存的最多能拦截的导弹数量赋值给dp
        }
        int ans = 0;
        for (int i = 0;i<N;i++){
           if (ans < dp[i])
               ans = dp[i];
        }
        System.out.println(ans);
    }
}
