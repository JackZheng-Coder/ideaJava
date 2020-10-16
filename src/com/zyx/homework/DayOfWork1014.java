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


public class DayOfWork1014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if ((n % 2 == 0 || n % 5 == 0) || (n <0 || n > 10000)){ //不满足题意,退出
            return;
        }
        //思路:直接从答案入手 定义一个字符串保存1..... 如果第一次str%n==0 该str就是最小的由1组成的数字
        long num = 1;
        int count = 1;
        while (num % n != 0){
            num = num * 10 +1;
            count++;
        }
        System.out.println(count);
    }
}
