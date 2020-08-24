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
public class DrinksTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); //有多少钱
        int bottle = 0; //瓶子的数量
        int cap = 0; //瓶盖的数量
        if (m == 1){ //只有1块钱 只能买1瓶
            System.out.println("1瓶");
            return;
        }
        bottle = m;//有多少钱就有多少瓶
        cap = m;//有多少钱就有多少个瓶盖
        while (true){
            if (cap > 3){ //如果瓶盖数量大于3 就兑换1瓶
                cap -= 3;
                bottle++;
                cap++; //增加1瓶，瓶盖就多1个
            }else if (cap == 2){ //如果瓶盖只有2个，直接秀出张三赘婿的真实身份——修罗大人
                System.out.println("张三表明自己是修罗大人，逼迫老板拿出饮料");
                cap++;//增加1个瓶盖
                bottle++;//凑齐3个瓶盖兑换1瓶
                cap-=3;
            }else if (cap == 0){ //瓶盖为0 退出循环
                System.out.println("张三赘婿通过秀自己的真实身份总共得到："+bottle+"瓶");
                break;
            }
        }

    }
}
