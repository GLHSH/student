package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class SelectManager_Teacher {

    public Object[][] SelectManger_Student() {
        Connection connection = null;
        Statement statement = null;
        Object[][] obj1 =null;
        try {
            connection = DBManager.getConn();
            //4、定义sql语句
            String sql = "SELECT * FROM 课程表 WHERE 教师id is null ";
            //5、获取执行sql的对象、Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            int i1= 0;
            while (rs.next()){
                i1++;
            }System.out.println("行数:"+i1);
            obj1 = new Object[i1][];
            rs = statement.executeQuery(sql);
            int i2=0;
            while (rs.next()) {
                obj1[i2] = new Object[]{
                        rs.getString("课程号"),
                        rs.getString("课程名"),
                        rs.getDouble("学分"),
                        null
                };
                System.out.println(Arrays.toString(obj1[i2]));
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
        return obj1;
    }
}
