package com.sx.DBC;
import com.sx.User.User;
import com.sx.jdbc.DBManager;

import java.sql.*;
public class SearchUser {
     private String id;
     private String P1;
     int result = 10;
     public SearchUser(User user){
        this.id=user.getUid();
        this.P1=user.getUpass();
    }

    public int S() {
        String Username;
        String Userpass;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBManager.getConn();
            //4、定义sql语句
            String sql = "SELECT * FROM user WHERE id='"+id+"'";
            //5、获取执行sql的对象、Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(sql);
                //6、处理结果
            while (rs.next()) {
                Username = rs.getString("id");
                Userpass = rs.getString("upass");
                int type = rs.getInt("type");
                if (P1.equals(Userpass)){
                    result = type;
                    break;
                }
                else {
                    result = 11;
                    break;
                }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7、关闭资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }
}
