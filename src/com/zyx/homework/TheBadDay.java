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
public class TheBadDay {
    public static void main(String[] args) {
        //因为是闰年 使所以2月只有28天
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //记录每个月份的天数
        Scanner in = new Scanner(System.in);
        System.out.println("请输入1月1号为星期几:");
        int week_day = in.nextInt();//输入1.1号是星期几
        if (week_day >= 1 && week_day <= 7){
            //先计算一月的13号是否是星期5
            week_day = (week_day + 12) % 7; //1号与13号差12天 所以要加12
            if (week_day == 5){//如果13号为星期五 输出1月
                System.out.println(1+"月13号为星期五");
            }
            for (int i = 0;i<days.length;i++){
                week_day = (week_day + days[i]) % 7;
                if (week_day == 5){
                    System.out.println(i+2+"月13号为星期五");//下标从0开始，且1月已经判断过了 所以要+2
                }
            }
        }
        in.close();
    }
}
