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
public class ZhaiAppleTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int apple_Count = in.nextInt(); // 苹果的数量
        int Li_Qi = in.nextInt(); //力气
        int Chair_Height = in.nextInt(); //椅子高度
        int ZhangShang_Height = in.nextInt();//张三手伸直长度
        int count = 0;//摘苹果的数量
        int[][] arr = new int[apple_Count][2];
        //赋值
        for (int i =0;i<apple_Count;i++){
            for (int j = 0;j<arr[i].length;j++){
                arr[i][j] = in.nextInt();
            }
        }
        //对苹果进行排序
        for(int i = 0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i][1] > arr[j][1]){
                    int temp = arr[i][1];
                    arr[i][1] = arr[j][1];
                    arr[j][1] = temp;

                    int temp1 = arr[i][0];
                    arr[i][0] = arr[j][0];
                    arr[j][0] = temp1;
                }
            }
        }




        //通过一个for循环暴力枚举
        for (int i = 0; i < arr.length; i++) {
            if (ZhangShang_Height >= arr[i][0]){ //张三的高度大于苹果的高度时
                if (Li_Qi >= arr[i][1]){ //判断当前的力气是否大于当前摘苹果需要的力气
                    count++;
                    Li_Qi = Li_Qi - arr[i][1];
                }
            }else { //张三的高度不等苹果的高度时，加上椅子的高度在判断
                if (ZhangShang_Height + Chair_Height >= arr[i][0]){
                    if (Li_Qi >= arr[i][1]){
                        count++;
                        Li_Qi = Li_Qi - arr[i][1];
                    }
                }
            }
        }
        System.out.println(count);
        in.close();
    }
}
