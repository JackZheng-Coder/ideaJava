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
//思路:一个球传一次就看作两个球，最后看有多少个球在1号手上。简单模拟一下传球过程
public class DayOfWork1210 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//多少个同学
        int m = in.nextInt();//传球次数
        int[] b = new int[31];//动态保存每次传球回到x号同学的次数
        int[] a = new int[31];//保持从1号到n号同学 球回到每个同学方法数
        a[1]  = 1;//1号同学球数初始为1
        for (int i =1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                if (j == 1)
                    b[j] = a[j+1] + a[n];
                else if (j == n)
                    b[j] = a[j-1] + a[1];
                else
                    b[j] = a[j-1] + a[j+1];
            }
            for (int j =1;j<=n;j++){
                a[j] = b[j];
            }
        }
        System.out.println(a[1]);
    }
}
