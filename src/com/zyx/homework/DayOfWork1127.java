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
public class DayOfWork1127 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();//正整数N
        for (int i = 2;i<N;i++){ //从2进制开始到N-1进制进行判断，大于N进制不用考虑
            int num = N;
            int countOfOne = 0;//1的个数
            while (num / i != 0){
                if (num % i > 1){
                    break;
                }else if (num % i == 1){
                    countOfOne++;
                }
                num = num / i;
            }
            if (countOfOne > 1 || num % i != 1)//这个判断是为了最后一位是否为1，在上面循环中并不会对最后的一位进行判断
                continue;
            else
                System.out.print(i+"\t");
        }
    }
}
