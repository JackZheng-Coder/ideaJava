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
public class IDCrad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];//保存身份证
        for (int i =0;i<n;i++){
            str[i] = in.next();
        }
        char[] ch = new char[n];//存储每行最后一位
        int[] sum = new int[n];// 存储每行前17位的和
        int[] guard = new int[n];// 用于判断是否符合条件，1 符合 0 不符合
        for (int i = 0;i<n;i++){
            ch[i] = str[i].charAt(17);
            sum[i] = 0;
            guard[i] = 1;
        }
        char[] M = { '1','0','X','9','8','7','6','5','4','3','2' };//对应Z值与校验码M的值  Z：0 1 2 3 4 5 6 7 8 9 10
        int[] N = { 7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2 };//权重
        // 检验前十七位是否全为数字
        for (int i = 0;i<n;i++){
            for (int j = 0;j<17;j++){
                if (str[i].charAt(j) >= '0' && str[i].charAt(j) <= '9'){
                    sum[i] += (str[i].charAt(j) - '0') *N[j];
                }else {
                    guard[i] = 0; //前17位有不是数字的
                    break;
                }
            }
        }
        boolean flag = true;// 判断是否所有均符合条件
        int count = 0;
        System.out.println();
        for (int i = 0;i<n;i++ ){
            if (guard[i] == 0 || M[sum[i] % 11] != ch[i]){ //不符合条件 输出错误的身份证
                flag = false;	// 进入此循环则有一个不符合条件
                System.out.println(str[i]);
            }else {
                count++;
            }
        }
        if (count > 0){
            System.out.println();
            System.out.println("正确的身份证个数:"+count);
        }
        if (flag){ //如果全都符合条件
            System.out.println("ALL PASSED!");
        }
        in.close();
    }
}
