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
public class DayOfWork1203 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N =in.nextInt(); //月季的数量
        int C = in.nextInt();//水壶的容量
        int[] A = new int[N];   //月季由近到远的距离
        for (int i = 0;i<N;i++){
            A[i] = in.nextInt();
        }
        int[] B = new int[N];//指定月季需要浇灌的水量
        for (int i = 0;i<N;i++){
            B[i] = in.nextInt();
        }
        int sum_distance = 0; //总距离
        int waterCount = C;//水壶当前的水量
        //暴力搜索
        for (int i = 0;i<N;i++){
            if (waterCount >= B[i]){//浇灌当前月季
               if (i == 0){
                   sum_distance += A[i];
                   waterCount -= B[i];
               }else {
                   sum_distance += A[i] - A[i-1];//当i>0时，距离要减去前面的距离
                   waterCount -= B[i];
               }
            }else {
                sum_distance = sum_distance<<1; //要回去，直接是乘于当前距离2倍
                waterCount = C;//水量重新为C
                sum_distance += A[i];//因为下次循环就不是当前的月季，所以直接加上当前的距离，因为从起始点出发所以直接加A[i]
                waterCount -= B[i];
            }
            if (i == N-1){ //浇灌完，回到起始点
                sum_distance += B[i];
            }
        }

        System.out.println(sum_distance);
    }
}
