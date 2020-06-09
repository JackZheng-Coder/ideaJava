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
 * 思路：采用动态规划 dp[i][j]表示S1前i长度部分与S2前j部分是否匹配
 * 当S1[i]不为'*'，dp[i][j]的真假和dp[i-1][j-1]相等；
 * 当S1[i]=='*'时,若S1[i]表示单字符，则dp[i][j]由dp[i-1][j-1]的真假决定
 *              若S1[i]表示多字符，则dp[i][j]由dp[i][j-1]的真假决定
 * 　　　　　　　　若S1[i]表示空，则dp[i][j]由dp[i-1][j]的真假决定 //*在第一个位置
 * 以上三种满足一个为true即可认为dp[i][j]=true;
 *
 */
public class SringMatchTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[][] dp = new boolean[100][100]; //保存s1,s2字符串匹配情况
        //赋值
        System.out.println("输入字符串1:");
        String str1 = in.nextLine();
        System.out.println("输入字符串2:");
        String str2 = in.nextLine();
        //转为字符数组
        char[] ch1= str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        dp[0][0] = true; //初始位设置为true
        //判断str1中是否有*号
        for (int i = 0;i<ch1.length;i++){
            if (ch1[i] == '*'){
                dp[i+1][0] = true;
            }else
                break;
        }
        for (int i = 0;i<ch1.length;i++){
            for (int j = 0;j<ch2.length;j++){
                //str1[i]为?表示 或者str1普通字符等于str2普通字符，
                if (ch1[i] == ch2[j] || ch1[i] == '%'){
                    dp[i+1][j+1] = dp[i][j];//把当前匹配情况(true)赋值给下一个
                    continue;
                }else if (ch1[i] == '*'){ //str1[i]表示为*号，则判断之前匹配情况，如果都为真，则赋值true，否则赋值false
                    if (dp[i][j] == true ||dp[i][j+1] == true || dp[i+1][j] == true ){
                        dp[i+1][j+1] = true;
                    }else
                        dp[i+1][j+1] = false;
                    continue;
                }
                dp[i+1][j+1] = false; //匹配失败
            }
        }
        //输出匹配情况
        if (dp[ch1.length][ch2.length] == true){
            System.out.println("匹配结果为:"+"true");
        }else
            System.out.println("匹配结果为:"+"false");
        in.close();
    }
}
