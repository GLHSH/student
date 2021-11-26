package com.sx.DBC;

import com.sx.frame.Manager_Student;
import com.sx.jdbc.DBManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Insert_Manager_Student {
    Object[][] obj;
    public Insert_Manager_Student(Object[][] obj) {
        this.obj=obj;
    }
    public void S(){
        Connection connection = null;
        Statement statement = null;
        String sql;
        int a =0;
        try {
            connection = DBManager.getConn();
            statement = connection.createStatement();
            //分配课程-学生
            for (int i= 0;i<obj.length;i++) {
//INSERT INTO `data`.`选课表` (`学期`, `课程号`, `学生id`, `成绩`) VALUES ('202101', '"+obj[i][0]+"', '"+obj[i][1]+"', NULL);
                sql = "INSERT INTO `data`.`选课表` (`学期`, `课程号`, `学生id`, `成绩`) VALUES ('202101', '"+obj[i][0]+"', '"+obj[i][1]+"', NULL)";
                //sql = "update 选课表 set 学生id=' "+obj[i][1]+"' WHERE 课程号='"+obj[i][0]+"'";
                int result = statement.executeUpdate(sql);
                System.out.println("result: "+result);
                a++;
            }
            JOptionPane.showMessageDialog(null,"分配方案 提交成功");
        } catch (Exception e) {
            if (a!=0){
                JOptionPane.showMessageDialog(null,"成功提交"+a+"条数据");
            }
            JOptionPane.showMessageDialog(null,"更新后续选课信息出现问题\n请输入下表中的学生学号");
        }
    }
}
