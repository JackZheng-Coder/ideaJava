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
//思路:赢的前提是控制对面拿奇数  保证自己拿到偶数，最终对方只能选1 不能在拆分
public class DayOfWork1020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//局数
        int[] nums = new int[n];
        for (int i = 0;i<n;i++){
            nums[i] = in.nextInt();
        }
        for (int i = 0;i<n;i++){
            if (nums[i] % 2 == 0){
                System.out.println("yes"); //张三要赢必须拿到偶数，只有偶数才能拆分两个奇数
            }else {
                System.out.println("nice"); //小明要赢只需张三拿到两个偶数 或者1奇1偶
            }
        }
    }
}
