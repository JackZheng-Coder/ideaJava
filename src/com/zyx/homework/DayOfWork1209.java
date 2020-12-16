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
 * 思路:由于题目已经给出总价格的上限，因此算法通过使用回溯来选择合适的机器使得在总价格不超过c时得到的机器重量最小。首
 * 先初始化当前价格cp=0,当前重量cw=0,此外，还要设置一个变量bestw表示选择机器的总重量，
 * 初始化其为每个部件从1号供应商购买的重量。在循环选择i号机器时，判断从j号供应商购买机器后的价格是否大于总价格，
 * 如果不大于则选择，否则不选，继续选择下一供应商进行判断。在得到一个合适的供应商后，继续选择下一机器的供应商，
 * 从第一个选到最后一个供应商。当所有机器选择结束后，判断得到的总重量是否比之前的bestw小，如果小就赋给bestw，
 * 然后从这一步开始，回溯到上一机器，选择下一合适供应商，继续搜索可行解，直到将整个排列树搜索完毕。
 * 这样，最终得到的bestw即为最优解。
 *
 * 当然，考虑到算法的时间复杂度，还可以加上一个剪枝条件，即在每次选择某一机器时，
 * 再判断选择后的当前重量是否已经大于之前的bestw，如果大于就没必要继续搜索了，因为得到的肯定不是最优解。
 *
 * 3、算法设计：
 * a.部件有n个，供应商有m个，分别用array2[i][j]和array1[i][j]存储从供应商j 处购得的部件i的重量和相应价格，d为总价格的上限。
 * b.用递归函数machine(i)来实现回溯法搜索排列树（形式参数i表示递归深度）。
 *   ① 若cp>d，则为不可行解，剪去相应子树，返回到i-1层继续执行。
 *   ② 若cw>=bestw，则不是最优解，剪去相应子树，返回到i-1层继续执行。
 *   ③ 若i>n，则算法搜索到一个叶结点，用bestw对最优解进行记录，返回到i-1层继续执行；
 *   ④ 用for循环对部件i从m个不同的供应商购得的情况进行选择(1≤j≤m）。
 * c.主函数调用一次machine(1)即可完成整个回溯搜索过程，最终得到的bestw即为所求最小总重量。
 *
 * 4.算法时间复杂度：
 *     程序中最大的循环出现在递归函数mchine(i)中，而此函数遍历排列树的时间复杂度为O(n!),故该算法的时间复杂度为O(n!)。
 */
public class DayOfWork1209 {
    static int n,m,c;//n个部件，m个商家，c总金额
    static int[][] price = new int[100][100];//保持每个部件的价格
    static int[][] weight = new int[100][100];//保持每个部件的重量
    static int cw = 0;
    static int cp = 0;
    static int bestW = 1000000;//最小的重量
    static int[] x = new int[100];//记录所选部门的副本
    static int[] x1 = new int[100];//记录所选部门
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        c = in.nextInt();
        for (int i = 0;i<n;i++){
            for (int j =0;j<m;j++){
                price[i][j] = in.nextInt();
            }
        }for (int i = 0;i<n;i++){
            for (int j =0;j<m;j++){
                weight[i][j] = in.nextInt();
            }
        }
        machine(0);
        System.out.println(bestW);
        for (int i = 0;i<n;i++){
            System.out.print(x1[i]+1 + "\t");
        }
    }
    //用递归函数machine(i)来实现回溯法搜索排列树
    static void machine(int t){
        if (t >= n){
            if (cw < bestW){
                bestW =  cw;
                for (int i = 0;i<n;i++){
                    x1[i] = x[i];
                }
            }
            return;
        }
        for (int i = 0;i<m;i++){
            cp += price[t][i];
            cw += weight[t][i];
            x[t] = i;
            if (cp <= c && cw <= bestW){
                machine(t+1);
            }
            cp -= price[t][i];
            cw -= weight[t][i];
        }

    }
}
