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
public class TheEndOfPower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入两个数
        int a = in.nextInt();
        int b = in.nextInt();
        if(a <1 || a>100 || b < 1 || b > 10000 ){
            System.out.println("输入错误");
        }
        int k = 1;//保存a^b的后三位
        for (int i = 1;i<=b;i++){
            k *= a;
            k %= 1000;//k存储a^i的后三位
        }
        System.out.println(k); //输出k
        in.close();
    }
}
