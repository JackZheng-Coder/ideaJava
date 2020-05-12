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
public class Test {
    /**
     * java输入任意长度(小于500)字符串, 将其中的小写字母替换为大写字母, 大写字母替
     * @param args
     */
    //思路:输入一个字符串装换成字符，之后通过ascii码进行大小写操作
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String str = in.nextLine();//接收字符串
        char[] arr = str.toCharArray();//将字符串装换成字符数组
        for (int i = 0;i < arr.length;i++){
            if ((int)arr[i] >= 65 && (int)arr[i] <= 90){ //小写字母装换成大写字母
                arr[i] += 32;
            }else if ((int)arr[i] >= 97 && (int)arr[i] <= 122){     //大写字母装换成小写字母
                arr[i] -= 32;
            }
        }
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "");
        }
    }
}
