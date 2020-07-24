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
public class ZhangSan_DingLi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 1){
            System.out.println(1); //如果是1的化直接输出1
        }
        int m = (int) Math.pow(num,3);//num的三次方赋值给m
        int sum = 0; //保存n个奇数的和
        for (int i = 1;i<(m/2);i++){//最小的奇数不会超过这个n^3的一半，1除外
            int a = i;
            sum = i;
            //第一个就是i，然后还有n-1个奇数
            for (int j =1;j<num;j++){
                a = a+2;
                //求出n个奇数和1
                sum += a;
            }
            //不等，则继续循环，下一个i
            if (sum != m){
                continue;
            }else {
                System.out.println(num+"的立方" + "=" +m +"=");
                for (int k = 0;k<num;k++){//输出结果
                    if (k == num - 1) //最后一个数字
                        System.out.println(i + 2 * k);
                    else
                        System.out.print((i + 2 * k) + "+");
                }
                return;
            }
        }
    }
}
