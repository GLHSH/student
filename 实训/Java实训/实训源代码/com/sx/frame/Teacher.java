/*
 * Created by JFormDesigner on Wed Sep 22 22:31:40 CST 2021
 */

package com.sx.frame;

import java.awt.event.*;
import javax.swing.table.*;

import com.sx.DBC.*;
import com.sx.User.User;
import com.sx.jdbc.DBManager;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author unknown
 */
public class Teacher extends JFrame {
    User user;
    String Mno,Mname;
    private Object[][] date1,date2,date3;

    public Teacher(User user) {
        this.user=user;
        Mno = user.getUid();
        Connection connection = DBManager.getConn();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 教师姓名 FROM 教师表 WHERE 教师id='"+Mno+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Mname = resultSet.getString("教师姓名");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        initComponents();
    }

    private void button1ActionPerformed() {
        SelectTeacher_All select_teacher_all =new SelectTeacher_All(user);
        date1= select_teacher_all.S();
        table1.setModel(new DefaultTableModel(
                date1,
                new String[] {
                        "学期", "课程号", "课程名", "学分", "学号", "成绩"
                }
        ));
    }

    private void button2ActionPerformed() {
        // TODO add your code here
        SelectTeacher_Some select_teacher_Some =new SelectTeacher_Some(user);
        date2= select_teacher_Some.S();
        table1.setModel(new DefaultTableModel(
                date2,
                new String[] {
                        "学期", "课程号", "课程名", "学分", "学号", "成绩"
                }
        ));
        
    }

    private void button3ActionPerformed(ActionEvent e) {
        //获取table的数据
        date3 = new Object[table1.getRowCount()][];
        for (int i = 0;i<table1.getRowCount();i++){
            date3[i]=new Object[]{
                    table1.getValueAt(i,1),
                    table1.getValueAt(i,4),
                    table1.getValueAt(i,5)
            };
            System.out.println("i:"+i);
            System.out.println(Arrays.toString(date3[i]));
        }
        if (date3[0][2]==null){
            JOptionPane.showMessageDialog(null,"请输入选课方案");
        }
        else{
            Update_Teacher_Grade TeachGrade = new Update_Teacher_Grade(date3);
            TeachGrade.S();
        }
        button2ActionPerformed();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        Tno = new JLabel();
        label3 = new JLabel();
        Tname = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf-\u6559\u5e08\u7aef");
        var contentPane = getContentPane();
        setVisible(true);
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5de5\u53f7:");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(5, 10, 120, 40);

        //---- Tno ----
        Tno.setText(Mno);
        contentPane.add(Tno);
        Tno.setBounds(130, 10, 120, 40);

        //---- label3 ----
        label3.setText("\u59d3\u540d:");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(5, 55, 120, 40);

        //---- Tname ----
        Tname.setText(Mname);
        contentPane.add(Tname);
        Tname.setBounds(130, 55, 120, 40);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                },
                new String[] {
                    "\u5b66\u671f", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 150, 575, 264);

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u5df2\u7ecf\u5f55\u5165\u6210\u7ee9\u7684\u540c\u5b66");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.addActionListener(e -> button1ActionPerformed());
        contentPane.add(button1);
        button1.setBounds(75, 105, 200, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u5f00\u59cb\u5f55\u5165\u5b66\u751f\u6210\u7ee9");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        button2.addActionListener(e -> button2ActionPerformed());
        contentPane.add(button2);
        button2.setBounds(335, 105, 185, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u63d0\u4ea4\u6210\u7ee9");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 4f));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(240, 425, 105, 40);

        contentPane.setPreferredSize(new Dimension(615, 510));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel Tno;
    private JLabel label3;
    private JLabel Tname;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
