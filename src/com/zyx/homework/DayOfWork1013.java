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
 * 思路：个步数应该满足这样一个数列：1 2 3 4 …n-1  n  n-1 ……4 3 2 1 = n^2
 *      那么我们希望找到最大的n，尽可能使得上述的数列和 = 需要走的步数
 *      于是我们找到第一个 不大于step的 n*n
 *      得到上述数列的步数。
 *      还剩step-n*n个格子没走，我们希望以最少的步数走完。也就是说尽量以每次走n个格子走完剩下的格子，即 left / n
 *      由于可能不满足整除关系，但是剩余的格子数一定小于n，那么我们在 1 步之内一定能走完
 */
public class DayOfWork1013 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //有几个点
        int[] num = new int[n];
        for (int i = 0;i<n;i++){  //赋值
            num[i] = in.nextInt();
        }
        for (int i = 0;i<n;i++){
            theMinOfStep(num[i]);
        }
    }
    //找出最小步长
    public static void theMinOfStep(int step){
        if (step == 0){ //距离为0 退出
            return;
        }
        long  m = 0; //数列m
        while (m * m <= step){
            m++;
        }
        m--;//m--是因为开头要走一步先减去
        long  left = step- m*m; //剩下step-m*m格子
        long add1 = left/m; //每次走m个格子走完剩下的格子，即 left / m
        long add2 = left % m; //看看有没有多余出来的一个格子
        long ans = 2*m-1 + add1;
        if (add2 > 0){ //如果有多余的一个格子 结果就+1
            ans+=1;
        }
        System.out.println(ans);
    }
}
