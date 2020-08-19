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
public class ForestTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入森林的腰长:");
        int k = in.nextInt();//输入腰长
        int n = k;//二维数组的长度
        while (k-- > 0) {
            int[][] num = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    num[i][j] = 0; //给每个值都先赋值为0
                }
            }
            int count = 1;//初始值1用来给数组赋值
            int x = 0, y = 0;
            num[x][y] = 1;//第一个为1

            //蛇形填数的变形，蛇形是控制四个方向，这个是三个方向，思路还是一样，控制数组下标变化即可
            while (count < ((n * (n + 1)) / 2)) {//count小于输入N时，最后一个数的值
                while (y < n - 1 && num[x][y + 1] == 0) { //每一圈的横排
                    num[x][++y] = ++count;
                }
                while (x < n - 1 && num[x + 1][y - 1] == 0 && y > 0) {//每一圈的斜对角线
                    num[++x][--y] = ++count;
                }
                while (x > 0 && num[x - 1][y] == 0) {//每一圈的竖排
                    num[--x][y] = ++count;
                }
            }

            //注意此处的打印方法，去掉不必要的列，只打印需要的列
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(num[i][j] + " ");
                }
                System.out.print(num[i][n - i - 1]);//输出每一行的最后一个
                System.out.println();

            }
            break;
        }
        in.close();
    }
}
