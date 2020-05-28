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

/**
 * 进制乘法, 输入三个整数a b c, 判断在什么进制下, a*b=c成立
 * 样例输入:
 * 6 9 42
 * 样例输出:
 * 13
 */
public class MulipicationTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入a,b,c
        System.out.print("请输入a,b,c:");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        boolean flag = true; //标识
        for (int i = 2;i<=16;i++){ //在2进制到16进制之间
            if ((judge(a,i)) * (judge(b,i)) ==(judge(c,i)) ){
                System.out.println(i); //输出该进制
                flag=false;
                break;//找到最小的i后 退出循环；因为符合条件的进制可能有多个 输出最小的进制
            }
        }
    }
    //将x转为b进制
    public static  int judge(int x,int B){
        int value =1,num=0;
        while (x!=0){ //将x转为B进制数
            if (x % 10 >= B){//B进制下不可能出现大于等于B的数位
                return -1;
            }
            num += ((x%10)*value);//value是每位的权值
            value *= B;//通过每次乘以B，移动B进制的数位
            x /= 10;    //通过除10找出每一位
        }
        return num; //返回该数转为b进制后的数
    }
}


/**
 * import java.util.Scanner;
 *
 * public class Main{
 * 	public  static void main(String[]args) {
 * 		Scanner in =new Scanner(System.in);
 * 		String a1=in.next();
 * 		String b1=in.next();
 * 		String c1=in.next();
 * 		boolean flag=true;
 * 		int a2,b2,c2;
 * 		  a2=b2=c2=0;
 * 		for(int i=2;;i++)
 *                {
 * 			if(i>16) {
 * 				break;
 *            }
 * 			try {
 *
 * 			    a2=Integer.valueOf(a1,i);  //将a转为i进制的数
 * 			    b2=Integer.valueOf(b1,i);
 * 			    c2=Integer.valueOf(c1,i);
 *            }catch(NumberFormatException e){
 * 				continue;
 *            }
 * 			if(a2*b2==c2) {
 * 				System.out.println(i);
 * 				flag=false;
 *            }
 *        }
 * 		if(flag) {
 * 			System.out.println(0);
 *        }
 ** 	}
 * }
 *
 *
 *
 * */
