package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 输入矩形的长和宽, 蛇形填充该矩形(对每一条/斜线, 按编号从小到大进行填充)
 * 样例输入: 4 4
 * 样例输出:
 *  1  2  6  7
 *  3  5  8 13
 *  4  9 12 14
 * 10 11 15 16
 */

import java.util.Scanner;

/**
 * 思路:对于每一条左下-右上的斜线，从左上到右下依次编号1,2,…,2n-1；按编号从小到大的顺序，将数字从小到大填入各条斜线，
 * 其中编号为奇数的从左下向右上填写，编号为偶数的从右上到左下填写。
 */
public class SnakeFillArrayTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = 1;//初始值;
        int i=1,j=1; //初始位置
        int[][] arr = new int[101][101];
        System.out.print("输入层数:");
        int n = in.nextInt(); //层数
        while (t <= n*n){ //循环条件 t <= n*n  没有遍历完继续
            while (1 != 0){  //向右上走
                if (i < 1 || j > n){  //出界
                    i++;
                    j--;
                    break;
                }else { //不出界
                    arr[i][j] = t;
                    t++;
                    i--;
                    j++;
                }
            }
            if (j == n) i++; //j==n 换行
            else if (i==1) j++; //否则 换列

            while (1 != 0){ //向左下走
                if (i > n || j < 1){ //出界
                    j++;
                    i--;
                    break;
                }else { //不出届
                    arr[i][j] = t;
                    t++;
                    i++;
                    j--;
                }
            }
            if (i == n) j++; //i==n 换列
            else if (j == 1) i++; //否则 换行
        }
        for(i=1;i<=n;i++) {
            for(j=1;j<n;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println(arr[i][n]); //打印每行末尾
        }
        in.close();
    }
}
