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

public class DayOfWork0916 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;//正确的计算个数
        for (int i = 0;i < n;i++){
            String str = scan.next().trim();//用字符串来表示计算式
            if (!str.contains("?")){//如果有包含? 直接跳过
                int x = str.indexOf('+');//获取+号下标
                int y = str.indexOf('-');//获取-号下标
                int z = Integer.parseInt(str.substring(str.indexOf('=') + 1));//提取等号后一位的数字字符串并转换为数字型

                boolean flag = true;//判断计算是否正确
                if (x != -1) { //是求和运算
                    if (Integer.valueOf(str.substring(0, x)) //判断江苏省是否正确
                            + Integer.valueOf(str.substring(x + 1,
                            str.lastIndexOf('='))) == z)
                        flag = true;
                    else
                        flag=false;
                } else {//差运算
                    if (Integer.valueOf(str.substring(0, y))
                            - Integer.valueOf(str.substring(y + 1,
                            str.lastIndexOf('='))) == z)
                        flag = true;
                    else
                        flag=false;
                }

                if (flag)
                    sum++; //计算正确个数+1
            }
        }
        System.out.println(sum);//输出正确个数
    }
}
