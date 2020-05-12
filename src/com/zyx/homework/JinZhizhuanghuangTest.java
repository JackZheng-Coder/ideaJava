package com.zyx.homework;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class JinZhizhuanghuangTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个10进制数:");
        int n = in.nextInt();//输入10进制数

        binaryToDecimal(n);
        System.out.println();

        BaseToDecimal(n);
        System.out.println();

        intToHex(n);
    }

    /**
     * 10进制转2进制
     * 我们可以直接利用移位操作对一个十进制数进行移位操作，
     * 即：将最高位的数移至最低位（移31位），除过最低位其余位置清零，使用& 操作，
     * 可以使用和1相与（&），由于1在内存中除过最低位是1，其余31位都是零，然后把这个数按十进制输出；
     * 再移次高位，做相同的操作，直到最后一位
     * @param n
     */
    public static void binaryToDecimal(int n){
        for(int i =31;i>=0;i--){
            System.out.print(n >>> i & 1);
        }
    }

    /**
     * 10进制转8进制
     * 使用栈来操作，通过保存余数来的到8进制的数
     * @param n
     */
    public static void BaseToDecimal(int n ){
        Stack s = new Stack();
        while (n > 0){
            s.push(n%8+"");
            n = n/8;
        }
        while (!s.empty()){
            System.out.print((String) s.pop());
        }
    }

    /**
     * 10进制转16进制
     * 使用StringBuilder里的append来连接字符串(效率高)，保存余数得到16进制。
     * @param n
     */
    public static void intToHex(int n){
        StringBuilder sb = new StringBuilder();
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (n !=0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        System.out.print(a);
    }
}
