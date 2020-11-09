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
public class DayOfWork1104 {
    static int[] a = new int[7];//保存符合条件要求的数值(比如10符合题目 就保存1,0两个数)
    static int k , m  ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();//位数
        k = in.nextInt();//数值
        f(0);
    }
    //判断每位数字都小于等于K, 同时任意相邻两位数字的乘积也小于等于K.
    static boolean is() {
        for (int i = 0; i < m; i++) {
            if (a[i] > k) {
                return false;
            }
            if (i > 0 && a[i] * a[i - 1] > k) {
                return false;
            }
        }
        return true;
    }


    static void f(int n) {
        if (n == m) { //如果n为m位数
            if (is()) { //判断是否满足题意
                for (int i = 0; i < m; i++) {
                    System.out.print(a[i] + "");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i <= k; i++) {
            if (n == 0 && i == 0) {        //首位为0
                continue;
            }
            a[n] = i; //将0到k之间的数字赋值给a
            f(n + 1); //进行递归调用 进行组合，求出满足要求的数字
        }
    }
}
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();//N位数
//        int K = scanner.nextInt();
//        int start = (int)Math.pow(10,(N-1));//初始值
//        int end =(int)Math.pow(10,N); //末尾值
//        ArrayList<Integer> list = new ArrayList<>();//保存符合要求的值
//        //暴力循环找到对应的值
//        for (int i = start;i<end;i++){ //
//            int index = i;
//            int a = 0;//判断每个数值是否小于K
//            int b = 1;//保存乘积的值 判断是否小于K
//            while (index != 0){
//                a = index % 10;
//                if (a <= K ){ //判断当前个数值是否小于K
//                    if(a != 0){
//                        b *= a;
//                    }
//                    index = index /10;
//                }else {
//                    break;
//                }
//            }
//            if (a <= K &&b <= K){ //符合要求 把值放进集合中
//                list.add(i);
//            }
//
//        }
//        //输出
//        for (int i = 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }