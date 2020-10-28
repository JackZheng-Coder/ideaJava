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
public class DayOfWork1026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n < 10){ //n < 10直接输出
            System.out.println(n);
            return;
        }
        fun(n);

    }
    //求数根方法
    public static void fun(int n){

        int sum = 0; //保存一个数各个位上的数字加起来的和
        while (n != 0){
            sum += n % 10;
            n = n/ 10;
        }
        if (sum < 10){
            System.out.println(sum);
        }else { //sum依然是两位数 递归调用fun函数
           fun(sum);
        }
    }
}
