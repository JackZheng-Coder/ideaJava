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
public class WageTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入假期天数:");
        int day = in.nextInt();//输入给定剩余假期
        int k = 0; //来判断与day是否相等 作为退出循环标志
        int sum = 0;//总的工资
        for (int i = 1;;i++){//相当于无限循环
            for (int j = 1;j<=i;j++){
                k++;
                sum += i;//累计假期间的总工资
                if (k == day){//当天数等于给定的天数时，输出金币总数，终止程序
                    System.out.println("假期间共赚了"+sum*100+"$");
                    in.close();
                    return;
                }
            }
        }

    }
}
