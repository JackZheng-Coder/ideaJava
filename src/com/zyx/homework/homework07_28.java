package com.zyx.homework;

import java.util.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class homework07_28 {
    public static ArrayList<Integer> list = new ArrayList(); //保存在符合条件1的情况下的数字
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //输入一个4位数
        int[] num = new int[4];//保持4位数中的每一位数
        for (int i = 0;i<num.length;i++){ //提取每一位数
            num[i] = n %10;
            n = n / 10;
        }

        f(0,num); //进行全排列

       Integer[] arr = list.toArray(new Integer[0]); //将list转为Integer数组
       dengCha(arr);
    }
    //判断是否是素数
    public static boolean isPrime(int n){
        if(n <= 3){
            return n > 1;
        }
        for (int i = 2;i<=Math.sqrt(n);i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    //全排列，并进行判断将符合是素数的添加到集合中
    public static void f(int k,int[] a){
        if (k == 4) {
            //System.out.println(Arrays.toString(a));
            int number = a[3] * 1000 + a[2] * 100 + a[1] * 10 + a[0];
            if (isPrime(number)){
                list.add(number); //如果是素数添加到集合
            }
            Collections.sort(list);//每加一次 进行排序一次
            return;
        }
        /**
         * 递归全排列
         */
        for (int i = k;i<a.length;i++){
            {
                int t = a[k];
                a[k] = a[i];
                a[i] = t;
            }
            f(k+1,a);
            {
                int t = a[k];
                a[k] = a[i];
                a[i] = t;
            }
        }

    }
    //筛选在条件1下 符合等差数列的情况
    public static void dengCha(Integer[] nums){
        List<List<Integer>> results = new ArrayList<>(); //保持符合条件的集合
        for (int i =0;i<nums.length-2;i++){
            for (int j = i+1;j<nums.length-1;j++){
                for (int k = j+1;k<nums.length;k++){
                    if ((nums[k] - nums[j] == nums[j]- nums[i])){ //是等差数列
                            List<Integer>  result = new ArrayList<>(); //保持符合条件的3个数字
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[k]);
                            results.add(result);
                            break;
                    }else if (nums[k] - nums[j] > nums[j]- nums[i]){
                        break;//第三个已大于等差数列数，跳出本层循环
                    }
                }
            }
        }
        if (results.size() == 0){ //没有符合条件的结果
            System.out.println("no");
        }else {
            System.out.println(results);
        }
    }
}
