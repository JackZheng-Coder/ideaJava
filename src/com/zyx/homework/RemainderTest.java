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
public class RemainderTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入3个数
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        /**
         * 本题只想出了暴力的方法
         */
        for (int i = 2;;i++){
            if (a % i == b % i && a % i == c % i ){ //余数相同
                System.out.println(i);//输出最小的余数
                break;
            }
        }
        in.close();
    }
}
