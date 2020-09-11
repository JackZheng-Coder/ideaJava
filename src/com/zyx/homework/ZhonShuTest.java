package com.zyx.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class ZhonShuTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n]; //数字集合
        for (int i = 0;i<nums.length;i++){
            nums[i] = in.nextInt();
            if (nums[i] <=0 || nums[i] > 1000){
                System.out.println("输入错误!!!");
                return;
            }
        }
        System.out.println( majorityElement(nums));

    }
    //求众数
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;//统计数字出现的次数
        int max = nums[0];//赋初始值

        for(int i = 1; i < len; i++){
            if(max == nums[i]){ //如果相同 count++
                count++;
            }else{
                count--; //不一样 count-1
                if(count == 0){
                    max = nums[i]; //把当前的数字赋值给max
                    count++;
                }
            }
        }
        return max;
    }

}
