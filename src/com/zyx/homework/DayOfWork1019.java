package com.zyx.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

public class DayOfWork1019 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int k = in.nextInt();
      int n = in.nextInt();
      int[] nums = new int[k];
      for (int i = 0;i<k;i++){
          nums[i] = in.nextInt();
      }
      String str = in.next();
        System.out.println(judge(str.toCharArray(),k,n,nums));
    }
    public static int  judge(char[] ch,int k,int n,int[] grade){
        int res = 0;
        for (int i = 0;i<k;i++){
            int[] answer = substr(ch,k,i);
            int start = answer[0];
            int end = answer[1];
            if ((end - start+1)  >= n) {
                PriorityQueue<GradeNode> queue = new PriorityQueue<>(new Paixu());
                for (;start<=end;start++){
                    queue.offer(new GradeNode(start,grade[start]));
                }
                for (int temp = 1;temp<n;temp++){
                    res = res + queue.poll().grade;
                }
            }else {
               for (;start<=end;start++){
                   res = res+grade[start];
               }
            }
            i = end;
        }
        return res;
    }
    public static class GradeNode{
        int index;
        int grade;

        GradeNode(int index,int grade){
            this.index = index;
            this.grade = grade;
        }
    }
    //按照GradeNode  grade增加顺序 排序
    public static class Paixu implements Comparator<GradeNode> {
        @Override
        public int compare(GradeNode o1, GradeNode o2) {
            return o2.grade - o1.grade;
        }
    }

    public static int[] substr(char[] ch,int k,int index){
        int end = index;
        for (int i = index+1;i<k;i++){
            if (ch[end] == ch[index]){
                end++;
            }else
                break;
        }
        return new int[]{index,end};
    }
}
