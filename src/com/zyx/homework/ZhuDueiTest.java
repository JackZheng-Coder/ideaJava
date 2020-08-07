package com.zyx.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class ZhuDueiTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入人数:");
        int n = in.nextInt(); //人数
        if ((n < 2 || n > 100) &&  n % 2 != 0) {
            System.out.println("输入的人数有误");
            return;
        }
        int nedd_day = 0;//一共需要的战斗天数
        int[] num = new int[n];//保存每个人战斗力
        for (int i = 0;i<num.length;i++){
            num[i] = in.nextInt(); //赋值战斗力
        }
       Arrays.sort(num);//对战斗力进行排序
       for (int i = 0;i<num.length-1;i+=2){
           nedd_day += num[i+1] - num[i];//因为一定是偶数 所以可以进行两两匹配 需要战斗力天数就为加上每一对之间的差值
       }
        System.out.println("一共需要"+nedd_day+"天");
       in.close();
    }
}

