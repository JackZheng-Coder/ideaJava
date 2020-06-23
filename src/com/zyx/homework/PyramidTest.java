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
public class PyramidTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入金字塔的层数:");
        int n = in.nextInt();
        //外层循环控制层数
        for (int i = 1;i<=n;i++){
            //根据外层行号，输出星号左边的空格
            for (int j =1;j<=n-i;j++){
                System.out.print(" ");
            }
            System.out.print("/"); //先输出空格在输出反斜杠
            //根据外层行号，输出_号个数
            for (int k =1;k<=2*i-1;k++){
                if (k == 1){
                    System.out.print(" ");
                }else {
                    System.out.print("_");
                }
            }
            System.out.print("\\"); //输出斜杆
            System.out.println();//每输出一行就换行
        }
        in.close();
    }
}
