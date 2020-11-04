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
 * 思路:
 *        先对四个数中的任意两个数进行四则运算，得到的结果加剩余的两个数还有三个数
 * 		  再对三个数中的任意两个数进行四则运算，得到的结果加剩余的一个数还有二个数
 * 		  再对剩余的两个数进行四则运算，得到的结果如果是24，就说明该表达式能得到24，表达式正确；
 * 		  如果结果不是24，则说明表达式不正确
 */
public class DayOfWork1102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0;i<4;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(is24(4,nums));
    }
    public static boolean is24(int n,int[] arr){
        if (n == 1){
            if (Math.abs(arr[0] - 24) == 0)
                return true;
        }
        for (int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){ //进行组合
                int  a,b;
                a = arr[i];// 保存起来，在方法最后再恢复，以便继续计算
                b = arr[j];// 保存起来，在方法最后再恢复，以便继续计算
                arr[i] = arr[n-1];// 将最后一个数挪过来
                arr[i] = a + b;// 看看加法能否算出,如果能算出，返回true
                if (is24(n-1,arr))
                    return true;
                arr[i] = a - b;// 看看减法能否算
                if (is24(n-1,arr))
                    return true;
                arr[i] = b-a;// 看看减法能否算
                if (is24(n-1,arr))
                    return true;
                arr[i] = a * b;// 看看乘法能否算
                if (is24(n-1,arr))
                    return true;
                if (b != 0){// 看看除法能否算
                    arr[i] = a / b;
                    if (is24(n-1,arr))
                        return true;
                }
                if (a != 0){// 看看除法能否算
                    arr[i] = b / a;
                    if (is24(n-1,arr))
                        return true;
                }
                arr[i] = a;//如果以上的加、减、乘、除都不能得到有效的结果，则恢复数据进行下一轮的计算。
                arr[j] = b;
             }
        }
        return false;
    }
}
