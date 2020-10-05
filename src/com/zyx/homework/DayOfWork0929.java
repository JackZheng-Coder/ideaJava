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
public class DayOfWork0929 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        if (s < 4 || s >10000){
            System.out.println("输入错误");
            return;
        }
        for (int i = s / 2;i>=2;i--){ //要求乘积最大，意味着两个数之间相差不大，即越接近，数越大，因此从中间拆分
            if (isPrime(i) && isPrime(s-i)){//判断拆分的两个数是否为素数
                System.out.println(i * (s-i) ); //输出
                return; //因为第一次输出的就是最大
            }
        }

    }
    //判断是否是素数
    public static boolean isPrime(int n){
        if (n <= 3){
            return n > 1;
        }
        for (int i = 2;i<= Math.sqrt(n);i++){
            if (n % i == 0)
                return false;
        }
        return true;

    }
}
