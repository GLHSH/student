package com.sx.jdbc;

import java.sql.*;

public class DBManager {

    public static Connection getConn() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3、获取数据库连接对象
            String userName = "root";
            String password = "1234";
            //报错一：The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to util
            // 解决方法与原因：当mysql和connector版本八以上 时，系统时区错误，需要在配置连接数据库的url加上：?serverTimezone=GMT%2B8
            // 报错二： javax.net.ssl.SSLException: closing inbound before receiving peer's close_notify
            //解决方法：需要在配置连接数据库的url加上： &useSSL=false
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?serverTimezone=GMT%2B8&useSSL=false", userName, password);
        } catch (ClassNotFoundException e) {
            System.out.println(1);
        } catch (SQLException throwables) {
            System.out.println(2);
        }
        return connection;
    }
}
