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
 * 扫雷游戏计算
 * 输入一个由?和*组成的矩阵, ?表示空地, *表示地雷
 * 将所有?替换为数字, 数字表示周围的8个格子中, 有多少颗地雷
 * 样例输入:
 * ??*?
 * ??*?
 * ????
 * *???
 * end
 * 样例输出:
 * 02*2
 * 02*2
 * 1211
 * *100
 */
public class SaoLeiTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] a = new char[101][101]; //保存字符
        int[] X=new int[]{-1,-1,-1,0,1,1,1,0}; //x轴
        int[] Y=new int[]{-1,0,1,1,1,0,-1,-1}; //y轴
        int s,r,c; //s->最终附近雷的数量  r->行上的雷  c->列上的雷
        int n = scan.nextInt();  //输入n行
        int m = scan.nextInt();  //输入m个字符

        //输入字符串 ，转为字符数组
        for (int i = 0; i <n ; i++) {
            String str = scan.next();
            a[i] = str.toCharArray();
        }
        for (int i= 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (a[i][j] == '*'){  //如果为雷 打印*
                    System.out.print('*');
                }else {
                    s = 0;
                    for (int k = 0;k<8;k++){ //在8个格子之内
                        r = i+X[k];
                        c = j+Y[k];
                        int temp; //临时变量 保存附近雷的数量
                        if(r>=0 && r<n && c>=0 && c<m &&a[r][c]=='*') temp=1; //附近有雷 则temp+1

                        else temp = 0;
                        s += temp;  //总共该位置附近雷的数量
                    }
                    System.out.print(s); //打印数量
                }
            }
            System.out.println();
        }

        scan.close();
    }
}

/**
 *
 * #include<stdio.h>
 * int s[101][101]={0};
 * char a[101][101],b;
 * int main()
 * {
 *     int n,m,i,j,i1,i2,j1,j2;
 *     scanf("%d%d",&n,&m);
 *     scanf("%c",&b);
 *     for(i=1;i<=n;i++)
 *     {
 *         for(j=1;j<=m;j++)
 *         {
 *             scanf("%c",&a[i][j]);
 *             if(a[i][j]=='*')
 *             {
 *                 i1=i-1;i2=i+1;j1=j-1;j2=j+1;
 *                 s[i1][j1]++;
 *                 s[i1][j2]++;
 *                 s[i1][j]++;
 *                 s[i2][j1]++;
 *                 s[i2][j2]++;
 *                 s[i2][j]++;
 *                 s[i][j1]++;
 *                 s[i][j2]++;
 *             }
 *         }
 *         scanf("%c",&b);
 *     }
 *     for(i=1;i<=n;i++)
 *     {
 *         for(j=1;j<=m;j++)
 *         {
 *             if(a[i][j]=='*')
 *                 printf("%c",a[i][j]);
 *             else
 *                 printf("%d",s[i][j]);
 *         }
 *         printf("\n");
 *     }
 *     return 0;
 * }
 *
 *
 */
