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
 * 数据传输
 * 张三有n台电脑, 这些电脑两两之间能互相传输数据, 但一台电脑在一秒内最多只能向k台电脑传输数据.
 * 现在张三的数据在某一台电脑上, 张三想知道至少需要几秒能将数据传到所有电脑上
 * 输入: 两个正整数n,k  (1<=n,k<=10^9)
 * 输出: 一个整数 表示最少需要多少秒
 * 样例输入:
 * 10 2
 * 样例输出:
 * 3
 */
public class DayOfWork1120 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n台电脑
        int k = in.nextInt();//最多传输电脑台数
        int second = 0;//耗时多少秒
        int count = 1; //初始的时候本身有一台源电脑所所以初始为1，保存已经传送过电脑台数
        int m = n -1;//剩下还有多少台电脑没有被传送
        while (m != 0){
            m = m- k*count; //k*count一次可以传送电脑台数
            count += k*count;//更新已传送过电脑台数
            if (m < count){//如果剩下电脑台数小于已传送电脑台数 直接终止。
                second++;
                m = 0;
            }
            second++;
        }
        System.out.println(second);
    }
}
