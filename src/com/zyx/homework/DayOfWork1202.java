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
public class DayOfWork1202 {
    static boolean[] vis = new boolean[12];//表示当前位是否访问跟
    static int[] ans = new int[12]; //保存结果
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0,-1);
    }
    //递归搜索寻找符合条件的排列
    public static void dfs(int now,int last){//now为搜到了第几位，last代表上一个数的奇偶性
        if (now == n){
            for (int i = 0;i<n;i++){
                System.out.print(ans[i]);
            }
            System.out.println();
            return;
        }
        else {
            for (int i = 1;i<=n;i++){
                if (vis[i] == false && last!=(i&1)){//i&1表示i的奇偶性i与1进行与运算(为1时表示奇数 为0时表示偶数)
                    vis[i] = true;
                    ans[now] = i;
                    dfs(now+1,i&1);//now+1表示搜到的位数加1,i&1表示i的奇偶性
                    vis[i] = false;//每次递归完后，要设置当前位被访问，否则下一次递归搜索可能会失败。
                }
            }
        }
    }
}
