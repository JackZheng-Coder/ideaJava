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
public class Day0902 {
    //dfs  只能去*号地方 不能去#号地方 遍历数组 找最大可以走的面积  只能上下左右 不能斜对角移动
    static char[][] maps;
    static boolean[][] flag;
    static int x, y;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("样例输入:");
        y = sc.nextInt();
        x = sc.nextInt();
        sc.nextLine();
        maps = new char[x][y];
        flag = new boolean[x][y];
        int sx = 0;  //起始点
        int sy = 0;
        //输入地图
        for (int i = 0; i < x; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char temp = str.charAt(j);
                if (temp == '@') {
                    sx = i;
                    sy = j;
                }
                maps[i][j] = temp;
            }
        }
        //初始化的一些操作
        flag[sx][sy] = true;
        max = 1;//认为脚下这个也算活动范围
        dfs(sx, sy);

        System.out.println("样例输出：\n"+max);
    }

    static void dfs(int tx, int ty) {
        int direction[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  //往四个方向走
        //遍历 可以行走的四个方向
        for (int k = 0; k < 4; k++) {
            //新值
            int nx = tx + direction[k][0];
            int ny = ty + direction[k][1];
            //不设置退出 条件 这里直接设置 不能走到不可到的地面
            if (nx < x && nx >= 0 && ny < y && ny >= 0 && maps[nx][ny] != '#' && flag[nx][ny] == false) {
                flag[nx][ny] = true;  //确保走过的不再走
                max++;
                dfs(nx, ny);  //进入下个循环
            }
        }
    }

}
