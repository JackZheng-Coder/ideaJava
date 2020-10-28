package com.zyx.homework;

import java.util.ArrayList;
import java.util.Arrays;
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

/**
 * 排列组合的问题，用模拟进制的方法即可
 * 比如，以下从右向左，满2进位
 * 111
 * 112
 * 121
 * 122
 * 211
 * 212
 * 221
 * 222
 * 看到规律的吗？就像二进制01进位一样，001，010，011，100，101，110，111
 * 这样，找出每种组合的总个数满足原子组合的总个数即可，比如原子总个数是5，那就只有122=1+2+2=5，212=2+1+2=5，221=2+2+1=5，3种符合
 */
public class DayOfWork1023 {
    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();//原子总的个数

            int elem[] = new int[10]; //每种原子的个数

            Arrays.fill(elem, 1); //对每种原子个数初始化都为1

            int max = n/10 + 1; //保证原子使用次数在1到3之间
            if (max > 3){ //当n= 30 时, max要减一
                max--;
            }

            List<String> result = new ArrayList<>();//保存每种方案

            while(elem[0]<=max) {

                int sum = 0;

                for(int i=0; i<10; i++) sum += elem[i]; //原子总个数

                if (sum==n) { //原子总个数和n相等则保存结果

                    result.add(Arrays.toString(elem).replaceAll("[\\[\\],]", ""));

                }

                elem[9]++; //原子总个数变化

                for(int i=9; i>0; i--) {

                    if (elem[i]>max) { //相当于二进制封2进1

                        elem[i-1]++;

                        elem[i] = 1;

                    }

                }

            }

            System.out.println(result.size()); //输出方案数

            for (String s : result) {

                System.out.println(s);

            }



        } catch (Throwable e) {

            e.printStackTrace();

        }

    }
}
