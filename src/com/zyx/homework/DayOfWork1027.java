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
 * 思路:将输入的值转化为数组然后从小到大排序 ，然后从排好序中删除k个大数.
 */
public class DayOfWork1027 {
    public static int MAXSIZE = 10000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int i = 0; //下标值，同时记录数组有效长度
        int a[] = new int[MAXSIZE];
        while (n != 0){ //转化为数组
            a[i++] = n % 10;
            n /= 10;

        }
        quickSort(a,0,i-1); //这里用快排进行排序
        while (k > 0){
            a[i-1] /= 10; //除去大数
            i--;
            k--;
        }
        for (int j = 0;j<i;j++){
            System.out.print(a[j]);
        }
    }
    /**
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }
}
/**
 * 给定n位正整数a，去掉其中任意k个数字后，剩下的数字按原次序排列组成⼀个新的正整数。
 * 对于给定的n和k，设计⼀个算法，找出剩下数字组成的新数最少的删数方案。
 * 解题思路
 * 可采取贪心算法求解。显然高位数位的数值大小更对数字的大小起决定性作用，因此从高位开始贪心，挑选小数字数位保留。
 *
 * 简单贪心删k法
 * 简单贪心删k法的思路是从高位往低位贪心，当当前可删k个数时，选取前k+1个高位，找到最小数（有多个最小则优先选定靠左高位数），该最小数即保留数位，该位的左方数字删去，算法流程如下：
 *
 * 若某轮有删除配额k：
 *
 * 1.选取最左k+1个数组成的子序列；
 *
 * 2.在子序列中选取最小数值；
 *
 * 3.消耗删除配额，将最小值左方数位从原序列删去（若有多最小值，选取靠左数位）（k->k’，剩余可删数位数减少）；
 *
 * 4.将选定的最小数值数位移出原序列，输出到答案序列中；
 *
 * 5.If 剩余序列长度 == k’（下一轮不足以选取k’+1个数）
 *
 * 直接将剩余序列全部删去；
 *
 *    Else if k’ == 0（无剩余删除配额）
 *
 * 剩余序列全部保留，输出到答案序列中。
 * 例： 设有10位数字a = 7519385410，删除配额k = 5 从左搜索高位前6个，子序列为751938，最小数值为1，选定1，
 * 删掉75，k=k-2=3，已有答案序列为1 从左搜索高位前4个，子序列为9385，最小数值为3，选定3，删掉9，k=k-1=2，
 * 已有答案序列为3 从左搜索高位前3个，子序列为854，最小数值为4，选定4，删掉85，k=k-2=0，已有答案序列为134 k == 0，
 * 剩余序列全部保留，得到最终解13410。
 *
 * 该法最好情况为前k+1个数位数值单调递减，一轮搜索删除k个数得出结果，时间复杂度O(k+1)；最坏情况为单调不递减序列，
 * 每轮搜索均直接保留最高位，需搜索n-k轮，每轮搜索k位，时间复杂度O(k(n-k))
 *
 *
 #include<cstdio>
 #include<cstring>

 #define MAXN 100000000

 using namespace std;

 char n[MAXN];//use char to avoid error cause by 0 at the end
 char ans[MAXN];//answer char[]
 int np, ap;//pointer of n[],ans[]

 int main()
 {
 int k;
 printf("Please input n:");
 scanf("%s",n);//save in char[] to get digit
 int nlen = strlen(n);
 if(n[0]=='-' || (nlen==1 && n[0]=='0'))
 {//invalid input n
 printf("n isn't a positive integer!\n");
 return 0;
 }
 printf("Please input k:");
 scanf("%d",&k);
 if(nlen <= k)
 {//invalid input k
 printf("No enough number !\n");
 return 0;
 }
 int Min, p;//p used as pointer
 while(k!=0 && nlen-np>k)
 {//k is the width of searching window
 p = np;
 Min = n[p];
 for(int i=np+1; i-np<=k; i++)
 {//linear traverse to get Min digit
 if(Min > n[i])
 {
 Min = n[i];
 p = i;
 }
 }
 ans[ap] = n[p];
 ap++;//ap point to the next digit
 k = k-(p-np);//k - (the number of deleted digits)
 np = p+1;//for p is kept in ans[], np should point to the next one
 }
 if(nlen-np <= k)
 np = nlen;//delete lasted digits
 while(n[np] != 0)
 {//if still digits lasted, keep them directly
 ans[ap] = n[np];
 ap++;
 np++;
 }
 ap = 0;//reset ans point
 if(ans[ap] == '0')
 {
 printf("(");
 while(ans[ap] == '0')
 {
 printf("%c",ans[ap]);
 ap++;
 }
 printf(")");
 }
 while(ans[ap])
 {
 printf("%c",ans[ap]);
 ap++;
 }
 return 0;
 }
 */
