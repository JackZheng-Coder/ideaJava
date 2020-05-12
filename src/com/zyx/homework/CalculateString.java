package com.zyx.homework;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
//脚本引擎
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("nashorn");
//        try {
//            Object result = engine.eval("6.5-4*3+3");
//            System.out.println(result);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
/*
    输入四个数字的加减乘除表达式, 输出运算结果
    样例输入 6.5-4*3+3
    样例输出 -2.5
 */
public class CalculateString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入表达式:");
        String str = in.nextLine();
        double result1 = compute(str);
        System.out.println((int) result1);
    }
    public static int priority(char s){
        switch (s){
            case '(':
            case ')':
                return 0;
            case '-':
            case '+':
                return 1;
            case '*':
            case '%':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    public static double compute(double num1,double num2,char s){
        switch (s){
            case '(':
            case ')':
                return 0;
            case '-':
                return num1 - num2;
            case '+':
                return num1 + num2;
            case '%':
                return num1 % num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }
    public static double compute(String  str){
        double[] num = new double[20];
        int flag = 0,begin = 0,end = 0,now;
        now = -1;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char s = str.charAt(i);
            if (s == ' '){

            }else if (s == '+' || s == '-' || s == '*' || s == '/' || s == '(' || s == ')' || s == '%'){
                if ( flag == 1){
                    now  += 1;
                    if (end < begin){
                        num[now] = Integer.valueOf(str.substring(begin,begin+1));
                    }else {
                        num[now] = Integer.valueOf(str.substring(begin,end+1));
                    }
                    flag = 0;
                }
                if (s == '-'){
                    if (i == 0) {
                        flag = 1;
                        begin = 0;
                    } else if (str.charAt(i - 1) == '(' || str.charAt(i - 1) == '*'
                            || str.charAt(i - 1) == '/') {
                        flag = 1;
                        begin = i;
                    }
                    else {
                        if (st.empty()) {
                            st.push(s);
                        } else if (s == ')') {
                            num[now - 1] = compute(num[now - 1], num[now], st.pop());
                            now -= 1;
                            st.pop();
                        } else if (s == '(') {
                            st.push(s);
                        } else if (priority(s) <= priority(st.peek())) {
                            num[now - 1] = compute(num[now - 1], num[now], st.pop());
                            now -= 1;
                            st.push(s);
                        } else {
                            st.push(s);
                        }
                    }
                }else if (st.empty()) {
                    st.push(s);
                } else if (s == ')') {
                    num[now - 1] = compute(num[now - 1], num[now], st.pop());
                    now -= 1;
                    st.pop();
                } else if (s == '(') {
                    st.push(s);
                } else if (priority(s) <= priority(st.peek())) {
                    num[now - 1] = compute(num[now - 1], num[now], st.pop());
                    now -= 1;
                    st.push(s);
                } else {
                    st.push(s);
                }
            }else if (flag == 0) {
                flag = 1;
                begin = i;
            } else {
                end = i;
            }
        }
        if (flag == 1){
            now += 1;
            if (end < begin){
                num[now] = Integer.valueOf(str.substring(begin, begin + 1));
            }else {
                num[now] = Integer.valueOf(str.substring(begin, end + 1));
            }
        }
        while (now > 0) {
            num[now - 1] = compute(num[now - 1], num[now], st.pop());
            now -= 1;
        }
        return num[0];
    }
}
