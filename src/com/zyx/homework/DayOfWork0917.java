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
public class DayOfWork0917 {
    static int n ; //n位数
    static  int p;//有哪些数字组成
    static  int[] a = new int[10]; //保存组成的数字
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        p = in.nextInt();
        for (int i = 1;i<=p;i++){ //1-5之间递归组成数字
            dfs(1,i);
        }
       in.close();
    }
    //逐层dfs可更换的数字即可,每次dfs到底层再输出
    public static void dfs(int num,int x){
        a[num] = x;//每轮循环开始 x位第一位数字
        if (num == n){ // n=4 当num=4时  输出4个数
            for (int i = 1;i<=n;i++){
                System.out.print(a[i]);
            }
            System.out.println();
            return;//跳出递归函数
        }
        num++; //不足4位,num++ 继续递归
        for (int i = 1;i<=p;i++){
            dfs(num,i);
        }
        return;
    }
}
