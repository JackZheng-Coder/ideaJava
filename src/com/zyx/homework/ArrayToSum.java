package com.zyx.homework;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class ArrayToSum {
    static int[][] a ={{1,2,3},{4,5,6},{7,8,9}};//初始数组
    int sum1 = 0;//第一行的和
    int sum2 = 0;//第二行的和
    int sum3 = 0;//第三行的和
    int sum4 = 0;//第一列的和
    int sum5 = 0;//第二列的和
    int sum6 = 0;//第三列的和
    int sum7 = 0;//主对角线的和
    int sum8 = 0;//副对角线的和
    public static void main(String[] args) {
        ArrayToSum array = new ArrayToSum();
        array.rowTosum(a);
        array.cowTosum(a);
        array.diagonalTosum(a);
    }
    /*
        行求和
     */
    public  void rowTosum(int a[][]){
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a.length;j++){
                if (i == 0){
                    sum1 += a[i][j];
                }else if (i == 1){
                    sum2 += a[i][j];
                }else if (i ==2){
                    sum3+=a[i][j];
                }
            }
        }
        System.out.println("第一行的和为："+sum1);
        System.out.println("第二行的和为："+sum2);
        System.out.println("第三行的和为："+sum3);
    }
    /*
        列求和
     */
    public void cowTosum(int a[][]){
        for (int i = 0;i<a.length;i++)
        {
            for (int j = 0;j<a.length;j++)
            {
                if (j==0){
                    sum4+=a[i][j];
                }else if (j==1){
                    sum5 += a[i][j];
                }else if (j==2){
                    sum6 += a[i][j];
                }
            }
        }
        System.out.println("第一列的和为："+sum4);
        System.out.println("第二列的和为："+sum5);
        System.out.println("第三列的和为："+sum6);
    }
    /*
        对角线求和
     */
    public void diagonalTosum(int a[][]){
        for (int i =0;i<a.length;i++) {
            sum7 += a[i][i];
        }
        for (int j = 0;j<a.length;j++){
            sum8 += a[j][a.length-j-1];
        }
        System.out.println("主对角线的和为："+sum7);
        System.out.println("副对角线的和为："+sum8);
    }
}
