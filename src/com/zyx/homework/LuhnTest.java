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
 * Luhn校验:
 * 将一串数字从右往左取偶数位的数字 先乘2 如果乘积是两位数 则减去9  然后再和
 * 将这串数字从右往左取奇数位的数字 并求和
 * 将得到的两个数字相加, 如果能被10整除, 说明校验通过
 */
public class LuhnTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入有几张银行卡:");
        int n = in.nextInt();
        String[] str = new String[n]; //保存银行卡号
        for (int i = 0;i<n;i++){
            str[i] = in.next();//赋值
        }
        Luhn(str);//调用函数
    }
    //Luhn函数，挑选符合的银行卡号
    public static void Luhn(String[] str){
        int evenSum = 0;//偶数位的总和
        int oddSum = 0;//奇位数的总和
        int sum = 0 ; //总和
        for (int i = 0;i<str.length;i++){//将字符串数组转化位字符数组
            char[] ch = str[i].toCharArray();
            for (int j = ch.length-1;j>=0;j--){ //从右往左
                int k = ch[j] - '0'; //转变为int类型
                if (j % 2 == 0){ //偶数位
                    int evenNum = k *2;
                    if (evenNum >= 10){//如果乘积是两位数 ，则减去9
                        evenNum -= 9;
                        evenSum += evenNum;//加到偶数总和
                    }else {
                        evenSum += evenNum;//加到偶数总和
                    }
                }else {//奇数位
                    oddSum += k;
                }
            }
            sum = evenSum + oddSum;//奇数总和 和 偶数总和的总值
            if (sum % 10 == 0){//如果可以被10 整除说明校验通过
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }
}
