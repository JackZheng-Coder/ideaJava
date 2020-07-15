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
 * 张三给自己定了一个宏伟的目标: 连续一百天坚持写每日作业
 * 一百天过去了, 张三查看自己的提交记录发现有N天忘记提交了
 * 于是张三软磨硬泡, 强忍着小新老师鄙视的眼神从小新老师那拿来M张补签卡
 * 每张补签卡都可以补上一天的作业, 将原本没有提交的一天变成已提交的一天
 * 张三想知道, 通过这M张补签卡, 可以使自己连续提交天数最多变为多少天
 * 输入:
 * 第一行: 两个整数N和M  分别表示忘提交的天数和补签卡的数量
 * 第二行: N个整数  表示忘写作业的那天
 * 输出:
 * 连续提交天数最多可以变成多少天
 * 样例输入:
 * 5 2
 * 10 30 55 56 90
 * 样例输出:
 * 59
 * 样例输入:
 * 5 10
 * 10 30 55 56 90
 * 样例输出:
 * 100
 */
public class BuQianTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //忘记提交天数
        int M = in.nextInt(); //补签卡数量
        int[] arr = new int[N];//具体的天数
        for (int i = 0;i<arr.length;i++){
            arr[i] = in.nextInt(); //赋值
        }
        int x = 0; // 保存在体天数之差最小的时候 记录当前的索引
        int max_NUmber = 0;// 保存具体天数中最大的
        int min_Number = arr[1] - arr[0];// 保存具体天数之差最小的

        if (M > N){ //补签卡数量大于忘记签到天数
            for (int i = 0;i<arr.length-1;i++){  //找到具体天数中最大的
                max_NUmber = Math.max(arr[i],arr[i+1]);
            }
            System.out.println("连续提交天数最多可以变为:" + (max_NUmber+M));//体天数中最大的加补签卡数量就是连续提交天数最多可以变为
        }else if (M < N){ //补签卡数量小于忘记签到天数
            for (int i = 0;i<arr.length-1;i++){
                min_Number = Math.min(min_Number,(arr[i+1] - arr[i]));
                if (min_Number <= N){ //找到具体天数之差最小的时候 记录当前索引
                    x = i; //这里不能做break 因为可能存在 10 11 55 56 90 这样的情况
                }
            }
            //例子：10 30 55 56 90 这里除了90不签 其他都签
            System.out.println("连续提交天数最多可以变为:" +(arr[x]+1 + M));
        }else { //补签卡数量等于忘记签到天数
            for (int i = 0;i<arr.length-1;i++){
                max_NUmber = Math.max(arr[i],arr[i+1]);
            }
            System.out.println("连续提交天数最多可以变为:" + (max_NUmber+1+M));
        }

    }
}
