package com.zyx;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Count1 {
    public static void main(String[] args) {
        // 有1、2、3、4、5个数字，能组成多少个互不相同且无重复数字的三位数？
        int[] arr = {1,2,3,4,5};
        int count = 0; // 初始个数为0
        /*
         使用暴力搜索
         */
        for (int i: arr) {
            for (int j : arr){
                for (int k :arr){
                    if (i!=j && i!=k && j!=k){//判断三位不相同
                        System.out.print(i * 100 + j * 10 + k+"\t");
                        count++;
                    }
//                    if (count %10 == 0){
//                        System.out.println();
//                    }
                }
            }
        }
        System.out.println();
        System.out.println("互不相同且无重复数字有："+count);
    }

}
