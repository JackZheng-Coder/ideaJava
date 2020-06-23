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
/*
数字剪切
输入多个数字(大于10. 小于2147483648)
去掉每个数字最大的位数, 然后输出
样例输入:
1023
5923
923
1000
end
样例输出;
23
923
23
0
 */
public class NumberCutTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while((n = in.nextInt()) != 1){ //输入1是终止
            System.out.printf("%d\n",n % (int)Math.pow(10,(int)Math.log10(n))); //通过取模来去除掉最高位，必须用log10来计算
            //例如: (int)Math.log10(1023) = 3 则 1023 % 1000 = 23
        }

    }
}

//另一种做法
/**
 * main(){
 *     int n;
 *     vector<int> resultList;
 *     Scanner in = new Scanner(System.in);
 *     while((n = in.nextInt())!=1){
 *          int result = 0;
 *          int k =1;
 *          whlie(n / 10 >=1){
 *              int m = n % 10;
 *              result = k * m;
 *              k = k*10;
 *              n = n/10;
 *          }
 *          resultList.push(result);
 *     }
 *     for(int i = 0;i<resultList.size();i++){
 *         System.out.println(resultList.get(i));
 *     }
 * }
 */
