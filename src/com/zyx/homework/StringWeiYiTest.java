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
public class StringWeiYiTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入第一个字符串:");
        String str1 = in.nextLine();
        System.out.print("输入第二个字符串:");
        String str2 = in.nextLine();
        isContainer(str1,str2);
    }
    //判断s1移位后是否能包含s2
    public static boolean isContainer(String str1,String str2) {
        int count = 0; //位移次数
        char temp; //临时保存字符
        char[] ch1; //保存将待旋转的源字符串转为字符数组
        //如果s1本身包含s2 则直接输出0
        if (str1.contains(str2)) {
            System.out.println("位移量为：" + count);
            return true;
        } else{
           // 将待旋转的源字符串转为字符数组
            ch1 = str1.toCharArray();
            for (int i = 0 ;i< ch1.length;i++){
                //字符串的循环移位
                temp = ch1[0];
                for (int j = 0;j<ch1.length-1;j++){
                    ch1[j] = ch1[j+1];
                }
                ch1[ch1.length-1] = temp;
                count++;//位移加1
                //字符数组  转  字符串
                /**
                 *  其中需要注意的是，字符数组char[] des转字符串String的方法并不是将字符数组char[] des  直接des.toString() ，
                 *  那样只会得到地址。正确的方式应该是:String.valueOf(des)。
                 */
                str1 = String.valueOf(ch1);
                if (str1.contains(str2)){
                    System.out.println("位移的次数为:"+count);
                    return true;
                }
            }
        }
        System.out.println("false");
        return false;
    }

}


/**
 *  第二种方法：将源字符串srcStr进行左移或者右移srcStr.length()，其中保留待移动的字符在原来的位置上，然后直接判断是否包含目
 *  的字符串desStr。即上面的例子中srcStr="AABBCD"，左移或者右移实际上用不着，
 *  直接两个srcStr即为左移或者右移srcStr.length()后的字符串即 srcStrSec="AABBCDAABBCD"，
 *  这样子实际上就可以判断是否包含目的字符串了，
 *  因为srcStrSec包含了第一种方法中每一次不保留原先字符的左移或者右移后得到的字符串，只要想一想，在草稿纸上描绘秒回
 *
 */
/**
 *
 * @author zhonglinsen
 * 字符串旋转 后 是否包含指定的字符串   AABBCD旋转后则会包含 CDAA
 */
//public class StringRotateIncludeOne {
//
//    /**
//     * 第二种方法：空间换时间
//     * @param src
//     * @param des
//     * @return
//     */
//    public boolean StringRotateIncludeTwo(char[] src,char[] des){
//        boolean flag=false;
//        String srcReal=String.valueOf(src);
//        srcReal += srcReal;
//
//        String desReal=String.valueOf(des);
//        if (srcReal.contains(desReal)) {
//            flag=true;
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) {
//        //字符串 转 字符数组
//        char[] srcStr="AABBCD".toCharArray();
//        char[] desStr="CDAAS".toCharArray();
//
//        boolean res=sri.StringRotateIncludeTwo(srcStr,desStr);
//        System.out.println(res);
//    }
//}
