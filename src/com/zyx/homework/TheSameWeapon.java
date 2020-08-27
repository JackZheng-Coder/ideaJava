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
public class TheSameWeapon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//人数
        int[] type = new int[n]; //枪枝类型
        for (int i = 0; i <type.length ; i++) {
            type[i] = in.nextInt();
        }
        int[] result = new int[n];//保存结果
        for (int i = 0;i<type.length;i++){
            for (int j = i+1;j<type.length;j++){ //j从i+1开始 保证不会重复
                if (type[i] == type[j]){//如果有相同喜爱的枪枝类型
                    result[i]++;
                    result[j]++;
                }
            }
        }
        //输出结果
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
        in.close();
    }
}
