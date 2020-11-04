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
//这题目和上周四题目一样，换汤不换药
public class DayOfWork1028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //输入零食的数量
        double[][] arr = new double[n][2]; //保存零食价格和渴望值
        for (int i = 0;i<n;i++){
            arr[i][0] = in.nextDouble();
            arr[i][1] = in.nextInt();
        }
        double ans = dfs(arr,n,0,0,0); //调用方法求最大渴望值
        System.out.println(ans);
    }
    //枚举 所以情况找到最大渴望值
    public static double dfs(double[][] arr,int n,int cur,double price,double strength){
        if (cur == n && price % 5 == 0){
            return  strength;
        }
        for (int i =cur;i<n;i++){
            double choose = dfs(arr,n,cur+1,price+arr[i][0],strength+arr[i][1]);
            double notchoose = dfs(arr,n,cur+1,price,strength);
            return  Math.max(choose,notchoose);
        }
        return 0;
    }
}
