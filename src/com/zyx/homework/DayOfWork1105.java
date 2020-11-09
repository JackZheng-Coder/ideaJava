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
 * 思路:计算每一列数的和，当前列数和<0 说明负数的绝对值大于正数绝对值,对该列数和进行求反，就是对每一列中的元素进行相反数
 * 先把所有和为负数的列都翻转为正数并记下原来有多少列为负的，如果负数列为偶数那么总和就是答案，
 * 如果是奇数列那么就会有一个负数列出现，因为之前把这个负数列也变成正数加上去了所以我们需要减去两倍的这个负数列，
 * 接下来就是这个负数列怎么定，原来只是在矩阵的负数列中找，后来发现绝对值最小的不一定在其中，
 * 我们可以把落单的那个负数列和正数中绝对值最小的那一列翻转
 */
public class DayOfWork1105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j<nums[i].length;j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        int sum = 0; //最终保存矩阵最大和结果
        int k = 0; //统计负列数的个数
        int min = 1001;//定义一个最小值，记录绝对值最小的数
        for (int i = 0;i<n;i++){
            int col_sum = ColSum(nums,i);//计算当前列数和
            int a = col_sum;
            if (col_sum < 0)
                k++; //负列数个数+1
            if (a<min)
                min = Math.abs(col_sum);//记录绝对值最小的数 包括本身就是正值的列数和
            sum += Math.abs(a);
        }
        if (k % 2 != 0){//如果和为负数的列是奇数，那么我们需要减去绝对值最小的列的两倍的值。
            sum -= min *2;
        }
        System.out.println(sum);

    }
    //求每一列的和
    public static int ColSum(int[][] arr,int i){
        int sum = 0;
        for (int j = 0;j<arr.length;j++){
            sum += arr[j][i];
        }
        return sum;
    }
}
