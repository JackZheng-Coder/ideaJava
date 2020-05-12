package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Home {
    public static void main(String[] args) {
        f();
    }
    public  static void f() {
        //输出上边的房顶
        for(int i=4;i>=0;i--) {
            for(int j=0;j<=13;j++) {//输出房顶，共5行14列
                if(i<=4&&j<i) {//输出第一部分的空白倒三角
                    System.out.print(" ");
                }
                else if(j<=i+4) {//输出第二部分的每行五个*
                    System.out.print("*");
                }
                else if(j==13-i){//输出第三部分斜着的*，利用总列数减去i；
                    System.out.print("*");
                }
                else {//剩余部分空白
                    System.out.print(" ");
                }
            }
            System.out.println();//每输出一次换行
        }
        //输出下边的框体
        for(int i=0;i<=4;i++) {//第几行，共5行
            for(int j=0;j<=13;j++) {//第几列，共14列
                if(i==0||i==4) {//第一行和最后一行输出*号
                    System.out.print("*");//输出*和后边的空格
                }else if ((j==0)||(j==13)){//输出第一列和最后一列
                    System.out.print("*");
                    for (int k = 1;k<=6;k++){
                        System.out.print(" ");
                    }
                }else if (((i==1)||(i==2)||(i==3)) && ((j==9)||(j==10))){//打印门
                    System.out.print("#");
                    for (int m = 11;m<=12;m++){
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();//每输出一次换行
        }

    }
}
