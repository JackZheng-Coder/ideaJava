package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 思路:1小杯不断往大杯中倒水
 *
 * 2大杯满了的时候，大杯全部倒掉
 *
 * 3小杯继续往大杯倒水
 *
 * 4重复上面的步骤，直到得到目标水量，或者实现不了目标而退出循环
 */
public class ZhuangShueiTest {
    public static void main(String[] args) {
        int L1 = 5;//第一个杯子
        int L2 = 6;//第二个杯子
        int target = 3; //预期的容量

        //因为每次都是小杯子装满水往大杯子中倒水，倒完后小杯子剩余水量总是0
        //所以只需要跟踪大杯子剩余水量即可知道整个倒水的操作过程
        System.out.println("初始状态:"+"第二个杯子的水量为: " + 0);

        //先倒一次水，主要是为了处理倒水失败的情况
        int flag = L1 % L2; //倒水过程实际上就是取模  5 % 6 = 5，10 % 6 = 4
        System.out.println("第一次倒水:"+"第二个杯子的水量为: "+L1);

        if (flag == target){
            System.out.println("小杯往大杯倒一次水即可实现目标");
            return;
        }
        int count = 2; //不能一次成功 从第二次开始计算

        while (true){
            int remain = (count * L1) % L2; //第count次 大杯中的容量
            System.out.println("第"+count+"次倒水:"+"第二个杯子的水容量: "+remain);

            if (remain == target){
                System.out.println("在第"+count+"次倒水,"+"倒水成功，得到了目标水量");
                break;
            }else if (remain == flag){//得到循环数列，实现不了目标
                System.out.println("倒水失败，得不到目标水量");
                break;
            }
            count++;
        }


    }
}
