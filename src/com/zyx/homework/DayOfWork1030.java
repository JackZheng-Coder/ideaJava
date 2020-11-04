package com.zyx.homework;

import javax.swing.table.TableRowSorter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class DayOfWork1030 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //等腰直角三角形个数
        int[][] trangle_nums = new int[n][2]; //保证三角形的(x,y)
        for (int i = 0;i<n;i++){
            trangle_nums[i][0] = in.nextInt();//x轴
            trangle_nums[i][1] = in.nextInt();//y轴
        }
        //自定义排序:将等腰直角三角形按左端点升序排序，若左端点相同，y坐标大的在前面
        Arrays.sort(trangle_nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                if (p[0] == q[0]){
                    return q[1] - p[1];
                }
                return p[0] - q[0];
            }
        });
        double ans = 0;//保存结果值
        for (int i = 0;i<n;i++){
            if (i == 0){ //第一个三角形计算完整的面积
                ans += trangle_nums[i][1] * trangle_nums[i][1];
            }
            else {
                //前面的三角形完全覆盖了当前的三角形
                if (trangle_nums[i][0] + trangle_nums[i][1] <= trangle_nums[i-1][0]+trangle_nums[i-1][1])
                    trangle_nums[i] = trangle_nums[i-1];
                    //前面的三角形与当前的三角形没有一点重合
                else if (trangle_nums[i][0] -trangle_nums[i][1] >= trangle_nums[i-1][0] + trangle_nums[i-1][1])
                    ans +=  trangle_nums[i][1] * trangle_nums[i][1];
                else
                    //前面的三角形与当前三角形有部分重合 因为已经知道等腰三角形的中点坐标，斜边又与x轴重合
                    //可以从中点坐标求出三角形的左端点和右端点
                    //重合部分的面积也是一个等腰直角三角形 且重合的三角形左端点是当前三角形的左端点，重合的三角形右端点是前一个三角形的右端点
                    ans += trangle_nums[i][1] * trangle_nums[i][1]-(trangle_nums[i-1][0] + trangle_nums[i-1][1] + trangle_nums[i][1] -trangle_nums[i][0])
                            *(trangle_nums[i-1][0]+trangle_nums[i-1][1] +trangle_nums[i][1] - trangle_nums[i][0])/4;
            }
        }
        System.out.println(ans);
    }


}
