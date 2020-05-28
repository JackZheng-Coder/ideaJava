package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 图片的变化
 * 图片的变化命令:
 * a: 顺时针旋转90
 * b: 逆时针旋转90
 * c: 左右翻转
 * d: 上下翻转
 * 输入一个矩阵和对应的变化命令
 * 输出变化后的矩阵
 * 样例输入:
 * 10 0 10
 * 100 100 10
 * ac
 * 样例输出:
 * 10 100
 * 0 100
 * 10 10
 */



import java.util.Scanner;

/**
 * 例如原始数组为a数组，变换后存入b数组当中，分析每种变换之后的坐标有什么特点以及行和列有什么变化：
 *
 * 顺时针翻转：b[j][m-1-i]= a[i][j];   b数组的行数是a数组的列数，b数组的列数是a数组的行数-1-当前的行；
 *
 * 逆时针翻转：b[n-1-j][i]= a[i][j];  b数组的行数是a数组的列数-1-当前的列数，b数组的列数是a数组的行数；
 *
 * 左右翻转：b[i][n-1-j]= a[i][j];   行和不变,列数是a数组的列数-1-当前的列数；
 *
 * 上下翻转：b[m-1-i][j]= a[i][j];  列均不变，行是a数组的行数-1-当前的行；
 */
public class MatrixReverrsalTest {
    public static int[][] a = new int[100][100]; //定义初始的数组
    public static int[][] b = new int[100][100]; //将数组a进行翻转后保存到数组b中

    public static int m,n;//定义行,列

    //定义复制数组函数 将数组b重新复制到数组a中
    public static void copyab(){
        for(int i = 0; i < m; i++) {
            for(int j = 0;j < n;j++){
                a[i][j] = b[i][j];
            }
        }
    }

    //定义顺时针翻转函数
    public static void clockwise(){
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                b[j][m-1-i] = a[i][j];
            }
        }
        int t = m; //临时变量t 交换m,n 否则 copyab()会出错
        m = n;
        n = t;
        copyab(); //翻转一次，将b重新复制到a中
    }
    //定义逆时针翻转函数
    public static void anticlockwise() {
        for(int i = 0; i < m; i++) {
            for(int j= 0; j <n; j++) {
                b[n-1-j][i]=a[i][j];
            }
        }
        int t = m;//临时变量t 交换m,n 否则 copyab()会出错
        m = n;
        n = t;
        copyab();//翻转一次，将b重新复制到a中

    }
    //定义左右翻转函数
    public static void flip(){
        for(int i = 0; i < m; i++) {
            for(int j= 0; j <n; j++) {
                b[i][n-1-j]=a[i][j];
            }
        }
        copyab();//翻转一次，将b重新复制到a中
    }
    //定义上下翻转函数
    public static void upside_down() {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                b[m-1-i][j]=a[i][j];
            }
        }
        copyab();//翻转一次，将b重新复制到a中
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
        * 数组赋值
        * */
        m = in.nextInt();
        n = in.nextInt();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        //2.输入字符串并判断每个字符调用对应的函数
        String str;
        str = in.next();
        char[] s = str.toCharArray(); //转换字符数组
        for(int i = 0;i < s.length;i++){
            if(s[i] == 'A'){
                clockwise();
            }else if(s[i] == 'B'){
                anticlockwise();
            }else if(s[i] == 'C'){
                flip();
            }else if(s[i] == 'D'){
                upside_down();
            }

        }
        //3.输出变换后的二维数组
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        in.close();
    }
}