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
//思路：暴力搜索
public class LawnNumberTest {
    public static void main(String[] args) {
        int count = 0;  //保存草地数量
        Scanner in = new Scanner(System.in);
        System.out.print("请输入数组的层数:");
        int n = in.nextInt();
        String[][] str  = new String[n][n];
        for (int i = 0;i < n;i++){ //动态赋值
            for (int j = 0;j<n;j++){
              str[i][j] = in.next();
            }
        }
        //暴力搜索，满足条件count++
        for (int i = 0;i<str.length;i++){
            for (int j = 0;j<str[i].length;j++ ){
                if(i > 0 && j >0){ //行，列不在边上的情况下
                    if (str[i][j].equals("#") && (!str[i-1][j].equals("#")) && (!str[i][j-1].equals("#"))){
                        count++;
                    }
                }else if (i == 0 && j>0){ //行在边上情况
                    if (str[i][j].equals("#") && (!str[i][j-1].equals("#"))){
                        count++;
                    }
                }else{ //列在边上情况
                    if (str[i][j].equals("#") && (!str[i-1][j].equals("#"))){
                        count++;
                    }
                }
            }
        }
        System.out.println("草地的数量为:"+count);
        in.close();//关闭流
    }
}
