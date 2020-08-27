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


public class TheMaxSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println( max_Sqe(str1,str2,str1.length(),str2.length()));
        in.close();
    }
    /**
     * 求最大公共子序列长度 递归版
     */
//    public static int max_Sqe(String str1,String str2,int m,int n){
//        if (m == 0 || n == 0){
//           return 0;
//        }
//        if (str1.charAt(m-1) == str2.charAt(n-1)){
//            return max_Sqe(str1,str2,m-1,n-1)+1;
//        }else {
//           return max(max_Sqe(str1,str2,m,n-1),max_Sqe(str1,str2,m-1,n));
//        }
//
//    }
    public static int max(int a, int b)
    {
        return (a>b)? a:b;
    }

    /**
     * 动态规划版
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    public static int max_Sqe(String str1,String str2,int m,int n){
       int[][] arr = new int[m+1][n+1];
       for (int i = 0;i<m+1;i++){
           for (int j = 0;j<n+1;j++){
               // 第一行和第一列置0
               if (i == 0 || j == 0){
                   arr[i][j] = 0;
               }else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
               }else {
                   arr[i][j] = max(arr[i-1][j],arr[i][j-1]);
               }
           }
       }
       return arr[m][n];
    }
}
