package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */



import java.util.Scanner;

/**
 * 多余的空格
 * 输入一行字符串(len < 1000), 对于其连续的空格进行过滤, 只留下一个空格
 * 样例输入:
 * Lao    Jiu  Xue Tang       666
 * 样例输出
 * Lao Jiu Xue Tang 666
 */
public class String_Blank_Test {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = in.nextLine();
        StringBuffer sb = new StringBuffer(); //用来保存去除多余空格的字符串
        int flag; //标示位 喷到空格则为设为1
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i)); //当前字符不是空格，则加到sb中
            }else {
                flag = 1;
            }

            try {
                if (str.charAt(i) == ' ' && str.charAt(i+1) != ' '){ //过滤 只保存1个空格
                    sb.append(' ');
                }
            }catch (Exception e){
                continue;
            }
        }
        System.out.println(sb);
        in.close();
    }


}
