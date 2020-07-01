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

/**
 * 暴力搜索法
 */
public class Max_of_SunString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] ch = str.toCharArray();
        List<Character> list = new ArrayList<>(); //将保存无重复的子子串

        if (ch.length == 0){ //无字符返回0
            System.out.println("0");
        }else {
            int num = 1; //保存最大无重复字串的数量
            for (int i = 0;i<ch.length;i++){ //进行ch.length-1次的比较
                for (int j = i;j< ch.length;j++){ //判断本轮的比较
                    if (!list.contains(ch[j]) ) //如果不包含当前字符 则加入到集合中
                        list.add(ch[j]);
                    else{
                         if(list.size() >= num){   //如果包含当前字符，比较集合与num的大小
                            num = list.size();
                        }
                         //比较1次后 直接跳到下一次
                        list.clear();
                        break;
                    }

                }
            }
            System.out.println(num); //输出最大子串
        }
        in.close();
    }
}
/**
 * 方法2：滑动窗口
 * 什么是滑动窗口？
 *
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，
 * 这时候不满足要求。所以，我们要移动这个队列！
 *如何移动？
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求
 *
 * 滑块思想，最大窗口。快慢指针i,j结合hash。
 * （1）快指针j所在元素不重复，更新max，将快指针j元素在hash表中的标记为出现，后移j
 * （2）快指针j所在元素重复，慢指针后移，此时将慢指针i元素在hash表中的标记清除。此时并不关心是谁重复，重复元素前的元素都要清除掉。
 * 不断重复上面2步，知道i或j到达字符串末尾。时间复杂度o(n)
 class Solution {
 public int lengthOfLongestSubstring(String s) {
 if ("".equals(s)) {
 return 0;
 }
 HashSet<Character> set = new HashSet<Character>();
 int ans = -1, i = 0, j = 0;
 int length = s.length();
 while (i < length && j < length) {
 if (!set.contains(s.charAt(j))) {
 set.add(s.charAt(j++));
 ans = Math.max(ans, j - i);
 } else {
 set.remove(s.charAt(i++));
 }
 }
 return ans;
 }
 }



 */
