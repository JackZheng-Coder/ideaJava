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
 * 矩形嵌套关系可以看作是一个二元关系，由于a>c,b>d或者b>c,a>d（没有取等号），所以一个矩形不能被自己（或与自己大小相同的矩形）所嵌套
 * 因此该二元关系的图必是无环的而且是有向的（不存在相互嵌套情况）,即该图为DAG,如果将每一个矩形都看作图中的一个点，若一个矩形可以（被）嵌套另一个矩形，
 * 则对应两点之间有单向通路，否则不连通，则该问题就转化为了求DAG上不确定起点的最长路径问题。
 */
public class DayOfWork0918 {
    static int N = 500;
    static int[][] garph = new int[N][N]; //定义图
    static int[] dis = new int[N];//用来保存可以嵌套的最大数,也就是说图中可以连通多少个图
    static  int n;//矩形的个数

    //从i出发得到的最长路线，则所求为：最大的dis(i）。因此必须将所有的dis(i)给计算出来,进行打擂台求最大值。
    public static int dfs(int i){
        if (dis[i] > 0)//如果已经计算过，则直接返回
            return dis[i];
        dis[i] = 1;//用于标记，表示已经计算出结果，减少重复计算过程，同时将所有dis[]初始化为1，用于计算。
        for (int j = 0;j < n;j++){
            if (garph[i][j] > 0) //图中有相连
                dis[i] = Math.max(dfs(j)+1,dis[i]); //动态转移方程：dis(i) = max(dis(i),dis(j)+1)
        }
        return dis[i];
    }
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[N]; //定义矩形数组
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0;i < n;i++ ){
            rectangles[i] = new Rectangle(); //每次输入长和宽时，要初始化每个矩形对象
            rectangles[i].length = in.nextInt();
            rectangles[i].width = in.nextInt();
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){ //大于还是小于没有关系，只要四个保持一致即可
                if (((rectangles[i].length < rectangles[j].length) && (rectangles[i].width < rectangles[j].width)) ||
                        ((rectangles[i].length < rectangles[i].width) && (rectangles[i].width < rectangles[j].length))){
                    garph[i][j] = 1; //符合条件，表示可以嵌套
                }
            }
        }
        int ans = -1;//最终答案
        for (int i = 0;i < n;i++){
            dis[i] = dfs(i);//找到最大可以嵌套的数量
            if (dis[i] > ans)
                ans = dis[i];
        }
        System.out.println(ans);
    }
}
//正方形类,保存 长和宽
class Rectangle{
    int width;
    int length;
}
