package com.zyx.homework;

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
public class CatchingTheThief {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n条街
        int[] money  = new int[100]; //保存每个店铺的钱
        int[] max_Money = new int[100];//保存每个街区最大的钱
        for (int i = 1;i<=n;i++){
            int m = in.nextInt();//每个街区有多少个店铺
            for (int j = 1;j<=m;j++){
                money[j] = in.nextInt(); //给每个店铺赋值
            }
            max_Money[1] = money[1];
            for (int k = 2;k<=m;k++){
                //不能连续两家偷，且必须偷钱最大的一家
                max_Money[k] = Math.max(max_Money[k-2]+money[k],max_Money[k-1]);//max_ money[k]表示前k天获得的最大现金数量
            }//max_Money[k-2]+money[k],表示偷完一家必须要隔家偷
            System.out.println(max_Money[m]);//输出街区最大钱
        }
    }

}
