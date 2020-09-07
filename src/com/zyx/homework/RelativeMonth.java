package com.zyx.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class RelativeMonth {
    public static void main(String[] args) {
        //创建一个长度为12的数组存储12个月的第一天的星期数
        String monthWeek[] = new String[12];

        //循环获取2021年每月1号是周几
        for (int i = 0; i < 12; i++) {
            int month = i + 1;
            String date = "2021-" + month + "-1";
            //调用依据日期获取星期的方法
            monthWeek[i] = dateToWeek(date);
        }
        //先用创建7个list存储每个月份的第一天是星期几
        //创建weekLis数组
        List<Integer> weekLis[] = new ArrayList[7];
        //初始化weekLis数组

        for (int n = 0; n < weekLis.length; n++) {
            //最多12个月都是统一天的相关月
            weekLis[n] = new ArrayList<Integer>(12);
        }
        //循环判断哪些月是相关月
        for (int j = 0; j < 12; j++) {
            //  0对应1月,11对应12月,类推
            int m = j + 1;
            //用两个for循环if判断不好处理重复数据,因此用switch判断,用list存储相关月数据.
            switch (monthWeek[j]) {
                case "星期日":
                    weekLis[0].add(m);
                    break;
                case "星期六":
                    weekLis[6].add(m);
                    break;
                case "星期五":
                    weekLis[5].add(m);
                    break;
                case "星期四":
                    weekLis[4].add(m);
                    break;
                case "星期三":
                    weekLis[3].add(m);
                    break;
                case "星期二":
                    weekLis[2].add(m);
                    break;
                case "星期一":
                    weekLis[1].add(m);
                    break;
                default:
                    System.err.println("获得的星期不对!" + monthWeek[j]);
                    break;
            }
        }
        for (int m = 0; m < weekLis.length; m++) {
            if (weekLis[m].size() <= 1) {
                //没有相同月份的不是相关月
                continue;
            }
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            System.out.println("2021年以下月份" + weekLis[m].toString() + "是相关月,它们的1号都是" + weekDays[m]);
        }
    }
    /**

     * 根据日期获取 星期 （2019-05-06 ——> 星期一）

     * @param datetime 传入形如2021-01-01的日期数据*
     * @return

     */
    public static String dateToWeek(String datetime){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = f.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //一周的第几天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
