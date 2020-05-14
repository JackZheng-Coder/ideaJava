package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Scanner;

/**
 * <分数求和>
 * 输入两个分数
 * 输出两个分数的和(3/6, 2/4这种情况需要化简)
 * 样例输入:
 * 1/6 1/3
 * 样例输出:
 * 1/2
 */
public class Function {
    int a;
    int b;

    public Function(){}

    public Function(int a,int b){
        this.a = a;
        this.b = b;
    }

    public double toDouble(){
        //整数相除要想转化为小数需要将其中一个（除数或者被除数*1.0）
        double temp = a*1.0 / b;
        return temp;
    }

    public  Function multiply(Function r){
        //      将自己的分数与r的分数相乘并返回值
            Function temp = new Function((this.a * r.a),(this.b * r.b));
            return temp;
    }

    public int GCD(int a,int b){
        //辗转相除法求最大公约数
        int temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            temp = b;
            b = a % b;
            a =temp;
        }
        return  a;
    }
    public void print(){
        //分数在输出的时候进行化简
        int temp = GCD(this.a,this.b);
        this.a = this.a / temp;
        this.b = this.b / temp;
        if (a == b && a == 1){
            System.out.println("1");
        }else {
            System.out.println(a + "/" + b);
        }
    }

    public Function plus(Function r){
        //      将自己的分数与r的分数相加并返回值
        /*
         * 先通分再相加
         * 求出this.a与r.a之间的最小公倍数
         * 之后this.b*(temp/this.a) + r.b*(temp/r.a)
         * 之后返回
         */
        Function temp = new Function();
        temp.b = this.b * r.b;
        temp.b = temp.b / GCD(this.b,r.b);
        temp.a = (this.a * (temp.b / this.b) + r.a * (temp.b / r.b));
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个分数的整数形式:");
        Function a = new Function(in.nextInt(),in.nextInt()); // 输入两个整数，转为分数形式
        a.print();//输出分数形式
        System.out.println("请输入第二分数的整数形式:");
        Function b = new Function(in.nextInt(),in.nextInt());
        b.print();//输出分数形式
        System.out.println("分数相加结果为:");
        a.plus(b).print();

        in.close();
    }
}
