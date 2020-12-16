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
 * 思路:用并查集解决，未连边时的最大信仰数为n，每联结一次，最大信仰数减1。
 * 连结点的时候注意要用一个连通分量的根连到另一个的根，因为本身关联关系应该是个无向图而用并查集的时候人为规定了方向，
 * 点连点或是点连根会导致指向混乱，根连根避免方向问题，因为根没有指向（只能被指）
 */
public class DayOfWork1211 {
    static int[] student = new int[5000]; //学生i的信仰与student[i]的信仰相同
    static int ans;//保存结果值
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n个学生
        int m = in.nextInt();//m组
        if (n == 0 && m == 0)
            return;
        ans = n;//开始时未连边时的最大信仰数为n
        for (int i = 1;i<=n;i++){
            student[i] = i; //初始化每个学生都有一个专属的信仰
        }
        int a,b;//原来输入每组数据
        for (int i = 1;i<=m;i++){
            a = in.nextInt();
            b = in.nextInt();
            unite(a,b);
        }
        System.out.println(ans);
    }
     public static int find(int x){//查询祖先
        if (student[x] == x)
            return x;
        else
            return  student[x] = find(student[x]); //一个同学的信仰被联接后，要更新信仰
    }
    public static void unite(int x,int y){//联接两个信仰不同的学生
        if (find(x) == find(y)) //相同的信仰
            return;
        else {
            student[find(y)] = find(x);//把2个初始不同的信仰变为相同的信仰
            ans--;
        }
    }
}
