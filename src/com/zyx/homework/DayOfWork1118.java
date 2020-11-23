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
 * 主要是确定前面有几个个位数。我的方法是分类讨论：
 * （1）如果长度为2，则两个数都是个位数；
 * （2）如果长度为3，则可能有两种那个情况：三个数都是个位数；一个个位数，一个两位数。
 * （3）如果长度大于等于4，可以用前4个数字来判断第一个数是否为两位数。假设前两个数字组成的两位数n，
 * 第三和第四个数字组成的两位数m，那么就看是否满足m=n+1或者m=n+2，如果满足，则说明第一个数是两位数，如果不满足，说明第一个数是个位数。
 */
public class DayOfWork1118 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        int len = ch.length;
        int ans = 0;
        if (len == 2) {//都是个位数
            ans = ch[0] - '0' + 1;
        } else if (len == 3) {//两种情况
            if (ch[2] == '0' || ch[2] == '1') { //2个个位数，1个2位数
                ans = ch[0] - '0' + 1;
            } else if (ch[0] + 1 == ch[1]) {//都是个位数的情况,并且是在第2个和第3个之间的漏掉
                ans = ch[1] - '0' + 1;
            } else//都是个位数的情况,并且是在第1个和第2个之间的漏掉
                ans = ch[0] - '0' + 1;
        } else {//如果长度大于等于4
            int n = (ch[0] - '0')*10 + ch[1]-'0';
            int m = (ch[2] - '0') * 10 + ch[3] - '0';
            if (n + 2 == m || n + 1 == m) {//m=n+1或者m=n+2，如果满足，则说明第一个数是两位数，
                int j = (ch[0] - '0') * 10 + ch[1] - '0';//第一个数字(两位数)
                for (int i = 2; i < len; i += 2) {//从第二个数字开始(两位数)
                    int k = (ch[i] - '0') * 10 + ch[i + 1] - '0';
                    if (k == j + 2) {//满足，k和j之间存在漏数字
                        ans = j + 1;
                    }
                    j = k;
                }
            }
            else {//第一个数字是个位数
                int tip = 0;//因为第一个数是个位数，后面会有多种情况，如果tip为1表示漏掉的数字是个位数
                int i;
                for (i = 0;i+1 < len && ch[i]-'0'<9;i++){//漏掉的数字是给位数的情况
                    if (ch[i+1] - '0' == ch[i]-'0' +2){
                        ans = ch[i]-'0'+1;
                        tip = 1;
                        break;
                    }
                }
                if (tip == 0){//漏掉的数字不是个位数
                    if ((ch[i+1] -'0')* 10 + (ch[i+2]-'0') == 11){//特殊情况 第一个数字为9的情况
                        ans = 10;
                    }
                    else {//和上面两位数的类似
                        int ii;
                        int j = 9;
                        for (ii = 0;ii+1<len;ii+=2){
                            int k = (ch[ii]-'0')*10 +ch[ii+1]-'0';
                            if (k == j+2){
                                ans = j+1;
                            }
                            j = k;
                        }
                    }
                }
            }

        }
        System.out.println(ans);

    }
}
