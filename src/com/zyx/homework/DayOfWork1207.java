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
public class DayOfWork1207 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (a % 2 == 0){
            return;
        }
        int b = in.nextInt();
        while (b != 0){
            for (int i = 1;i<=a;i++){ //循环7行
                for (int j = 1;j<=a;j++){ //循环7列
                    if (i==j || i+j == a+1){ //对角线打印X
                        System.out.print("X");
                    }else {
                        System.out.print(" ");//其他位置打印空格
                    }
                }
                System.out.println();
            }
            System.out.println("-------------------------------");
            b--;
        }
    }
}
