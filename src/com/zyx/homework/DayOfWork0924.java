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
 * A：最后剩余一列，那么假设把这列去掉后，其铺砖情况与n-1时的情况一样，而加上后，也只有一种情况所以方法数位pave（n-1）
 *
 * B：最后剩余两列，那么把这两列先去掉后和n-2的情况一样，加上这两列后一共有三种情况：1*2竖着放2列，1*2横着放，2*2直接填满。
 * 因为1*2竖着放和A情况重复，所以方法数为pave（n-2）*2
 *
 * 综上：方法总数=pave（n-1）+2*pave（n-2）
 */
public class DayOfWork0924 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0){
            System.out.println("输入有误");
        }
        System.out.println("一个可以铺"+pave(n)+"法");
    }


    public static long pave(int n){
        long[] p = new long[3];//保存不使用2*2砖的方法次数
        p[0] = 1;
        p[1] = 3;
        p[2] = 5;
        if (n == 1)//n为1列时 直接用1*2竖着放 1种方法
            return p[0];
        else if (n == 2)//n为2列时  用1*2横着放1种 和 1*2竖着放2个 一个3种
            return p[1];
        else if (n == 3) //类比同上
            return p[2];
        else
            return pave(n - 1) + 2 * pave(n - 2);//用递归求解
    }
}
