package com.zyx.homework;

import java.util.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class DayOfWork1103 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String str = in.nextLine(); //输入匹配字符串
       Stack<Character> stackLeft = new Stack<>(); //保存(的栈
       Stack<Integer> stackIndex = new Stack<>();//保存(的位置
       HashMap<Integer,Integer> map = new HashMap<>();//保存()的对应位置
       for (int i = 0;i<str.length();i++){
           if (str.charAt(i) == ')'){ //碰到)进行匹配，(栈不为空下将最近的(出栈
               if (!stackLeft.isEmpty()){
                   stackLeft.pop();
                   map.put(stackIndex.pop(),i+1);
               }else {
                   break;
               }
           }else {//否则将(进栈,位置进栈
               stackLeft.push(str.charAt(i));
               stackIndex.push(i+1);
           }
       }

       if (stackLeft.isEmpty() && stackIndex.isEmpty()){
           for (HashMap.Entry entry :map.entrySet() ){//遍历每个()对应的位置
               System.out.println(entry.getKey() + "," + entry.getValue());
           }
       }
    }
}
