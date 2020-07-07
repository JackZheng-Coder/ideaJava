package com.zyx.homework;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class ShiTouJiangDaoBu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true; //控制while循环
        String guess,result = "0"; //自己出的方式 和电脑的出的方式
        boolean Comparison=false; //标志当前结果自己是否赢了
        int n = 10; //初始局数
        //游戏开始时 默认用户场次为5胜5负
        int winCountMyself = 5;
        int winConutCompute = 5;
        NumberFormat numberFormat = NumberFormat.getInstance(); // 创建一个数值格式化对象
        numberFormat.setMaximumFractionDigits(1);// 设置精确到小数点后2位


        while (flag){//使用布尔值便于后续添加功能
            int real = (int)(1+Math.random()*(3-1+1)); //随机电脑出的结果
            switch (real){ //G表示拳头 V表示剪刀 W表示布
                case 1:
                    result = "G";
                    break;
                case 2:
                    result = "V";
                    break;
                case 3:
                    result = "W";
                    break;

            }
            System.out.println("你出石头还是剪刀布:");
            guess=in.nextLine();

            switch (guess){//如果赢了就是true否则是false
                case "G":
                    if(real==2) Comparison=true;
                    if(real==3) Comparison=false;
                    break;
                case "V":
                    if(real==3) Comparison=true;
                    if(real==1) Comparison=false;
                    break;
                case "W":
                    if(real==1) Comparison=true;
                    if(real==2) Comparison=false;
                    break;
            }
            if(guess.equals("G")||guess.equals("V")||guess.equals("W")){
                if (result.equals(guess)){ //平局
                    System.out.println("恭喜你，我出的是"+result+"平局了");
                    n++;
                }else {
                    if (Comparison){ //本人赢
                        System.out.println("你赢了，我出的是"+result+"而你出的是"+guess);
                        n++;
                        winCountMyself++;
                    }
                    else{//电脑赢
                        System.out.println("你输了，我出的是"+result+"而你出的是"+guess);
                        n++;
                        winConutCompute++;
                    }
                }
                String rate = numberFormat.format((float) winCountMyself / (float) n * 100); //胜率
                System.out.println(n + "局" + winCountMyself +"胜" +"(胜率" + rate + "%)");
            }
            else
                System.out.println("输入错误");

        }
        in.close();

    }
}
