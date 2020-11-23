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
 * 思路:暴力搜索
 */
public class DayOfWork1119 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n < 3 || m < 3){ //小于3直接退出
            return;
        }
        int[][] num = new int[n][m];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                num[i][j] = in.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0;i<n-2;i++){
            for (int j = 0;j<m-2;j++){
                if (f(i,j,num))
                    ans++;
            }
        }
        System.out.println(ans);
    }

    /**
     * 暴力搜索寻找3x3三阶幻方
     * @param x
     * @param y
     * @param num
     * @return
     */
    public static boolean f(int x,int y,int[][] num){
        int[] a = new int[10]; //保存每行 每列 对角线的和
        a[1]=num[x][y]+num[x+1][y]+num[x+2][y];a[2]=num[x][y+1]+num[x+1][y+1]+num[x+2][y+1];a[3]=num[x][y+2]+num[x+1][y+2]+num[x+2][y+2];
        a[4]=num[x][y]+num[x][y+1]+num[x][y+2];a[5]=num[x+1][y]+num[x+1][y+1]+num[x+1][y+2];a[6]=num[x+2][y]+num[x+2][y+1]+num[x+2][y+2];
        a[7]=num[x][y]+num[x+1][y+1]+num[x+2][y+2];a[8]=num[x][y+2]+num[x+1][y+1]+num[x+2][y];
        for(int i = 1; i<=8; i++) {
            if(a[i] != a[1]) return false;//如果不相等直接退出
        }
        return true;

    }
}
