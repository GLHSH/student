/*
 * Created by JFormDesigner on Fri Sep 17 15:35:35 CST 2021
 */
package com.sx.frame;

import com.sx.DBC.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class Manager_Student extends JFrame {
    Object[][] date1,date2, plan,date3;
    public Manager_Student() {
        SelectAllStudent AllStudent = new SelectAllStudent();
        date2 = AllStudent.s();
        initComponents();
    }

    public void button1ActionPerformed() {
        // TODO add your code here
        SelectManager_Student selectManagerStudent = new SelectManager_Student();
        date1 = selectManagerStudent.SelectManger_Student();
        //刷新table
        table1.setModel(new DefaultTableModel(
                date1,
                new String[]{
                        "\u5b66\u671f", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u5b66\u5206","\u4efb\u8bfe\u8001\u5e08","\u5b66\u53f7"
                }
        ));
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //获取table的数据
        plan = new Object[table1.getRowCount()][];
        for (int i = 0;i<table1.getRowCount();i++){
            plan[i]=new Object[]{
                    table1.getValueAt(i,1),
                    table1.getValueAt(i,5)
            };
            System.out.println("i:"+i);
            System.out.println(Arrays.toString(plan[i]));
        }
        if (plan[0][1] == null){
            JOptionPane.showMessageDialog(null,"请输入选课方案");
        }
        else{
            Insert_Manager_Student manager_teach = new Insert_Manager_Student(plan);
            manager_teach.S();
        }
        button1ActionPerformed();
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        SelectManager_Student_All selectManager_student_all = new SelectManager_Student_All();
        date3 =selectManager_student_all.S();
        //刷新table
        table1.setModel(new DefaultTableModel(
                date3,
                new String[]{
                        "\u5b66\u671f", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d","\u5b66\u5206", "\u4efb\u8bfe\u8001\u5e08",  "\u5b66\u53f7"
                }
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.sx.form");
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        button3 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_2"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_4"));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        contentPane.add(label1);
        label1.setBounds(70, 5, 435, 30);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "\u5b66\u671f", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u4efb\u8bfe\u8001\u5e08", "\u5b66\u5206", "\u5b66\u53f7"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Double.class, Object.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, true
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(4).setResizable(false);
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 90, 615, 135);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.addActionListener(e -> button1ActionPerformed());
        contentPane.add(button1);
        button1.setBounds(350, 50, 189, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(305, 460, 150, 40);

        //======== scrollPane2 ========
        {

            //---- table2 ----
            table2.setModel(new DefaultTableModel(
                date2,
                new String[] {
                    "\u5b66\u53f7", "\u59d3\u540d", "\u4e13\u4e1a"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table2.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(2).setResizable(false);
            }
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(5, 300, 615, 145);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(5, 60, 55, 27);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text"));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(5, 270, 65, 27);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(100, 50, 190, button3.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(645, 555));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label2;
    private JLabel label3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
