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

/**
 * 输入:
 * 第一行 一个整数 表示有N家珠宝店
 * 第2~N+1行: 每行三个整数 分别表示横坐标, 纵坐标 钻石数量
 * 输出:
 * 所耗的时间(精确到分钟, 向上取整)
 * 样例输入:
 * 2
 * 30 40 5
 * 60 80 3
 * 样例输出:
 * 18
 * 样例输入:
 * 1
 * 30 40 3
 * 样例输出
 * 7
 */
public class Diamond_Test {
    public static double v = 50;//飞机速度
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //有几家店
        int[][] arr = new int[n][3]; //有几家店就保存几家店的坐标和钻石数量
        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr[i].length;j++){
                arr[i][j] = in.nextInt();
            }
        }
        time_test(arr);
    }
    public static void time_test(int[][] arr){
        double s = 0;//原点和商店距离
        double time = 0; // 耗费总时间
        for (int i = 0;i<arr.length;i++){
            double t = 0; //计算路程的花费时间
            s = Math.sqrt(Math.pow(arr[i][0],2) +Math.pow(arr[i][1],2));
            t = (s/v)*2; //*2是因为加上回去的时间
            time += (t + (arr[i][2] * 1)+(0.5 * arr[i][2])); //总时间= 路程花费的时间+偷宝石的时间+摆放宝石的时间
        }
        System.out.println("总耗时"+Math.ceil(time)+"分钟");//向上取整输出
    }
}
