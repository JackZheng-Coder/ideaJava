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
 * 思路:从题目可知m的值必须小于等于n;从C(n,m) = 10 n = 5，m=2可知 C(4,2) = 6
 * C(3,2) = 3 C(2,2) = 1 可得到组合的数量的差值是一个等差数列
 */

public class DayOfWork1012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(m > n){ //如果m 大于n 直接退出
            return;
        }
        double result1 = 1;
        double result2 = 1;
        double result3 = 1;
        double count = 0 ; //组合的数量

        for (int i = 1;i<=m;i++){ //m个数可组成m位的个数
            result1 *= i;
        }
        for (int i = 1;i<=n;i++){  //n个数可以组成n位数的个数
            result2 *= i;
        }
        for (int i = 1;i<=(n-m);i++){//n-m个数可组成的n-m的个数
            result3 *= i;
        }
        count = result2 / (result1 * result3); //结果就位n个数组成m位的组合数
        System.out.println(count);//输出
    }
}
