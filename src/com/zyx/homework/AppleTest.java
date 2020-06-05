package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 已知有M个苹果和N个小朋友
 * 在允许 有的小朋友不给苹果的情况下
 * 有多少种分配方式
 * 注意: 1,5,1和5,1,1是同一种分配方式
 * 输入: 苹果的数量和小朋友的数量
 * 输出: 每种分配方式和分配方式的种数
 * 样例输入:
 * 7 3
 * 样例输出:
 * 7, 0, 0
 * 6, 1, 0
 * …
 * 8
 */

import java.util.Scanner;

/**
 * 思路：设f(m,n) m为苹果的数量，n为孩子的数量，如果m为0或者n为1 则只有1种分法
 * 如果n > m 必定有n-m个孩子分不到苹果，去掉它们对分放苹果方法数目不产生影响；即　　if(n>m) f(m,n) = f(m,m)
 * 如果m >= n 不同的分法可以分成两种，即有至少一个孩子空着或者所有孩子都有苹果
 * 前面一种情况相当于f(m,n) = f(m,n-1);后面一种情况相当于f(m,n) = f(m-n,n)
 * 而总的分苹果的分法数目等于两者的和，即f(m,n) =f(m,n-1)+f(m-n,n)。
 */
public class AppleTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入苹果数量:");
        int m = in.nextInt();
        System.out.print("请输入孩子数量:");
        int n = in.nextInt();
        System.out.println("分苹果的总数为:"+f(m,n));
        in.close();
    }

    //m个苹果在n个孩子中有几种分法 ps:递归方法貌似求不出每种分法
    public static  int f(int m ,int n){
        if (m == 0 || n == 1 ) //因为我们总是让m>=n来求解的，所以m-n>=0,所以让m=0时候结束，如果改为m=1，
            return 1;            // 则可能出现m-n=0的情况从而不能得到正确解
        if (n > m) //孩子数量大于苹果数量
           return f(m,m);
        else //苹果数量大于孩子数量
            return f(m,n-1) + f(m-n,n);
    }
}
