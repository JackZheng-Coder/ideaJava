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
 * 一个自然数被8除余1,所得的商被8除也余1,
 * 再将第二次的商被8除后余7,最后得到一个商为a.
 * 又知这个自然数被17除余4.所得的商被17除余15,
 * 最后得到一个商是a的2倍.
 */
/*
    根据被除数=除数×商+余数，
    思路：根据题意写出公式；设x为自然是数 所以x=8×[8×（8a+7）+1]+1;x=17×（2a×17+15）+4
          然后求出商a的值，然后用公式求出该自然数
 */
public class EightTest {
    public static void main(String[] args) {
        //逆推法
        for (int i = 0;;i++){
            if(((i*8+7)*8+1)*8+1 == ((2*i*17)+15)*17+4){
                System.out.printf("该自然数为:%d\n",((2*i*17)+15)*17+4);
                break;
            }
        }
    }
}
