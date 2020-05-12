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
 * 输入若干整数，判断其中是否有一对(两个)数的和 等于给定的数。
 */
public class NumberTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入n个数:");
        int n = in.nextInt();
        int[] ch = new int[n];
        System.out.println("为数组赋值:");
        for (int i = 0;i<ch.length;i++){
            ch[i] = in.nextInt();
        }
        System.out.println("输入给定的数:");
        int num = in.nextInt();
        //调用方法
        solution(ch,num);
    }

    /**
     * 解决问题的算法
     * @param ch
     * @param num
     */
    public static void solution(int[] ch,int num){
        int count = 0; //计数，保存对数
        for (int i = 0;i < ch.length;i++){
            for (int j = i;j < ch.length;j++){
                if (ch[i] + ch[j] == num ){ //判断和是否等于给定的值
                    count++;

                }

            }

        }
        //如果count对于0 输出对数 没有则表明没有匹配 输出no
        if (count > 0){
            System.out.println("符合条件的对数为:" + count);
        }else {
            System.out.println("no");
        }

    }
}
