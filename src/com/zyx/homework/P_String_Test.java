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
public class P_String_Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String str = in.next();
        char[] ch = str.toCharArray(); //将获得的字符串转为字符数组
        int sum = 1; //统计当前字符连续相同的个数
        for (int i = 0;i<ch.length-1;i++){
            if (ch[i] == ch[i+1]){ //如果字符相同且连续 sum++
                sum++;
            }else {//否则输出当前sum值和当前字符值
                System.out.print(sum);
                System.out.print(ch[i]);
                sum = 1;//重新设为1
            }
        }
        //最后一个字符的处理尽量不要放在for循环内处理，否则会重复输出
        System.out.print(sum);
        System.out.print(ch[ch.length-1]);
        in.close();
    }
}
