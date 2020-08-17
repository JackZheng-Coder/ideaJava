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
 * 思路：取球的情况分为三种：
 *
 * 1、取一黑一白，放回一个黑球，相当于取出一个白球。
 * 2、取两个白球，放回一个白球，相当于取出一个白球。
 * 3、取两个黑球，放回一个白球，相当于取出两个黑球，放回一个白球。
 *  按照要求 其实是不用考虑白球的 因为不论白球是都少都可以取出，主要取决于黑球,当黑球是奇数时，盒子最后一定是黑球，黑球如果是偶数，则盒子
 *  最后一个一定是白球
 */
public class The_Last_Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入白球的数量:");
        int w = in.nextInt(); //白球
        System.out.println("请输入黑球的数量:");
        int b = in.nextInt(); //黑球

        System.out.println("盒子中最后一个球是:");
        if (b % 2 == 0){
            System.out.println("WHITE");
        }else {
            System.out.println("BLACK");
        }

    }
}
