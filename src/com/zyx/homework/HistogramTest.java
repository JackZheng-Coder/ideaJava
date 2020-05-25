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
 * 实现直方图
 * 思路：通过一个一维数组保存*号个数，然后复制到二维字符数组中，再转置就得到结果
 */
public class HistogramTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入列数:");
        int n = in.nextInt();//列数
        int[] arr = new int[n];//原来保持列数上的*号个数
        char[][] ch = new char[n][];//保存*号
        for (int i = 0;i<n;i++){
            arr[i] = in.nextInt();//输入每列*号个数
        }
        /**
         * 赋值*号
         */
       for (int i = 0;i<arr.length;i++){
           ch[i] = new char[arr[i]];
           for (int j = 0;j<arr[i];j++){
               ch[i][j] = '*';
           }
       }
//       for (int i = 0 ;i<ch.length;i++){
//           for (int j = 0;j<ch[i].length;j++){
//               System.out.print(ch[i][j] + "\t");
//           }
//           System.out.println();
//       }

        /**构造结果新二维数组用于存放转置结果**/
        // 而构造二维数组可以为维度来进行，不一定是一个矩阵，即每一行的长度不一定相同
        int second = 0;
        // 取出二维中最大的数组长度
        for (char temp[] : ch)
        {
            second = second > temp.length ? second : temp.length;
        }
        char result_arr[][] = new char[second][];// 先实现第一维
        // 再实现第二维,实际上二维的长度应该是一样的
        for (int i = 0; i < second; i++)
        {
            result_arr[i] = new char[ch.length];
        }
        /** 进行元素倒置  **/
        for (int i = 0; i < ch.length; i++)
        {
            for (int j = 0; j < ch[i].length; j++)
            {
                result_arr[j][i] = ch[i][j]; // 转置核心
            }
        }
        /** 打印转置后的结果：对于缺少的元素，只能默认打印出0 **/
        for (char x[] : result_arr)
        {
            for (char e : x)
            {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        in.close();
    }

}

