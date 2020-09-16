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
//思路:因为0为该集合的元素,所以通过公式计算的数都是集合中的元素，只要从0开始计算，遍历可得x是否为集合中的元素
public class TheElementInAssemble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt(); //集合中的元素
        int x = in.nextInt();//目标数字
        if (dfs(k,x))
            System.out.println("true");
        else
            System.out.println("该数不是集合中的元素");
        in.close();
    }
    //递归寻找x 是否为集合中的元素。 本题最好使用递归，使用循环遍历的，太浪费空间
    public static  boolean dfs(int k,int x){
        if (k > x)
            return false;
        if (k > 100000)
            return false;
        if (k == 1)
            return true;
        return (dfs(k*2+1,x) || dfs(3*k+1,x));
    }
}
