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

/**
 * 一个由1~10 10个数字组成的圆环, 从1开始 每隔一个元素删除一个元素, 打印出最后保留的元素
 * 删除顺序: 3, 5, 7, 9, 1, 4...
 */
public class CircularNumberTest {
    public static void main(String[] args) {
        //定义一个容器，保存数字
        List<Integer> list = new ArrayList<>();
        //初始化
        for (int i = 1;i<=10;i++){
           list.add(i);
        }
        //计数
        int count = 1;
        //容器中只要还多余1个数，就一直循环
        while (list.size() != 1){
            //for循环找出剩下的报数m的下标
            for (int i = 0;i<list.size();i++){
                if (count == 3){ //如果每次计数到3 则删除1个
                    Integer remove = list.remove(i);
                    i--;
                    System.out.print(remove+" ");
                    count = 1; //因为每隔1个删除一个，所以count应该重新设为0；如果按约瑟夫环要求则应该设为0
                }
                count++;
            }
        }
        System.out.println();
        //打印出最后一个
        for (int i = 0;i<list.size();i++){
            System.out.println("最后的赢家是:" +list.get(i));
        }
    }


}
