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
public class ChooseTheBall {
    public static int[] value = new int[1000];
    public static int[] getN = new int[3];
    public static int[] init = new int[5];
    public static char[] result = {'-','0','0','+'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0;i<3;i++){
            getN[i] = in.nextInt();
        }
        for (int i = 0;i<5;i++){
            init[i] = in.nextInt();
        }
        int minN = Math.min(getN[0],Math.min(getN[1],getN[2]));
        if (minN % 2 == 1){//此处关于平局，两者是均为奇数，还是均为偶数问题
            value[0] = 1; //代表平局,；两者默认均为奇数个
        }else {
            value[0] = 2;//代表平局,；两者默认均为偶数个
        }
        for (int i = 1;i<minN;i++){
            value[i] = 2;//0代表负，1和2代表平局，3代表胜
        }
        for (int i = minN;i<6;i++){
            int temp = 0;

            for (int j = 0;j<3;j++){
                if (i - getN[j] < 0){
                    continue;
                }
                if (i - getN[j] == 0 && getN[j] % 2 == 1){
                    temp = 3;
                }
                if (value[i - getN[j]] == 0){//表示i - getN[j]个球先取时，必输
                    if (getN[j] % 2 == 0){
                        temp = 3;
                        //此时最终结果为两人取的球均为偶数个,但是若temp取三个数中另外一个数时
                        //，是必赢结果，则舍弃这个平局结果
                    }else {
                        temp = 2 > temp ? 2 : temp;
                    }
                }
                if (value[i - getN[j]] == 1){//表示i - getN[j]个球先取时，两人取球均为奇数个
                    if(getN[j] % 2 == 0)
                        temp = 1 > temp ? 1 : temp;  //此处做比较同上
                }
                if (value[i - getN[j]] == 2){//表示i - getN[j]个球先取时,两人取球均为偶数个
                    if(getN[j] % 2 == 1)
                        temp = 3;     //此种情况出现，必赢，不必做比较判断
                    else
                        temp = 2 > temp ? 2 : temp;   //此处比较同上，排除必输情况
                }
                if (value[i - getN[j]] == 3){//表示i - getN[j]个球先取时,必赢
                    if(getN[j] % 2 == 1)
                        temp = 1 > temp ? 1 : temp;
                }
            }
            value[i] = temp;  //当前i个球，先取者最终输赢结果
        }
        for(int i = 0;i < 5;i++)
            System.out.print(result[value[init[i]]]+" ");
    }
}
