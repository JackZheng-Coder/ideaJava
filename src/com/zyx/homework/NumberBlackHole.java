package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 数字黑洞
 * 二年级的张三发现一个神奇的现象
 * 1. 将一个任意四位数的每位数字
 * 2. 组成的四个数字从大到小/从小到大排列
 * 3. 将得到的大数字减去小数字
 * 然后一直重复23项, 最终会得到6174
 * 张三给这一数字起名叫张三常数
 * 并且他发现 三位数也会出现同样的情况
 * 输入数字n(100<n<9999)
 * 计算该数字需要多少遍以上运算, 才能得出张三常数. 并打印计算过程
 * 样例输入:
 * 1324
 * 样例输出:
 * 4321 - 1234 = 3087
 * 8730 - 378 = 8352
 * 8532 - 2358 = 6174
 */
public class NumberBlackHole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean tag = true; //循环的标志位
        while (tag) {
            Integer[] num = toArray(n); //将数字转为数组
            // 从小到大排序
            Arrays.sort(num);
            int b = toInteger(num);
            // 从大到小
            Arrays.sort(num, new MyComparatorInteger1019());
            int a = toInteger(num);
            n = a - b; // n保存a-b的结果
            System.out.printf("%04d - %04d = %04d\n", a, b, n); //输出
            if (n==0||n==6174) { //如果n=0或者n=6174 设置tag为false退出循环
                tag = false;
            }
        }


    }
    //数字转为数组
    public static Integer[] toArray(int n) {
        Integer[] result = new Integer[4];
        for (int i = 0; i < 4; ++i) {
            result[i] = n % 10;
            n = n / 10;
        }
        return result;
    }
    //数组转为数字
    public static int toInteger(Integer[] num) {
        int sum = 0;
        for (int i = 0; i < 4; ++i) {
            sum = sum * 10 + num[i];
        }
        return sum;
    }
}




//自定义比较器
class MyComparatorInteger1019 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
