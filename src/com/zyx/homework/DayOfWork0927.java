package com.zyx.homework;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class DayOfWork0927 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//集合A的数量
        int m = in.nextInt();//集合B的数量

        int k = n+m; //保存 集合A 和B的总的数量
        int[] nums = new int[k];
        //一开始直接合并 然后去重 剩下A B的并集
        for (int i = 0;i < k;i++){
            nums[i] = in.nextInt();
        }
        //从小到大的排序
        Arrays.sort(nums);
        //输出第一个
        System.out.print(nums[0] + "\t");
        //去重
        for (int i = 1;i < k;i++){
            if (nums[i] != nums[i-1]){
                System.out.print(nums[i] + "\t");
            }

        }
    }
}
