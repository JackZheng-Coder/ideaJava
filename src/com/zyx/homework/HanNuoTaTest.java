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
/*\
思路:　首先，将A上n-1个盘子放到C上，然后将A上剩下的一个盘子放到B上，然后可以看成A为辅助塔，B为目标塔，
C为放盘子的（B中有一个最大的盘子，但任何盘子都能放到上面，所以可以看做为空），然后将C上n-2个盘子放到A上，
剩下的地n-1个盘子放到B上，此时便完成了一次递归，然后不断地重复上述过程即可。
 */
public class HanNuoTaTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入盘子的数量:");
        int n = in.nextInt();
        move(n,'A','B','C');
        in.close();
    }

    public static void move(int n,char a,char b,char c){
        if (n == 1){
            System.out.println(a+"-->"+c);
            return;
        }else {
            move(n-1,a,c,b); //以三为例：a:1 b:1 c:1 -> a:1 b:2 c:0->a:0 b:2 c:1 -> a:1 b:1 a:1->a:0 b:0 c:3
            System.out.println(a+"-->"+c);
            move(n-1,b,a,c);
        }
    }
}
