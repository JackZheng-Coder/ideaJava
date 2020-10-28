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
public class DayOfWork1022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n块宝石
        int[][] arr = new int[n][2]; //用二维数组保存每块宝石的速度和力量
        for (int i = 0;i<n;i++){ //初始化
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        int ans = dfs(arr,n,0,1,0);
        System.out.println(ans);

    }
    //求总速度值和总力量值的最小差值算法
    public static int dfs(int[][] arr,int n,int cur,int speed,int strength){
        if(cur == n){
            return Math.abs(speed - strength);
        }
        for (int i = cur;i<n;i++){
            //表示要带上新的力量值和速度值
            int choose = dfs(arr,n,cur+1,speed*arr[i][0],strength+arr[i][1]);
            //表示不带上新的力量值和速度值
            int notchoose = dfs(arr,n,cur+1,speed,strength);
            return Math.min(choose,notchoose); //比较二者大小
        }
        return 0;

    }


}

/*
求宝石的所有组合，从中找出最小差的组合

public class Sample {
    static class Stone {
        int speed;
        int power;
        public Stone(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
        public String toString() {
            return String.format("{speed: %s, power: %s}", speed, power);
        }
    }
    public static void main(String[] args) {
        try {
            int n, s, p, ss, sp, sub, min=Integer.MAX_VALUE;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            List<Stone> list = new ArrayList<>();
            for (int i=0; i<n; i++) {
                s = sc.nextInt();
                p = sc.nextInt();
                list.add(new Stone(s, p));
            }
            List<Stone> minList = null;
            for (int i=0; i<n; i++) { //求出各种组合
                for (List<Stone> lst : combile(list, i+1)) { //遍历每种组合
                    ss = 1;
                    sp = 0;
                    for (Stone st : lst) { //计算总速度和总能力
                        ss *= st.speed;
                        sp += st.power;
                        sub = Math.abs(ss-sp);
                        if (sub < min) {
                            min = sub;
                            minList = lst;
                        }
                    }
                }
            }
            System.out.println(min);
            //System.out.println(minList); //查看组合情况
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static <T> List<List<T>> combile(List<T> list, int n) { //组合
        List<List<T>> result = new ArrayList<>();
        int[] idx = new int[n];
        Arrays.fill(idx, 0);
        while (idx[0]<n) {
            boolean ok = true;
            for (int i=0; ok&&i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    if (idx[i]==idx[j]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                List<T> tmp = new ArrayList<>();
                for (int i=0; i<n; i++) {
                    tmp.add(list.get(idx[i]));
                }
                result.add(tmp);
            }
            idx[n-1]++;
            for (int i=n-1; i>0; i--) {
                if (idx[i]==list.size()) {
                    idx[i] = 0;
                    idx[i-1]++;
                }
            }
        }
        return result;
    }
}
 */
