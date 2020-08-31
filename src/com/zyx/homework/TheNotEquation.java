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

/**
 * 最多次成立的不等式
 * 给定n个关于X的不等式, 求最多能有多少个成立
 * 不等式形式如下
 * X < C
 * X <= C
 * X = C
 * X > C
 * X >= C
 * 注: X可以不是整数
 */
public class TheNotEquation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //几个不等式
        String[] op = new String[n];//保存符号
        int[] num = new int[n];//保存数字
        for (int i = 0;i<n;i++){
            System.out.print("X");
            op[i] = in.next();
            num[i] = in.nextInt();
            num[i] *= 2; //因为C可能是小数 所以要乘于2防止出现小数
        }

        int ans = 0; //最终结果
        for (int i = 1;i<=2001;i++){ //因为num[i] * 2后 所以范围也要乘于2
            int sum = 0;//临时变量
            for (int j = 0;j<n;j++){
                if (op[j].equals("<") && i < num[j]){
                    sum++;
                }
                if (op[j].equals("<=") && i<=num[j]){
                    sum++;
                }
                if (op[j].equals("=") && i == num[j] ){
                    sum++;
                }
                if (op[j].equals(">") && i > num[j]){
                    sum++;
                }
                if (op[j].equals(">=") && i >= num[j]){
                    sum++;
                }
            }
            if ( ans < sum)
                ans = sum;
        }
        System.out.println(ans); //输出
        in.close();
    }
}
