package com.zyx.homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class DayOfWork_0911 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 1 || n >1000 ){
            System.out.println("输入错误！");
        }
        int[] num = new int[1000];//保存自然数

        {
            int sum=0,l=0;//sum 自然是相加总和 ，l保存自然数的位置
            int left = 0;//当sum>n时  sum要减去当前i 然后用n-sum得到n与sum的差值
            for (int i = 2; i <= n; i++) {//从2开始  因为1的话 1*n = n 不符合题意
                num[l++] = i;//保存自然数
                sum += i;
                if (sum > n) {//累加值大于n
                    sum -= i;
                    l--;//抛弃下一个值的位置  例如：下标3保存5 下标4保存6 这时超过n值 没必要在往下找了
                    left = n - sum; //计算n与sum之间的差值
                    break;
                }
            }
            for (int i =l-1;left>0;left--){ // 例如下标4保存6 因此下标4不要 从3开始往前推，left值为多少，就往前加多少次
                num[i]++;//当前下标自然数+1
                i--;//往前推
                if (i<0)
                    i = l-1;
            }
            for (int i =0;i<=l-1;i++){
                System.out.print(num[i]+"\t");
            }

        }
    }
}
