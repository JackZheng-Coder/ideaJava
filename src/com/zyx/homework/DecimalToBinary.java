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
public class DecimalToBinary {
    private static StringBuilder resultDecimal = new StringBuilder("");// 保存小数部分的计算结果
    private static final int N = 7;// 保留到小数点后7位

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个小数:");
        double num = in.nextDouble();
        System.out.println("该小数的二进制为:");
        calculateDecimal(num);
    }
    //计算小数的二进制
    public static void calculateDecimal(double decimal){
        int i = 1;//原来退出循环的标志
        do{
            if (decimal >= 1){//小数大于1 则将1保存到字符串中
                resultDecimal.append("1");
                decimal--;//大于1要变为小于1的小数
            }else {
                resultDecimal.append("0");//直接将 0保存到字符串
            }
            i++;
            if (i ==N ){ //如果i = N 退出循环
                break;
            }
        }while ((decimal = decimal * 2) != 0);
        resultDecimal.deleteCharAt(0);
        System.out.println("0."+resultDecimal);
    }
}
