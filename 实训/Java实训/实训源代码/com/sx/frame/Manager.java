/*
 * Created by JFormDesigner on Fri Sep 17 15:08:32 CST 2021
 */

package com.sx.frame;

import java.awt.event.*;
import com.sx.User.User;
import com.sx.jdbc.DBManager;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Manager extends JFrame {
    String Mno,Mname;
    public Manager(User user) {
        Mno = user.getUid();
        Connection connection = DBManager.getConn();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 管理员姓名 FROM user,管理员表 WHERE user.id=管理员表.管理员id and id='"+Mno+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Mname = resultSet.getString("管理员姓名");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        new Manager_Teacher();
    }

    private void button2ActionPerformed(ActionEvent e) {
        new Manager_Student();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.sx.form");
        label1 = new JLabel();
        mno = new JLabel();
        mno2 = new JLabel();
        mname = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_3"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(15, 10, 135, 50);

        //---- mno ----
        mno.setText(Mno);
        mno.setFont(mno.getFont().deriveFont(mno.getFont().getSize() + 6f));
        mno.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(mno);
        mno.setBounds(155, 10, 135, 50);

        //---- mno2 ----
        mno2.setText(bundle.getString("mno2.text"));
        mno2.setFont(mno2.getFont().deriveFont(mno2.getFont().getSize() + 6f));
        mno2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(mno2);
        mno2.setBounds(15, 65, 135, 50);

        //---- mname ----
        mname.setText(Mname);
        mname.setFont(mname.getFont().deriveFont(mname.getFont().getSize() + 6f));
        mname.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(mname);
        mname.setBounds(155, 65, 135, 50);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> {
            button1ActionPerformed(e);
        });
        contentPane.add(button1);
        button1.setBounds(55, 195, 165, 55);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
		});
        contentPane.add(button2);
        button2.setBounds(300, 195, 175, 55);

        contentPane.setPreferredSize(new Dimension(530, 405));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel mno;
    private JLabel mno2;
    private JLabel mname;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
