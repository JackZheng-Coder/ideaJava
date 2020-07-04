package com.zyx.homework;



import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class SuShu_Test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入大于9的奇数:");
            int n = in.nextInt();
            if (n < 9 || n > 10000) { //不符合规范
                System.out.println("输入错误！！！");
            }
            //暴力枚举 从奇素数开始
            for (int i = 3; i < n; i++) {
                for (int j = 3; j < n; j++) {
                    for (int k = 3; k < n; k++) {
                        if (isPrime(i) && isPrime(j) && isPrime(k) && (n == i + j + k)) { //符合的条件
                            System.out.println(i + "\t" + j + "\t" + k); //输出第一个，直接break。因为第一个是最小的
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            in.close();
        }



    //判断素数
    public static boolean isPrime(int n){
        if (n <= 3){
            return n > 1;
        }
        for (int i = 2;i<n;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
