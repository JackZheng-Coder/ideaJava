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
//本题就是考螺旋矩阵
public class Spirl_Matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入正方形森林的边长:");
        int n = in.nextInt();//正方形边长
        int[][] num = new int[n][n];// 保存nxn的螺旋矩阵
        int t = 0;
        for (int i =0;i<(n+1)/2;i++){ //螺旋圈数
            for (int j = i;j<n-i;j++){//每圈从左到右的一行
                num[i][j] = ++t;
            }
            for (int k = i+1;k<n-i;k++){//每圈从上到下的一列
                num[k][n-i-1] = ++t;
            }
            for (int m = n-i-2;m>=i;m--){//每圈从右到左的一行
                num[n-i-1][m] = ++t;
            }
            for (int l = n-i-2;l>i;l--){//每圈从下到上的一列
                    num[l][i] = ++t;
            }
        }
        System.out.println("排查的顺序为:");
        for (int i =0;i<num.length;i++){
            for (int j = 0;j<num[i].length;j++){
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
