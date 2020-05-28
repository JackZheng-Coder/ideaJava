package com.zyx.homework;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class KeyWordTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入行数:");
        int n = in.nextInt();
        int[][] arr= new int[n][];//不规则数组
        int[] arr2 = {4,3,5,4,3};//不规则数组的列值
        int[] count = new int[100];//保存每个元素出现的次数
        int max = 0;//保持出现最多的某个元素

        //赋值
        for (int i = 0;i<arr.length;i++){
            arr[i] = new int[arr2[i]];
            for (int j = 0;j<arr[i].length;j++){
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr[i].length;j++){
                HashSet<Integer> set = new HashSet<Integer>();//用hashset来判断每行中元素是否重复
                if (!set.contains(arr[i][j])){//该元素不存在，则添加到set中
                    set.add(arr[i][j]);
                    count[arr[i][j]]++; //该元素出现次数+1
                }
//                if (set.contains(arr[i][j])){
//                    count[arr[i][j]]++;
//                }
            }
        }
        //求出出现最多的元素的数量
        for (int i = 0;i<count.length;i++){
            if (max < count[i]){
                max = count[i];
            }
        }
        //max == count[i] 输出该元素
        for (int i = 0;i<count.length;i++){
            if (max == count[i]){
                System.out.println(i);
            }
        }

    }
}
