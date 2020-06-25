package com.zyx.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
/*
单词长度判断
 输入一行字符串(len < 1000), 字符串由字母, 数字, 空格, 其他符号组成
设每个被空格分隔的字母/数字/其他符号 都算作单词
输出每个单词的长度,   每个值用逗号隔开
注: 没有被空格间隔开的符号串，都算作单词。
样例输入:
She was born in 1990-01-02  and  from Beijing city.
样例输出:
3,3,4,2,10,3,4,7,5

 */
public class StringCountTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int  count = 0; //保存每个单词的长度
        List<Integer> list = new ArrayList<>(); //保持每个单词的长度的集合
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) != ' '){ //如果该字符不为空格 这count++
                count++;
                if (str.charAt(i) == '.'){ //如果碰到句号 直接将长度添加到集合中，退出循环
                    list.add(count);
                    break;
                }
            } else if (str.charAt(i) == ' ' ){ //如果是空格，则把当前单词长度添加到集合中，count重新归0
                list.add(count);
                count = 0;
            }
        }
        for (int i = 0;i<list.size();i++){
            System.out.print(list.get(i) + "\t"); //输出
        }
        in.close();
    }
}
