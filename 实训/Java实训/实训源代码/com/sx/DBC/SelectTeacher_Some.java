package com.sx.DBC;

import com.sx.User.User;
import com.sx.jdbc.DBManager;

import java.sql.*;
import java.util.Arrays;

public class SelectTeacher_Some {
    User user;
    private Object[][] obj1;

    public SelectTeacher_Some(User user) {
        this.user=user;
    }

    public Object[][] S() {
        Connection connection = DBManager.getConn();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select 学期,课程表.课程号,课程名,学分,学生id,成绩 from 课程表,选课表 where 课程表.课程号=选课表.课程号 and 教师id='"+user.getUid()+"' and 学期='202101' and 学生id is not null and 成绩 is null order by 课程表.课程号";
            ResultSet rs=statement.executeQuery(sql);
            int i1=0,i2=0;
            while (rs.next()){
                i1++;
            }
            System.out.println("行数:"+i1);
            obj1=new Object[i1][];
            rs=statement.executeQuery(sql);
            while (rs.next()){
                obj1[i2]=new Object[]{
                        rs.getString("学期"),
                        rs.getString("课程表.课程号"),
                        rs.getString("课程名"),
                        rs.getString("学分"),
                        rs.getString("学生id"),
                        rs.getString("成绩")
                };
                System.out.println(Arrays.toString(obj1[i2]));
                i2++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj1;
    }
}
