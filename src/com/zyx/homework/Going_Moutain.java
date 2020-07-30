package com.zyx.homework;

import java.util.ArrayList;
import java.util.Collections;
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
 * 第一行: 整数n(n<40), 表示有多少人合影
 * 第2~n+1行, 输入性别(0女|1男)和身高
 * 输出: 合影效果
 * 样例输入:
 * 6
 * 1 1.72
 * 1 1.78
 * 0 1.61
 * 1 1.65
 * 0 1.70
 * 0 1.56
 * 样例输出:
 * 1.65 1.72 1.78 1.70 1.61 1.56
 */
public class Going_Moutain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //合影总数
        double[][] students = new double[n][2]; //定义学生数组 保存性别信息和身高信息
        ArrayList<Double> boy_list = new ArrayList<>(); //保存男生身高的列表
        ArrayList<Double> girl_list = new ArrayList<>();//保存女生身高的列表
        for (int i = 0;i<students.length;i++){
            for (int j = 0; j<students[i].length;j++){
                students[i][j] = in.nextDouble(); //赋值
            }
        }

        for (int i = 0;i<students.length;i++){
            if (students[i][0] == 1){ //是男生时 将男生身高保存到男生列表
                boy_list.add(students[i][1]);
            }else if (students[i][0] == 0){ //女生 同上
                girl_list.add(students[i][1]);
            }
        }

        Collections.sort(boy_list); //男生进行升序
        //女生降序(先升序在逆转)
        Collections.sort(girl_list);
        Collections.reverse(girl_list);
        //先输出男生 在输出女生
        for (int i = 0;i<boy_list.size();i++){
            System.out.print(boy_list.get(i) +"\t");
        }
        for (int i = 0;i<girl_list.size();i++){
            System.out.print(girl_list.get(i) +"\t");
        }
        System.out.println();
        System.out.println("张东升拍完照后，唱起了小白船~~~~~");

    }
}
