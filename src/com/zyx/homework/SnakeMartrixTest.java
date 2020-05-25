package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
//蛇形矩阵

/**
 * 解题思路：
 * 1、定义二维数组snack[n][n]
 * 2、定义一个初始数值，用于累加和，计算遍历时，当下位置的数值。num = 1
 * 定义坐标x,y（x=0，y=0）用于判断当前位置
 * 3、循环条件，while(num<n^2)
 * 4、第一次转向：向右转向 判断是否超出边界值，以及下一个数字是否为0 ，满足条件，填入数字，位置前移
 * while(y+1<snack[x].length()&&snack[x][y+1]==0){
 * y++;
 * snack[x][y] = ++num;
 * }
 * 第二次转向：向下转向 判断边界及其下一个值，满足条件，填入数字，位置下移
 *
 * while (x + 1 < snack.length && snack[x + 1][y] == 0) {
 * x++;
 * snack[x][y] = ++num;
 *
 * }
 *
 * 第三次，第四次 分别向上向左
 */
public class SnakeMartrixTest {
    public static void main(String[] args) {
        int[][] snake = new int[4][4];
        int num = 1;
        int x = 0,y = 0;
        snake[0][0] = 1;

        while (num < 15){
            while (y + 1 < snake[x].length&& snake[x][y+1] == 0){
                y++;
                snake[x][y] = ++num;
            }//向右
            while (x + 1 < snake.length && snake[x+1][y] == 0){
                x++;
                snake[x][y] = ++num;
            }//向下

            while (y-1 >= 0 && snake[x][y-1] == 0){
                y--;
                snake[x][y] = ++num;
            }//向左
            while (x-1 >= 0 && snake[x-1][y] == 0){
                x--;
                snake[x][y] = ++num;
            }//向上
        }

        for (int[] ele : snake) {
            for (int j : ele) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }

    }
}

/***
 * 继承上面的思想，转弯可以看成是XdirArr和YdirArr两个数组组成的集合，转弯的方向是恒定四个方向，即：
 * int []XdirArr={0,1,0,-1};
 * int []YdirArr={1,0,-1,0};
 *
 * 简化转向判断条件：
 * 转向判断条件离不开两个点：
 * 1、超过边界范围
 * (y+YdirArr[i])>(Snake[x].length()-1)
 * 当 YdirArr[i]==1 向右时 超过了数组的长度
 *
 * (y+YdirArr[i])<0
 *
 * 当 YdirArr[i]==-1 向左时 小于数组长度
 *
 * (x+XdirArr[i])>(Snake.length()-1)
 *
 * 当XdirArr[i]==1 向下时 超过了数组的长度
 *
 * 向上时 不可能超过边界 可以自行理解
 *
 * 2、下一个位置有数字了
 *
 * 相对应下一个位置就是：
 * snack[x+XdirArr[i]][y + YdirArr[i]]
 *
 * 可以得到结论：
 * snack[x+XdirArr[i]][y + YdirArr[i]]！=0
 *
 * 3、以上连点必须全部满足，若有一点不满足，那么就转向即i++
 *
 * 最终结论：
 *
 * if((y+YdirArr[i])>(N-1)||(y+YdirArr[i])<0||(x+XdirArr[i])>(N-1)||snake[x+XdirArr[i]][y+YdirArr[i]]!=0){
 * i++;
 * if(i%4 ==0) i = 0;//因为要转圈圈，所以方向必须循环取
 * }
 *
 * 判断是否转向以后，进行数组的赋值
 * y = y+YdirArr[i];
 * x = x+XdirArr[i];
 * snake[x][y] = ++num;
 */


/**
 * public class Snake {
 * 	final static int N = 8;
 * 	public static void main(String[] args) {
 *
 *
 * 		int [][] snake = new int [N][N];
 * 		int num = 1;
 * 		int i = 0;
 * 		int x = 0,y = 0;
 * 		snake[0][0] = 1;
 * 		int []XdirArr={0,1,0,-1};
 * 		int []YdirArr={1,0,-1,0};
 * 		while(num  < N*N){
 *
 * 			if((y+YdirArr[i])>(N-1)||(y+YdirArr[i])<0||(x+XdirArr[i])>(N-1)||snake[x+XdirArr[i]][y+YdirArr[i]]!=0){
 * 				i++;
 * 				if(i%4 ==0) i = 0;
 *                        }
 * 			y = y+YdirArr[i];
 * 			x = x+XdirArr[i];
 * 			snake[x][y] = ++num;
 *
 *
 ** 		}
 * 		for(int[] ele:snake){
 * 			for(int ele1:ele){
 * 				System.out.print(ele1+"\t");* 			}
 * 			System.out.printl        ;
 *    }
 * 	}
 *
 * }
 *
 *
 *
 *
 * */