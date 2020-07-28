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
 * 样例输入:
 * 0 7 2
 * 0 5 0
 * 0 3 0
 * 样例输出:
 * 6 7 2
 * 1 5 9
 * 8 3 4
 */
public class Sudoku {
    static int count = 0; //统计有多少种结果
    static int[] arr = new int[9];  //存储九宫格的九个数字
    static int[] res = new int[9];   //记录唯一的结果
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一组矩阵:");
        for (int i = 0;i<9;i++){
            arr[i] = in.nextInt(); //赋值
        }
        dfs(0);
        int c=0;
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                System.out.print(res[c++] + " ");
            }
            System.out.println();
        }
    }
    //深搜，依次遍历每一个格子
    private static void dfs(int index){
        if (index == 9){//递归出口
            if (isOk()){//检查当前的九宫格是否符合条件
                if (count == 0){
                    for (int i = 0;i<arr.length;i++){
                        //res = arr;  不能用这样的赋值方式，因为res和arr是对象的引用，
                        //如果这样赋值，arr之后改变，res也会改变
                        res[i] = arr[i];
                    }
                    count++;
                }else {
                    System.out.println("Too Many");
                    System.exit(0);
                }
            }
            return;
        }
        if (arr[index] == 0){
            for (int i = 1;i<=9;i++){
                if (check(index,i)){//如果能放
                    arr[index] = i;
                    dfs(index+1);
                    arr[index] = 0;   //回溯
                }
            }
        }else {
            dfs(index+1);
            return ;
        }
    }

    //检查九宫格是否符合条件
    private static boolean isOk(){
        int[][] a = new int[3][3];
        int c = 0;
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                a[i][j] = arr[c++];
            }
        }
        int sum = a[0][0] + a[0][1] +a[0][2];//第一行的和
        if(a[1][0] + a[1][1] + a[1][2] != sum)
            return false;
        if(a[2][0] + a[2][1] + a[2][2] != sum)
            return false;
        if(a[0][0] + a[1][0] + a[2][0] != sum)  //计算第一列
            return false;
        if(a[0][1] + a[1][1] + a[2][1] != sum)
            return false;
        if(a[0][2] + a[1][2] + a[2][2] != sum)
            return false;
        if(a[0][0] + a[1][1] + a[2][2] != sum)  //计算主对角线
            return false;
        if(a[0][2] + a[1][1] + a[2][0] != sum)  //计算斜对角线
            return false;
        return true;

    }
    //检查x是否已经放过
    private static boolean check(int index,int x){
        for (int i = 0;i<arr.length;i++){//是要与之前的数进行对比，不是所有的数进行对比
            if (arr[i] == x){
                return false;
            }

        }
        return true;
    }
}
