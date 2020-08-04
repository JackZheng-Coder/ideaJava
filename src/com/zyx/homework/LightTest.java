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
public class LightTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //灯的数量
        int M = in.nextInt(); //学生数量
        boolean[] open_light = new boolean[N+1];//灯的开和关用boolean数组保存
        for (int i = 1;i<open_light.length;i++){
            open_light[i] = false; //一开始所所有的灯都打开,但是张三又关掉了 所以直接初始化false就行
        }
        int[] stu_Number = new int[M-1+2]; //扣除张三 实际只有M-1个同学 再加2是因为下标从2开始
        for (int i = 2;i<stu_Number.length;i++){
            stu_Number[i] = i;
        }
        //进行判断
        for (int i = 2;i<stu_Number.length;i++){
            for (int j = 1;j<open_light.length;j++){
                    if (stu_Number[i] == 2){ //当学生编号为2时
                        if (j % stu_Number[i] == 0){ //如果当前灯的编号是2的倍数则打开灯
                            open_light[j] = true;
                        }
                    }else { //学生编号不是2 ，如果是学生的编号的倍数 则做相反处理
                        if (j % stu_Number[i] == 0){
                           if (open_light[j] == false){ //灯是关闭的 则打开
                               open_light[j] = true;
                           }else {
                               open_light[j] = false; //同上
                           }
                        }
                    }
            }
        }
        //输出灯关闭的编号
        System.out.println("当前灯为关闭状态的编号为:");
        for (int i = 1;i<open_light.length;i++){
          if (open_light[i] == false){
              System.out.print(i+"\t");
          }
        }
    }
}
