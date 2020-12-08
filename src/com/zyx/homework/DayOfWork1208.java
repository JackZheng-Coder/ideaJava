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
public class DayOfWork1208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] trangle = new int[100][100];//用二二维数组保持当前权值，trangle[i][j]表示第i行的第j个值
        int[][] maxSum = new int[100][100];//保持最大路径 maxSum(1,1)为最大值
        for (int i = 1;i<=n;i++ ){
            for (int j = 1;j<=i;j++){
                trangle[i][j]  = in.nextInt(); //初始化
            }
        }
        for (int i = 1;i<=n;i++){
            maxSum[n][i] = trangle[n][i]; //将三角形最后一行给最大值从下往上推
        }
        //例:最后一行为 4 5 2 6 5 maxSum前一行就应该为 7 12 10 10以此类推
        for (int i = n-1;i>=1;i-- ){
            for (int j = 1;j<=i;j++){
                maxSum[i][j] = Math.max(maxSum[i+1][j],maxSum[i+1][j+1])+trangle[i][j];
            }
        }
        System.out.println(maxSum[1][1]);//输出最大路径
    }
}
