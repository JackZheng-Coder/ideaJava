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
public class DayOfWork1016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>(); //保存去重后的元素
        for (int i = nums.length-1;i >= 0;i--){ //从后往前遍历，把最后相同元素的值放进list
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        System.out.println(list.size()); //输出去重后的长度
        for (int i = list.size()-1;i >= 0;i--){ //输出
            System.out.print(list.get(i) + "\t");
        }
    }
}
