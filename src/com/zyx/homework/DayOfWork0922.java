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
 * 思路：先判断输入的棋子的落点的长度是否大于9 如果小于9,就判断是奇数还是偶数，如果是偶数张三就赢了，反之就是高手赢;
 * 如果长度大于9开个 int 型二维数组，存储棋盘。把 高手 下的地方赋值为1，张三下的则为0；
 * 枚举判断所有可能赢的情况，如果有1人赢，就输出结果并返回 0（结束程序）；
 *如果以上都不成立，输出“平局”。
 */
public class DayOfWork0922 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[][] board = new int[4][4]; //存储棋盘 在str长度大于9时使用
        if (str.length() < 9) { //长度小于9
            if (str.length() % 2 == 0) { //偶数张三赢
                System.out.println("yes!!!");
            } else {
                System.out.println("no!!!!");
            }
            return;
        }
        /**
         * 因为高手总是第一个先出 所以当长度大于9时，高手下棋的的个数一定是5个，而且一定都在偶数位上
         */
        for (int i = 0; i <= 8; i++) {
            if (i % 2 == 0) {
                board[(str.charAt(i) - '1') / 3 + 1][(str.charAt(i) - '1') % 3 + 1] = 1; //将高手下的位置赋值1
            }
        }
        for (int i = 1;i<=3;i++){
            //暴力判断
            if ( ( board[i][1] + board[i][2] + board[i][3] == 3 ) || ( board[1][i] + board[2][i] + board[3][i] == 3 ) || ( board[1][1] + board[2][2] + board[3][3] == 3 ) || ( board[3][1] + board[2][2] + board[1][3] == 3 ) ){
                System.out.println("no!!!!");
            }else if ( ( board[i][1] + board[i][2] + board[i][3] == 0 ) || ( board[1][i] + board[2][i] + board[3][i] == 0 ) || ( board[1][1] + board[2][2] + board[3][3] == 3 ) || ( board[3][1] + board[2][2] + board[1][3] == 3 ) ){
                System.out.println("yes!!!!!");
            }
        }
        System.out.println("drew");
        return;
    }
}