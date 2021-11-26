package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class SelectManager_Teacher_all {
    Object[][] date3;
    public Object[][] S() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBManager.getConn();
            int  i1=0 , i2=0;
            //4、定义sql语句
            String sql = "SELECT DISTINCT 学期,选课表.课程号,课程名,学分,教师表.教师id FROM 选课表,课程表,教师表  WHERE 选课表.课程号=课程表.课程号 and 课程表.教师id=教师表.教师id  order by 课程表.课程号,学期 desc";
            //5、获取执行sql的对象、Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                i1++;
            }System.out.println("行数:"+i1);
            date3 = new Object[i1][];
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                date3[i2] = new Object[]{
                        rs.getString("学期"),
                        rs.getString("课程号"),
                        rs.getString("课程名"),
                        rs.getDouble("学分"),
                        rs.getString("教师id")
                };
                System.out.println(Arrays.toString(date3[i2]));
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
        return date3;
    }
}
