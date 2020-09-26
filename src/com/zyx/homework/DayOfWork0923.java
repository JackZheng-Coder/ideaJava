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
public class DayOfWork0923 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //序列长度
        int[] nums = new int[n];
        int[] dp = new int[n]; //dp[i]表示以nums[i]为结尾的最大增序列和
        for (int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int ans = 0; //保存结果
        for (int j = 0;j < n;j++){
            dp[j] = nums[j];
            //算法的复杂度为O(n的平方)
            for (int k = 0;k < j;k++){
                if (nums[j] > nums[k]){ //碰到一个最大子序列的结尾
                    dp[j] = Math.max(dp[k] + nums[j],dp[j]);//得到最大的和
                }
            }
            ans = Math.max(ans,dp[j]);
        }
        System.out.println(ans);
    }
}
