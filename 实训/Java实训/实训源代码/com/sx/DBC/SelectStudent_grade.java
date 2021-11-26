package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStudent_grade {
    String sno,xueqi;
    int i1=0,i2=0;
    public SelectStudent_grade(String sno, String xueqi) {
        this.sno = sno;
        this.xueqi = xueqi;
    }

    public Object[][] S_S() {
        Connection connection = null;
        Statement statement = null;
        Object[][] obj =null;
        System.out.println("Sno:"+sno);
        System.out.println("学期:"+xueqi);
        try {
            connection = DBManager.getConn();
            //4、定义sql语句
            String sql = "SELECT * \n" +
                    "FROM 选课表,课程表,教师表,`学生表`\n" +
                    "WHERE  选课表.课程号=课程表.课程号\n" +
                    "AND 教师表.教师id=课程表.教师id\n" +
                    "AND 选课表.`学生id`=`学生表`.`学生id`\n" +
                    "AND 选课表.学生id="+sno+" and 学期='"+xueqi+"'";
            //5、获取执行sql的对象、Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                if(rs.getInt("成绩")!=0) {
                    i1++;
                }
            }
            System.out.println("SSG_i1:"+i1);
            obj = new Object[i1][];
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getInt("成绩")!=0){
                    obj[i2] = new Object[]{
                            rs.getString("学期"),
                            rs.getString("课程号"),
                            rs.getString("课程名"),
                            rs.getString("教师姓名"),
                            rs.getDouble("学分"),
                            rs.getInt("成绩")
                    };
                    i2++;
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

        return obj;
    }

}
