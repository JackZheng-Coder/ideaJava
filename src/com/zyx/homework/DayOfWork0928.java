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
public class DayOfWork0928 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); //输入字符串
        int n = in.nextInt(); //每列有几个字符

        int col = (str.length() + n -1) / n; //通过每列有几个字符算出有几列
        char[][] ch = new char[n][col]; //保存每个字符的数组

        //初始化 将每个位置初始化为空隔
        for (int i = 0;i<n;i++){
            for (int j = 0;j < col;j++){
                ch[i][j] = ' ';
            }
        }
        //找到字符填充的规律：列不变，逐行填充，以 i 为列作为外循环，j 为行作为内循环，填充 ch[j][i]
        for (int i = col - 1,k = 0;i >= 0;i--){
            for (int j = 0;j < n;j++){
                if (k < str.length()){
                    ch[j][i] = str.charAt(k++);//逐列填充
                }
            }
        }
        //输出
        for (int i = 0;i<n;i++){
            for (int j = 0;j < col;j++){
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
        in.close();
    }
}
