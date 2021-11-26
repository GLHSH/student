package com.sx.frame;

import com.sx.User.User;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import com.sx.DBC.*;

/**
 * @author unknown
 */
public class Student extends JFrame {
    String USno;
    Object[][] obj ;
    static JTable table1;
    public Student(User user) {
        USno = user.getUid();
        initComponents();
    }
    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.sx.form");
        label1 = new JLabel();
        Sno = new JLabel();
        comboBox1 = new JComboBox<>();
        Select_Student = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf-学生端");
        setBackground(Color.white);
        setForeground(SystemColor.menu);
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label1);
        label1.setBounds(10, 0, 80, 45);

        //---- Sno ----
        Sno.setText(USno);
        Sno.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        Sno.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(Sno);
        Sno.setBounds(95, 0, 80, 45);

        //---- comboBox1 ----
        JComboBox<String> xq =new JComboBox<String>();
        xq.addItem("202101");
        xq.addItem("202002");
        xq.addItem("202001");
        this.add(xq);
        xq.setBounds(10, 65, 110, 40);

        //---- Select_Student ----
        Select_Student.setText(bundle.getString("Select_Student.text"));
        Select_Student.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
        Select_Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xueqi = Objects.requireNonNull(xq.getSelectedItem()).toString();
                SelectStudent_grade selectStdentGrade = new SelectStudent_grade(USno,xueqi);
                obj= selectStdentGrade.S_S();
                System.out.println();
                table1.setModel(new DefaultTableModel(
                        obj,
                        new String[] {
                                "\u5b66\u671f", "\u8bfe\u53f7", "\u8bfe\u7a0b\u540d",  "任课老师", "学分","成绩"
                        }
                ){
                                    boolean[] columnEditable = new boolean[] {
                                            false, false, false, false, false, false
                                    };
                                    @Override
                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                        return columnEditable[columnIndex];
                                    }
                                }
                );
            }
        });
        contentPane.add(Select_Student);
        Select_Student.setBounds(145, 65, 110, 40);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                obj,
                new String[] {
                    "\u5b66\u671f", "\u8bfe\u53f7", "\u8bfe\u7a0b\u540d", "\u4efb\u8bfe\u8001\u5e08", "学分", "成绩"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, true
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 130, 575, 305);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text"));
        contentPane.add(button2);
        button2.setBounds(495, 0, 90, 45);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        contentPane.setPreferredSize(new Dimension(590, 470));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel Sno;
    private JComboBox<String> comboBox1;
    private JButton Select_Student;
    private JScrollPane scrollPane1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
