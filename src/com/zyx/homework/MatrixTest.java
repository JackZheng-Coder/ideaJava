package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Scanner;

/**
 * 输入一个5*5的矩阵(图片), 矩阵边的像素点值不变,
 * 其他像素点的值取之前矩阵本身位置+上下左右像素点值的平均
 * 样例输入:
 * 5  4  5  4  5
 * 4  5  4  5  4
 * 5  4  5  4  5
 * 4  5  4  5  4
 * 5  4  5  4  5
 * 样例输出:
 * 5    4    5    4    5
 * 4   4.2  4.8  4.2  4
 * 5   4.8  4.2  4.8  5
 * 4   4.2  4.8  4.2  4
 * 5    4    5    4    5
 */
public class MatrixTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("输入你需要的阶层数：");
        int n=scan.nextInt();//定义需要的阶层数n
        int[][] num = new int[n][n];//定义一个n*n的数组array
        System.out.println("输入数组的各个元素");
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                num[i][j] = scan.nextInt(); //赋值
            }
        }
        System.out.println("你输入的数组为：");
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                //如果不是第一行，最后1行，第一列，最后1列 则按照题目要求计算
                if ((i!=0 && i != n-1) &&(j != 0 && j != n-1) ){
                    double a; //用来保存计算后的结果
                    a = (num[i][j] + num[i][j-1] + num[i][j+1] + num[i-1][j] + num[i+1][j]) / 5.0; //按照题目要求计算
                    System.out.print(a+"\t"); //输出符合要求的值
                }else {
                    System.out.print(num[i][j] + "\t");//输出第一行，第一列，最后一行，最后一列。
                }

            }
            System.out.println();
        }
    }
}

