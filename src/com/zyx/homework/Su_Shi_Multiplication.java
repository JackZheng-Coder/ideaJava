package com.zyx.homework;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
//   输入x，y
//       1.先看y是1位还是两位
//       2.若y是1位，则直接按序输出，但是第二行输出y时，前面加一个空格
//            2.1看x*y结果，结果一定要留三位，结果为一位数字则补两个空格，结果为两位，补一
//个空格，结果为三位直接输出
//       3.若y是2位，则分成十位数字s和个位数字g，分别乘以x结果为sx，gx。看十位相乘的结果去
//判断到底有几个空格
//            3.1若sx为两位，y不用加空格，最后乘积的结果为三位，不够补空格
//            3.2若sx为三位，输入的x前加2个空格，y前也加一个。结果为4位数字，不够补空格
public class Su_Shi_Multiplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        //现在分为两种情况 y>=10和y<10
        if (y >= 10) {
            int s = y / 10; //十位数
            int g = y % 10; //个位数
            //分别计算与x的乘积
            int sx = s * x;
            int gx = g * x;

            if (sx >= 100){//三位，前面补空格
                System.out.println("  "+x);
                System.out.println(" *"+y);
                System.out.println("━━━");
                //现在要看个位数字和x相乘需要补几个0了
                if(gx == 0){
                    System.out.println("  0"+gx);
                }else if (gx < 10){
                    System.out.println("   "+gx);//补三个空格
                }else if (gx < 100){
                    System.out.println("  "+gx);//补两个空格
                }else {
                    System.out.println(" "+gx);//补一个空格
                }
                System.out.println(sx);
                System.out.println("━━━");
                int num = x * y;
                //看结果需要补全几个空格
                if (num < 10){
                    System.out.println("   "+num);
                }else if (num < 100){
                    System.out.println("  "+num);
                }else if (num < 1000){
                    System.out.println(" "+num);
                }else {
                    System.out.println(num);
                }
            }//sx>=100结束
            else {
                System.out.println(" "+x);
                System.out.println("*"+y);
                System.out.println("━━━");
                if(gx == 0){
                    System.out.println("  0"+gx);
                }else if (gx < 10){
                    System.out.println("  "+gx);
                }else if (gx < 100){
                    System.out.println(" "+gx);
                }else {
                    System.out.println(gx);
                }
                System.out.println(sx);
                System.out.println("━━━");
                int num = x*y;
                if (num<10) {
                    System.out.println("  "+num);
                }else if (num <100) {
                    System.out.println(" "+num);
                }else{
                    System.out.println(num);
                }
            }//sx<100结束
        }//y>=10结束
        else { // y<10
            System.out.println(x);
            System.out.println("* "+y);
            System.out.println("━━━");
            int num = x * y;
            if (num < 10){
                System.out.println("  "+num); //个位数
            }else if (num < 100){
                System.out.println(" "+num); //两位数
            }else {
                System.out.println(num);
            }
        }//y<10结束



    }
}
