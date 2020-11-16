package com.zyx.homework;

import java.util.ArrayList;
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
 * 思路:使用前缀树来找到以xxx为前缀的单词
 */
public class DayOfWork1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n个单词
        String[] str = new String[n];
        for (int i = 0;i<n;i++){
            str[i] = scanner.next(); //初始化
        }
        int m = scanner.nextInt();//查询数量m
        String[] find_str = new String[m];
        for (int i = 0;i<m;i++){
            find_str[i] = scanner.next(); //初始化要查找的前缀字符串
        }
        Trie trie = new Trie();
        for (int i = 0;i<str.length;i++){
            trie.insert(str[i]); //插入字符串
        }
        ArrayList<Integer> list = new ArrayList<>(); //保存以find_str[i]为前缀的字符串个数
        for (int i = 0;i<m;i++){
            list.add(trie.prefixNumber(find_str[i]));
        }
        for (int i = 0;i<list.size();i++){
            System.out.print(list.get(i) + "\t");
        }
    }
}
//定义前缀数结点
 class TrieNode {
    public int path;//记录有几个字符串经过了这个节点，删除用
    public int end;//以该节点结束的字符串的数量，查询用
    public TrieNode[] nexts;//子路径，这里只考虑26个字母

    public TrieNode() {
        path = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
//前缀树
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 添加字符串
    public void insert(String word) {
        if (word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0;i<chars.length;i++){
            index = chars[i] - 'a';
            if (node.nexts[index] == null){//没有可复用路径,新建节点
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;//当前节点划过次数加1
        }
        node.end++;//以该节点结束的字符串数量加1
    }

    //删除
//    public void delete(String word) {
//        	if (search(word) != 0) {
//        char[] chs = word.toCharArray();
//        TrieNode node = root;
//        int index = 0;
//        for (int i = 0; i < chs.length; i++) {
//            index = chs[i] - 'a';
//            if (--node.nexts[index].path == 0) {
//                node.nexts[index] = null;
//                return;
//            }
//            node = node.nexts[index];
//        }
//        node.end--;
//    }
//    }

    //查询
//    public int search(String word) {
//        if (word == null) {
//            return 0;
//        }
//        char[] chs = word.toCharArray();
//        TrieNode node = root;
//        int index = 0;
//        for (int i = 0; i < chs.length; i++) {
//            index = chs[i] - 'a';
//            if (node.nexts[index] == null) {
//                return 0;
//            }
//            node = node.nexts[index];
//        }
//        return node.end;
//    }

    //查询以某字符串为前缀的字符串的数量
    public int prefixNumber(String pre) {
        if (pre == null){
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0;i<chars.length;i++){
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }
}
