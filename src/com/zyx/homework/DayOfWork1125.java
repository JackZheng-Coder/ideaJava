package com.zyx.homework;

import java.util.Arrays;
import java.util.Map;
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
 * 思路:要求n个银行到最佳位置的距离总和，最是要求出那个最佳地点的坐标。
 * 最佳坐标的x只跟银行的x1,x2,x3,...有关，同理y坐标也是。
 * 若n为奇数，则邮局的x坐标取最中间的值时最小
 * 若n为偶数，则邮局的x坐标可以取最中间两个值的之间的任意值
 */
public class DayOfWork1125 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0;i<n;i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        //对x,y坐标进行排序
        Arrays.sort(x);
        Arrays.sort(y);
        //求出最佳地点的坐标
        int c1 = x[n/2];
        int c2 = y[n/2];
        int sum = 0;//保存距离总和
        for (int i = 0;i<n;i++){
            sum += Math.abs(c1- x[i]);
            sum += Math.abs(c2- y[i]);
        }
        System.out.println(sum);
    }
}
