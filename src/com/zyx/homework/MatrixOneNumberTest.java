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
 * 输入一个0和1构成的矩阵, 判断是否每行每列 1的数量都是偶数
 * 如果是  打印true
 * 如果仅修改一个矩阵元素的情况下就可以满足条件, 打印该元素的坐标
 * 否则打印false
 * 样例输入:
 * 1 0 1 0
 * 0 0 0 0
 * 1 1 1 1
 * 0 1 0 1
 * 样例输出:
 * true
 * 样例输入:
 * 1 0 1 0
 * 0 0 1 0
 * 1 1 1 1
 * 0 1 0 1
 * 样例输出:
 * 2, 3
 */
public class MatrixOneNumberTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[101][101]; //0到100个
        int[] b = new int[100]; //行的计数
        int[] c = new int[100];//列的计数
        int n;
        int s1 = 0,s2 = 0; //保存奇数的个数
        int h = 0,l =0; //修改h行，l列，计数
        int hc = 0,lc = 0; //修改h行，l列，计数

        System.out.print("请输入n的值:");
        n = in.nextInt();
        if (n <= 0 || n >= 100){
            System.out.println("输入的值错误!!!!");
        }
        b[0] = 0;
        c[0] = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++ ){
                a[i][j] = in.nextInt(); //输入同时判断行中1的计数
                if (a[i][j] == 1){
                    b[i]++;
                }
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                if (a[j][i] == 1){ //判断列中1的个数
                    c[i]++;
                }
            }
        }

        for (int i = 0;i<n;i++){
            if (b[i] % 2 != 0){ //判断个数是否为偶数
                s1 += 1;  //为奇数+1
                hc += 1;
                h = i;
            }
            if (c[i] % 2 != 0){ //列
                s2 += 1;
                lc += 1;
                l = i;
            }
        }

        if (s1 == 0 && s2 == 0){ //全为偶数
            System.out.println("true");
        }else if (s1 != 0 && s2 != 0){  //为奇数下
            if (hc==1 && lc ==1){
                System.out.println(h + "," + l);  //输出坐标
            }
        } else {
            System.out.println("false"); //都不符合打印false
        }
    }
}
