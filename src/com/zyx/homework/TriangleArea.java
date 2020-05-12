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
public class TriangleArea {
    //输入三角形ABC的三个角坐标, 输出三角形ABC的面积

    /**
     * 思路：已知三点坐标，求出三边距离 通过海伦公式求出三角形面积
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入点1的坐标");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        System.out.println("请输入点2的坐标");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        System.out.println("请输入点3的坐标");
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();

        /*
			 * 	已知A（x1,y1）,B（x2,y2）
			那么AB之间的距离为√[(X1－X2)^2+(Y1－Y2)^2]
			 * */

        /*
         * 点1至点2的距离
         *  求根的方法：Math.sqrt(double s);
         * */
        double first = Math.sqrt((x1-x2)*(x1*x2) + (y1 - y2) * (y1 - y2));
        /*
         * 点2至点3的距离
         * */
        double second =  Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));

        /*
         * 点3至点1的距离
         * */
        double third = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));


        /*
         * 计算三角形面积 通过海伦公式来计算 √[P(P－F)(P-S)(P-T)]
         *
         * */

        double p = (first + second + third)/2;  //半周长
        double s = Math.sqrt(p * (p-first) * (p-second) * (p-third)); //三角形面积
        System.out.println("三角形面积为:" + s);
    }
}
