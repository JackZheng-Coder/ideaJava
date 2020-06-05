package com.zyx.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
//(互质数: 两个或多个数字的公因数只有1)
//把要比较的数放到一个数组中，可以同时实现比较多个数。原理：两两进行比较元素的公因数是否相等，如果不相等，则互质，否则不互质 (枚举法)
public class HuZhiTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入要判断多少个数字:");
        int n = in.nextInt();
        int arr[] = new int[n]; //保存要判断的数字
        System.out.println("请输入值:");
        for (int i = 0;i<n;i++){
            arr[i] = in.nextInt(); //赋值
        }
        int count = 0; //统计数组有多少组为互质数
        System.out.println(checkRelativelyPrime(arr,count)); //输出结果
        in.close();//关闭流
    }

    //判断思路,比较数组中两个数的公约数是否有相同的，没有则互质，简单实现
    public static boolean checkRelativelyPrime(int arr[],int count) {
        boolean flag = true; //标识位
        //1.先判断数组中是否有相同元素
        if (checkSame(arr)){
            //2两两比较数组中的元素的公因数
            for (int i = 0;i< arr.length-1;i++){
                List<Integer> list1 = calcfactors(arr[i]);
                for (int j = i+1; j< arr.length;j++){
                    List<Integer> list2 = calcfactors(arr[j]);
                    if (isRepeat(list1,list2)){ //判断两个公因数是否有相同，没有则为互质
                        flag = true;
                        count++; //每组有一个就count++
                    }else {
                        continue; //一组没找到，换另一组
                    }
                }
            }
        }
        System.out.println(count); //输出count
        return true;
    }
        //判断数组中是否有相同的数
    public static boolean checkSame(int arr[]){
        for (int i = 0;i<arr.length-1;i++){
            if (i+1 < arr.length && arr[i] == arr[i+1]){
                return false;
            }
        }
        return true;
    }
    //计算一个数的公因数
    public static List<Integer> calcfactors(int number){
        List<Integer> list = new ArrayList<>();
        //不包括1 从2开始
        for (int i = 2;i<= number;i++){
            if (number % i == 0){
                list.add(i); //把公因数添加到集合中
            }
        }
        return list;
    }
    //判断是否有重复
    public static boolean isRepeat(List<Integer> list1,List<Integer> list2){
        for (int i = 0;i<list1.size();i++){
            for (int j = 0;j < list2.size();j++){
                if (list1.get(i) == list2.get(j))//如果相等，表示重复，返回false
                    return false;
            }
        }
        return true;
    }
}
