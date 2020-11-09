package com.zyx.homework;

import java.util.Scanner;
import java.util.Vector;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 对于某个箱子集合，若打开其中任意一个箱子都能依次使用箱子中的钥匙打开其他所有箱子，暂且把这样的箱子集合称作环。
 * 比如在测试案例1中，（1,2,5）是一个环，（3,4）也是一个环。显然，不论打开（1,2,5）中的哪个箱子，其它两个箱子也会被打开。
 *
 * 这题的要求是打开所有的箱子的概率。打开箱子的总方法数是C(n,k)，所有本题的关键是求打开所有箱子的方法数。
 *
 * 除此之外还要统计有多少环，以及每个环中的元素个数。
 *
 * 动态规划：
 * dp[i][j]表示用j把钥匙打开前i个环箱子的方法数。
 * dp[0][0]=1
 * dp[i+1][j+l]+=dp[i][j]*C(count(i+1),l)             count(i+1)表示第i+1个环中的箱子数量
 * 即用j+l把钥匙打开i+1的方法数，即打开第i+1个环共用了l把钥匙。
 *
 * 在程序中count的计数是从0开始的，即count(i)实际表示的第i+1环中的箱子数量。
 */
public class DayOfWork1106 {
    static double[][] c = new double[301][301];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //求组合数
        for (int i = 0;i<=300;i++){
            c[i][0] = c[i][i] = 1.0;//代表着0个炸弹打开保险柜，i个炸弹打开i个保险柜的概率都为1,方法数也只有1种
            for (int j = 1;j<i;j++){
                c[i][j] = c[i-1][j-1] + c[i-1][j]; //打开i个保险柜，需要j个钥匙的概率(方法数) 为打开i-1个保险柜需要j-1个钥匙+打开i-1个保险柜需要j个钥匙
            }
        }
        int n,k;
        n = in.nextInt();
        k = in.nextInt();
        int[] box = new int[n+1];//保存保险柜中的钥匙
        int[] visit = new int[n+1];//记录改保险柜是打开过
        for (int i = 1;i<=n;i++){
            box[i] = in.nextInt();
            visit[i] = 0;
        }
        Vector<Integer> count = new Vector<>();//记录环的数量
        for (int i = 1;i<=n;i++){
            int sum = 0;//保存环数
            int tmp = i;
            while (visit[tmp] == 0){
                visit[tmp] = 1;
                tmp = box[tmp];//相当于tmp = 1->2->5->1
                sum++;
            }
            if (sum != 0)
                count.add(sum);
        }
        int ring_sum = count.size();
        if (ring_sum > k){//环数大于k 概率为0
            System.out.println("0.0000");
            return;
        }
        double[][] dp = new double[301][301];
        dp[0][0] = 1.0;
        for (int i = 0;i<ring_sum;i++){
            for (int j = 0;j<k;j++){
                if (Math.abs(dp[i][j]) > 0.000001){
                    for (int l = 1;l<count.get(i)&&j+l<=k;l++){
                        dp[i + 1][j + l] += dp[i][j] * c[count.get(i)][l];

                    }
                }
            }
        }
        System.out.printf("%.4f\n", dp[ring_sum][k] / c[n][k]);
    }
}
