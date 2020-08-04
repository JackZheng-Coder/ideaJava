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
 * 张三暑假去伊拉克打暑假工
 * 已知张三最大体力值为M, 战斗力为N, 拥有X条士力架
 * 当张三体力值填满时, 才能参与一次M天的战斗
 * 在同一次战斗中, 张三每战斗N天, 他的战斗力便会增加1点
 * 战斗结束后, 张三需要用士力架来回复自己体力值(恢复满才能参加下一次战斗)
 * 每条士力架最多可以回复N点体力值
 * 设张三当前体力值为0, 当最大体力值为M, 战斗力为N, 拥有X条士力架时, 张三最大可以达到多少战斗力
 * 输入: M, N, X
 * 输出: 张三可以达到的最大战斗力
 * 样例输入:
 * 5 2 10
 * 样例输出:
 * 6
 * 样例解析:
 * 第一次战斗,
 * 起始体力为0/5 战斗力为2   需要3根士力架补充
 * 战斗期5天, 第2天结束时战斗力+1, 第5天结束时战斗力+1
 * 第二次战斗
 * 起始体力值为0/5 战斗力为4 需要2根士力架补充
 * 战斗期5天, 第4天结束时战斗力+1
 * 第三次战斗
 * 起始体力值为0/5 战斗力为5 需要1根士力架补充
 * 战斗期5天, 第5天结束时战斗力+1
 * 第四+次战斗
 * 起始体力值为0/5 战斗力为6 需要1根士力架补充
 * 战斗期5天, 无法提升战斗力
 */
public class Max_Fighting_Force {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_M = in.nextInt();//最大体力值
        int N = in.nextInt();//赋值初始战斗力
        int X = in.nextInt(); //x条士力架
        Max_Fighting(max_M,N,X);
    }
    public static void Max_Fighting(int max_M,int N,int X ){
        int M = 0;//初始体力值
        int fighting_Days = 0;//战斗天数
        while (true){ //通过无线循环来计算
            if (N <= max_M){ //战斗力小于最大体力值时
                M += N;//体力值等于自身加上当前战斗力
                X--;
                if (M >= max_M){ //体力值大于最大体力值时
                    fighting_Days = max_M; //最大体力值赋为多少 战斗天数也为多少
                    while (fighting_Days != 0){
                        fighting_Days -= N; //战斗天数= 战斗天数-战斗力
                        if (fighting_Days < 0){//如果战斗天数小于0时 不符合则跳出
                            break;
                        }
                        N++;//每次战斗完 战斗力就加1
                    }
                    M = 0;//每结束一次 体力值就归0
                }
            }else if (N > max_M || X == 0){ //如果战斗力大于最大体力值时 或者士力架为0时 则跳出循环
                System.out.println("最大战斗力为:"+N);
                return;
            }
        }
    }
}
