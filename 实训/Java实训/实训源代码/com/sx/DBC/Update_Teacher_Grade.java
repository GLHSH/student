package com.sx.DBC;

import com.sx.jdbc.DBManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class Update_Teacher_Grade {
    Object[][] date3;
    public Update_Teacher_Grade(Object[][] date3) {
        this.date3=date3;
    }

    public void S() {
        Connection connection = null;
        Statement statement = null;
        String sql;
        int a=0;
        try {
            connection = DBManager.getConn();
            statement = connection.createStatement();
            //分配课程-学生
            for (int i= 0;i<date3.length;i++) {
                sql = "update 选课表 set 成绩='"+date3[i][2]+"' WHERE 课程号='"+date3[i][0]+"' and 学生id='"+date3[i][1]+"'";
                int result = statement.executeUpdate(sql);
                System.out.println(result);
                a++;
            }
            JOptionPane.showMessageDialog(null,"成绩方案 提交成功");
        } catch (Exception e) {
            if (a!=0){
                JOptionPane.showMessageDialog(null,"成功提交"+a+"条数据");
            }
            JOptionPane.showMessageDialog(null,"成绩提交失败\n请输入在0到100范围的成绩");
        }
    }
}
