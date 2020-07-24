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
public class EquationTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        Point(a,b,c);
        System.out.println();
        Answer(a,b,c);
    }
    //求出顶点坐标
    public  static void Point(double a,double b,double c){
        double x = -(b/(2*a)); //根据公式获得x
        double y = ((a*(x*x)) + b*x +c); //求出y
        System.out.println("("+x+","+y+")");
    }
    //求出y=0时的解
    public static void Answer(double a,double b,double c){
      double d = b*b-4*a*c; //△
       if (d == 0){ //只有一个解
           System.out.println("x="+(-b)/(2*a));
       }else if (d<0){ //无解
            System.out.println("无解");
       }else { //有2个解
           System.out.println("x1="+(-b+Math.sqrt(d))/(2*a));
           System.out.println("x2="+(-b-Math.sqrt(d))/(2*a));
       }
    }
}
