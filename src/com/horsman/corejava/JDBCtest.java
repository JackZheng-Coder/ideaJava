package com.horsman.corejava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class JDBCtest {
    public static void main(String[] args) throws Exception {
        //从文件中读取输入流
        FileInputStream fis = new FileInputStream("src\\com\\horsman\\corejava\\database.properties");
        //创建Properties对象
        Properties pro = new Properties();
        //从流中加载数据
        pro.load(fis);
        //关闭流
        fis.close();
        //从Properties对象中根据键读取值
        String driverClass = pro.getProperty("driverClass");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        //打印值
//        System.out.println(driverClass);
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(password);

// 注册驱动
        Class.forName(driverClass);
// 建立连接
        Connection con = DriverManager.getConnection(url, username, password);
// 获取SQL语句执行对象
        Statement stat = con.createStatement();
// 调用执行者对象方法,执行SQL语句获取结果集
        String sql = "SELECT * FROM sort";
        ResultSet rs = stat.executeQuery(sql);
// ResultSet接口方法 boolean next() 返回true,有结果集,返回false没有结果集
        while(rs.next()){
// 获取每列数据,使用是ResultSet接口的方法 getXX方法参数中,建议写String列名
            System.out.println(rs.getInt("id")+"   "+rs.getString("username"));
        }
// 关闭对象，先开后闭
        rs.close();
        stat.close();
        con.close();

    }
}
