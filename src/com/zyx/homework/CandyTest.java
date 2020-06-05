package com.zyx.homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */


//这道题目运用“模”得的余数来储存“同类情况”，数组：dp[第i个数][除以m得余数j]=到第i个为止除以m能等于j的最大加和。
//求出的结果为dp[n][0]
public class CandyTest {
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);
        int[][] dp = new int[105][105]; //dp[i][j]表示前i个数余数为j的最大值,题目所求是dp[n][0]，前n个数，余数为0的最大值
        System.out.print("请输入糖果的袋数:");
        int n = in.nextInt();
        int[] a = new int[105];//保存糖的数量
        for (int i = 1;i<=n;i++){
            a[i] = in.nextInt(); //给n袋糖里赋值每袋多少个糖
        }
        System.out.print("请输入交作业学生的数量:");
        int m = in.nextInt();//学生数量

        for (int i = 1;i<=n;i++){
           dp[i][a[i] % m] = a[i];//将同余数的储存在一列，储存的是可取得该余数的值，只取此数是必有的一种情况
            for (int j = 0;j<m;j++){
               if (dp[i-1][j] !=0){//只有出现过的余数，才说明之前存在过至少一种情况供你和当前a加和
                   dp[i][(j+a[i])%m] = dp[i-1][j]+a[i];
               }
           }
           for (int j =0;j<m;j++){//每次都更新一下本余数最大值 ，筛去无关情况
               dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
           }

        }

        System.out.println("糖的总数:"+dp[n][0]);
    }
}
// for (int j = 0;j<m;j++) dp[i][j]=dp[i-1][j];//最大值最起码是前i-1个数的最大值
//        for (int j = 0;j<m;j++){
//        dp[i][(dp[i-1][j]+a[i])%m]=
//        Math.max(dp[i-1][j]+a[i],dp[i][(dp[i-1][j]+a[i])%m]);//更新dp数组，max（取a[i],不取a[i]）
//        }



