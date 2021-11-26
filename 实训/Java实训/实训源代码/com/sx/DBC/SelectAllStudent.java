package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.*;

public class SelectAllStudent {

    public SelectAllStudent() {
    }
    public Object[][] s(){
        int i1 = 0,i2 = 0;
        Connection connection = null;
        Statement statement = null;
        Object[][] obj =null;
        try {
            connection = DBManager.getConn();
            //4、定义sql语句
            String sql = "SELECT * FROM 学生表 " ;
            //5、获取执行sql的对象、Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                i1++;
            }
            obj = new Object[i1][];
            rs = statement.executeQuery(sql);
            System.out.println(i1);
            while (rs.next()) {
                obj[i2] = new Object[]{
                        rs.getString("学生id"),
                        rs.getString("学生姓名"),
                        rs.getString("部门")
                };
                i2++;
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
        return obj;
    }
}
