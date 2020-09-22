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
public class DayOfWork0921 {
    static char[][] maps;//保存迷宫
    static boolean[][] flag;//判断这个位置是否能走
    static int x, y;
    static boolean out = false;//最终能否走出迷宫

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        maps = new char[x][y];
        flag = new boolean[x][y];
        int sx = 0;  //起始点
        int sy = 0;
        for (int i = 0;i<x;i++){
            //对char数组赋值比较麻烦
            String str = in.next();
            for (int j = 0;j<str.length();j++){
                char temp = str.charAt(j);
                if (temp == 'S'){ //遇到初始位置
                    sx = i;
                    sy = j;
                }
                maps[i][j] = temp;
            }
        }
        //初始化的一些操作
        flag[sx][sy] = true; //最出的位置是可走的
        dfs(sx,sy);
        if (out) //如果可以走出迷宫
            System.out.println("true");
        else
            System.out.println("false");
    }
    //深度搜索 判断能否走出迷宫
    public static void dfs(int tx,int ty){
        int direction[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  //往四个方向走
        if (maps[tx][ty] == 'T'){ //碰到终点
            out = true;
            return;
        }
        //遍历 可以行走的四个方向
        for (int k = 0; k < 4; k++){
            //新值
            int nx = tx + direction[k][0];
            int ny = ty + direction[k][1];
            //符合条件的位置，设置为可走，然后递归继续寻找
            if (nx < x && nx >= 0 && ny < y && ny >= 0 && maps[nx][ny] != '*' && flag[nx][ny] == false){
                flag[nx][ny] = true;  //确保走过的不再走
                dfs(nx,ny);
            }
        }
    }
}
