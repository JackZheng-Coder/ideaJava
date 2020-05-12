package com.zyx.homework;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class StrngNumberTest {
    /**
     * 输入一串字符, 打印其中每个字符出现的次数(如果没有则不显示)
     * 样例输入:
     * Hello, World.
     * 样例输出: 'H':1, 'W':1, 'd':1, 'e':1, 'l':3, 'o':2, 'r':1, ',':1, '.':1
     * @param args
     */
    /**
    * 分析：
     * 1，定义一个需要被统计字符的字符串
     * 2，将字符串转化为字符数组，才能拿到每一个字符
     * 3，定义双列集合存储字符串中字符以及字符出现的次数
     * 4，遍历字符数组获取每一个字符，并将字符存储在双列集合中
     * 5，存储过程中要做判断，如果集合中不包含这个键，就将该字符当作键，值为1存储；如果集合中包含这个键，就将值加1存储
     * 6，打印双列集合获取字符出现的次数
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        //1，定义一个需要被统计字符的字符串,并随意输入一串字符串
        String str = in.nextLine().trim();
        //2 将字符串转化为字符数组
        char[] ch = str.toCharArray();
        //3,定义双列集合存储字符串中字符以及字符出现的次数
        HashMap<Character,Integer> yy = new HashMap<>();
        //4，遍历字符数组获取每一个字符，并将字符存储在双列集合中
        for (char c:ch) {
            //5存储过程中要做判断，如果集合中不包含这个键，就将该字符当作键，值为1存储；如果集合中包含这个键，就将值加1存储
//            if (!yy.containsKey(c)){
//                yy.put(c,1);
//            }else {
//                yy.put(c,yy.get(c)+1);
//            }
            yy.put(c,!yy.containsKey(c) ? 1 :yy.get(c) + 1);
        }

        //6，打印双列集合获取字符出现的次数
        for (Character key : yy.keySet()) {                 //yy.keySet() : 代表所有键的集合
            System.out.println(key + "=" + yy.get(key));    //yy.get(key) : 根据键获取值
        }
    }
}
