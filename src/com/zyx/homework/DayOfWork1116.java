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
 * 暴力搜索法时间放假的太大了，本题使用动态规划来做
 * 由于最长回文子串是要求连续的，所以我们可以假设 j 为子串的起始坐标，i 为子串的终点坐标，
 * 其中 i 和 j 都是大于等于 0 并且小于字符串长度 length 的，且 j <= i，这样子串的长度就可以使用 i - j + 1 表示了。
 * 我们从长度为 1 的子串依次遍历，长度为 1 的子串肯定是回文的，其长度就是 1；然后是长度为 2 的子串依次遍历，只要str[i]对于str[j]
 * 它就是回文的，其长度为 2；
 * 长度大于 2 的子串，如果它要满足是回文子串的性质，就必须有 str[i] 等于 str[j] ，并且去掉两头的子串 str[j+1 ... i-1] 也一定是回文子串，
 * 所以我们使用一个数组来保存以 j 为子串起始坐标，i 为子串终点坐标的子串是否是回文的，由于我们是从子问题依次增大求解的，
 * 所以求解 [i ... j] 的问题时，比它规模更小的问题结果都是可以直接使用的了。
 */
public class DayOfWork1116 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0;i<n;i++){
            String str = in.next();
            System.out.println(  get_MaxHueiWengLength(str));
        }
    }
    public static int get_MaxHueiWengLength(String s){
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 第一维参数表示起始位置坐标，第二维参数表示终点坐标
        // dp[j][i] 表示以 j 为起始坐标，i 为终点坐标是否为回文子串
        boolean[][] dp = new boolean[length][length];
        int maxLen = 1; //最大回问子串长度
        int start = 0;// 最长回文子串起始位置
        for (int i = 0;i<length;i++){
            for (int j = 0;j<=i;j++){
                if (i-j <2){
                    // 子字符串长度小于 2 的时候单独处理
                    dp[j][i] = chars[i] == chars[j];
                }else {
                    // 如果 [i, j] 是回文子串，那么一定有 [j+1, i-1] 也是回子串
                    dp[j][i] = dp[j+1][i-1] && (chars[i] == chars[j]);
                }
                if (dp[j][i] && (i-j+1) > maxLen){
                    // 如果 [i, j] 是回文子串，并且长度大于 max，则刷新最长回文子串
                    maxLen = i-j+1;
                   // start = j;
                }

            }
        }
        return maxLen; //符号最大回文子串长度
    }
}
