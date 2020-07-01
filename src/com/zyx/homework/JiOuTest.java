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
public class JiOuTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 2 == 0) //如果n为偶数则为偶函数
            System.out.println("ou");
        else
            System.out.println("ji");  //如果n为奇数则为奇函数
        in.close();
    }
}
