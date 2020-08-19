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
public class JiuGonGeTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] arr = new char[][]{{'a','b','c'},{'d', 'e', 'f'},{'g','h','i'},{'j', 'k', 'l' },{'m', 'n', 'o'},{'p', 'q', 'r', 's'},
                {'t','u','v'},{'w', 'x', 'y', 'z'},{' ','*','#'} };//保存手机上按键对应的字符 这里把1的按键给排除掉了
        int count = 0;//统计要按多少次
        System.out.println("请输入字符串，来统计打印次数:");
        String str = in.nextLine();//一定要用nextLine 不能用next
        for (int i = 0;i<str.length();i++){
            //暴力循环
            for (int j = 0;j<arr.length;j++){
                for (int m = 0;m<arr[j].length;m++){
                    if (str.charAt(i) == arr[j][m]){
                        count = count + m +1; //+1是因为下标从0开始  但是次数要从1开始
                        break;
                    }
                }
            }
        }
        System.out.println("一共要打印:"+count+"次");//
        in.close();
    }
}
