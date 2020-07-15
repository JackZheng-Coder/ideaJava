package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Scanner;

/**
 * 字符串反码
 * 一个二进制数, 对其每位取反, 我们将得到的数称为原数的反码
 * 下面我们设字符的反码:
 * 如果这是小写字母, 则它距离'a'.的距离, 和它反码距离'z'的距离相同
 * 如果这是大写字母, 则它距离'A'.的距离, 和它反码距离'Z'的距离相同
 * 其他字符(数字和符号)的反码是其本身
 * 输入: 一行字符串(len<80)
 * 输出: 该字符串的反码
 * 样例输入:
 * Hello
 * 样例输出:
 * Svool
 * 样例输入:
 * JLU-CCST-2011
 * 样例输出:
 * QOF-XXHG-2011
 */


public class String_Radix_Minus_Complement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() == 0 || str.charAt(0) == '!'){ //字符串输入错误
            System.out.println("输入有误");
        }
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){ //小写时的情况
                //例子:当前字符为b 则'b'-'a' = 1  'z' - 1 = y
                int t = str.charAt(i) - 'a'; //当前字符减去a的ascii码值
                System.out.printf("%c",'z'-t); //z-t 相当于从z开始遍历得到对应的反码
            }else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){ //大写时的情况
                int t  =str.charAt(i) - 'A';
                System.out.printf("%c",'Z'-t);
            }else //如果不是上面两种情况，则反码为其本身
                System.out.print(str.charAt(i));
        }
        in.close();
    }
}
