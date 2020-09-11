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
public class TheSameBirthday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine()); //这里不能用in.nextInt()
        User[] users = new User[n];//保存用户信息
        User u;
        for (int i = 0; i < n; i++) {
            String string = in.nextLine();
            String fen[] = string.trim().split(" +");;//将输入的姓名 生日分开
            u = new User(fen[0], Integer.parseInt(fen[1]), Integer.parseInt(fen[2])); //创建一个新雇佣兵
            users[i] = u;//保存到数组中
        }
        int[][] time = new int[13][32]; //保存日期

        for (int i = 0; i < users.length; i++) {
            time[users[i].m][users[i].d]++; //统计每个雇佣兵的生日
        }
        for (int i = 1; i < 13; i++) {

            for (int j = 1; j < 32; j++) {
                if (time[i][j]>1) { //如果该天有2个人以上过生日
                    Check(i,j,users);
                }
            }

        }

    }
    //判读生日是否相同
    private static void Check(int i,Integer j, User[] users){
        System.out.print(i+" "+j+" ");
        String iString="";

        for (int k = 0;k<users.length;k++){
            if (users[k].m == i && users[k].d == j){
                iString = iString+users[k].name+" "; //符合条件 将名字赋值给isString

            }
        }
        System.out.println(iString);//输出名字
    }
}
//用户类 保存雇佣兵的信息
class User{
    String name;
    int m;
    int d;

    public User(String name,int m,int d){
        super();
        this.name = name;
        this.m  = m;
        this.d = d;
    }
}
