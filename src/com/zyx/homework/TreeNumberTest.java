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
 * 思路:用一个501个元素的数组来模拟这501棵树，数组的下标分别代表从1到501棵树，数组元素的值代表这棵树是否走过
 * 最初这些树都没有被移走，所以所有数组元素的初始位false 每当输入一个小区间，就将这个区间对应的树全部移走，即将这个
 *区间对应的数组元素下标指示的元素的值置成true
 */
public class TreeNumberTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); //路长
        int M = in.nextInt(); //区域
        int count =  L +1; //树的总数
        boolean[] b = new boolean[count];

        int[] start = new int[M+1]; //起始位置
        int[] end = new int[M+1];//末尾位置
        for (int i = 0;i<M;i++){
            start[i+1] = in.nextInt();
            end[i+1] = in.nextInt();
        }
        for (int i = 1;i<=M;i++){
            for (int j = start[i]; j<=end[i];j++){
                if (b[j] == false){
                    b[j] = true;
                    count--;
                }
            }
        }
        System.out.println(count);
        in.close();
    }
}
