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
 *思路;  由于题目求最终序列中所有数之和，因此我们可以通过找到各次操作后和之间的规律得到结果，而无需生成整个最终序列。
 *
 *         初始序列为   ： x   y                      和S[0]为 x+y
 *
 *         第1次操作后 ：x， x+y， y                 和s[1]为2x+2y
 *
 *         第2次操作后 ：x， 2x+y，x+y，x+2y，y      和s[2]为5x+5y
 *
 *         第3次操作后 ：x，3x+y，2x+y，3x+2y，x+y，2x+3y，x+2y，x+3y，y，和s[3]为14x+14y
 *         由上面可以推出，若第n次操作后序列和为S[n]，则第n+1次操作后的和S[n+1]一定为3*S[n]-(x+y)。
 *         因为在由第n次操作后序列生成第n+1次操作序列时，除首尾两个元素x和y外，中间每个元素会在新序列中产生3次作用（
 *         与前一个元素的和，自身，与后一个元素的和），而首尾两个元素x和y只作用两次，x没有前一个元素，y没有后一个元素。
 */
public class XuLieTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入初始的2个值:");
        int x =  in.nextInt(); //初始值
        int y = in.nextInt();  //初始值
        System.out.println("请输入回合数:");
        int n = in.nextInt();  //回合数
        int sum = x+y;  //s[0]
        //在n个回合内 整个序列的总数为sum = 3 * sum - (x + y);
        for (int i = 1;i<=n;i++){
            sum = 3 * sum - (x + y);
        }
        System.out.println("第"+ n +"回合后, 该序列所有数之和:"+sum);
    }
}
