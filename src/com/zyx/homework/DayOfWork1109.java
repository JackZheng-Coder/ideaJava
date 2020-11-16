package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Scanner;

/**
 * 双十一
 * 张三在双十一选中了n件商品, 价格分别是A1,A2,A3… 如果消费满X元, 还能享受优惠
 * 张三希望自己血赚, 所以希望大伙帮帮他, 在选中商品总价不低于X的情况下尽量低一些
 * 输入:
 * 第一行两个整数 N和X N表示商品数量  X表示消费达到多少才有优惠 (N<20, X<100)
 * 第二行 N个整数An, 表示每个商品的价格(An<100)
 * 输出:
 * 一个整数, 表示最少的消费
 * 样例输入:
 * 10 50
 * 9 9 9 9 9 9 9 9 9 8
 * 样例输出:
 * 53
 */
public class DayOfWork1109 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n件商品
        int x = scanner.nextInt();
        int[] nums_price = new int[n];//保存每件商品的价格
        for (int i = 0;i<n;i++){
            nums_price[i] = scanner.nextInt();
        }
        System.out.println( DPX(nums_price,x));
    }
    //使用动态规划来求解
    public static int DPX(int[] nums,int x){
        int n = nums.length;
        int sum = 0;
        for (int i = 0;i<n;i++){
                sum += nums[i]; //求出买下全部商品的价格
        }
        if (sum < x){
            return -1;
        }else if (sum == x){
            return x;
        }
        //设二维数组dp[n+1][sum+1]中的任一项为dp[j][k]—从num[j],num[j+1],…,num[n-1]中任取若干个，它们之和不超过k的最大值。
        int[][] dp = new int[n+1][sum+1];
        for (int i = x;i<=sum;i++){
            for (int j = n-1;j>=0;j--){
                for (int k  = 0;k<=i;k++){
                    if (nums[j] >k){
                        dp[j][k] = dp[j+1][k];
                    }
                    else {
                        dp[j][k] = Math.max(dp[j+1][k],dp[j+1][k-nums[j]] + nums[j]);
                    }
                }
            }
            //i从m逐步递增至sum过程中，一定会有一个i0使得：dp[0][i0]==i0，即从num[0],num[1],…,num[n-1]中任取若干个元素，
            // 它们之和等于i0，并且最早出现的这样的i0就一定是大于等于m的最小值。此时，程序停止，返回i0.
            if (dp[0][i] == i){
                return i;
            }
        }
        return sum;
    }
}
/*
暴力搜索
int a[1000],n,m,min,x;
int inf=99999999;

void dfs(int cur,int cnt)
{
	int i;
	if(cnt>=x&&cnt<min)
		min=cnt;
	if(cur>m)
		return;
	dfs(cur+1,cnt+a[cur]);
	dfs(cur+1,cnt);
	return;
}

int main()
{
	int i;
	scanf("%d",&n);
	while(n--)
	{
		min=inf;
		scanf("%d %d",&m,&x);
		for(i=1;i<=m;i++)
			scanf("%d",&a[i]);
		dfs(1,0);
		if(min<inf)
			printf("%d\n",min);
		else
			printf("-1\n");
	}
	return 0;
}
*
 */