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
 * 本题只需要考虑向前F和向左L，向右R相当于调用三次L，向后相当于调用了三次F
 */
public class DayOfWork1130 {
    public static int[] a = {1,6,4,3,2,5};//初始的上下左右前后编号。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();//输入要进行的操作
        char[] ch = str.toCharArray();
        for (int i = 0;i<ch.length;i++){
            if (ch[i] == 'F'){
                F();
            }
            if (ch[i] == 'L'){
                L();
            }
            if (ch[i] == 'B' ){
                F();
                F();
                F();
            }
            if (ch[i] == 'R'){
                L();
                L();
                L();
            }
        }
      for (int i = 0;i<a.length;i++){
          System.out.print(a[i]+"\t");
      }
    }
    //向前操作,原本是{  1,  6,  4,  3,  2,  5  }, F后：｛5，2，4，3，1，6｝相当于交换y，z轴，x轴不变
    public static void F(){
        Swap(a,0,5);//相当于1和5交换
        Swap(a,5,4);//相当于1和2交换
        Swap(a,5,1);//相当于2和6交换
    }
    //向左操作 相当于交换想x,y轴，z轴 不变。
    public static void L(){ //{  1,  6,  4,  3,  2,  5  },L操作后｛3，4，1，6，2，5｝
        Swap(a,1,3); //相当于3，6交换
        Swap(a,0,1);//相当于1，3交换
        Swap(a,1,2);//相当于1，4交换
    }
    //交换数字
    public static void Swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
