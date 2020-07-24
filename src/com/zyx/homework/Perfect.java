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
public class Perfect {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //输入数字
        int[] num = new  int[100]; //保存某个数的因数
        int k; // 记录当前的因数的下标
        int s; //保存对应的完数
        for (int i = 2;i<n;i++){ //从2开始
            k=0;
            s=0;
            for (int j = 1;j<i;j++){
                if (i %j == 0){ //j为当前数字对应的因数之一
                    num[k] = j;
                    s += j;
                    k++;
                }
            }
            if (s == i){//如果当前数等于s 就位完数
                System.out.print(i + "="); //输出完数
                for (int m = 0;m<k;m++){
                    System.out.print(num[m]); //输出对应完数的因数
                    if (m != k-1){
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
