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
public class Manager_Teacher extends JFrame {
    Object[][] date1, date2,grade,date3;
    public Manager_Teacher() {
        SelectAllTeacher AllStudent = new SelectAllTeacher();
        date2 = AllStudent.s();
        initComponents();
    }

    private void button1ActionPerformed() {
        // TODO add your code here
        SelectManager_Teacher selectManager_teacher = new SelectManager_Teacher();
        date1 = selectManager_teacher.SelectManger_Student();
        //ˢ��table
        table1.setModel(new DefaultTableModel(
                date1,
                new String[]{
                        "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u5b66\u5206","\u4efb\u8bfe\u8001\u5e08id"
                }
        ));
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //��ȡtable������
        grade = new Object[table1.getRowCount()][];
        for (int i = 0;i<table1.getRowCount();i++){
            grade[i]=new Object[]{
                    table1.getValueAt(i,0),
                    table1.getValueAt(i,3)
            };
            System.out.println("i:"+i);
            System.out.println(Arrays.toString(grade[i]));
        }
        if (grade[0][1]==null){
            JOptionPane.showMessageDialog(null,"������ѡ�η���");
        }
        else{
            Update_Manager_Teacher manager_teach = new Update_Manager_Teacher(grade);
            manager_teach.S();
        }
        button1ActionPerformed();
    }

    private void button3ActionPerformed() {
        // TODO add your code here
        SelectManager_Teacher_all selectManager_teacher_all = new SelectManager_Teacher_all();
        date3 = selectManager_teacher_all.S();
        //ˢ��table
        table1.setModel(new DefaultTableModel(
                date3,
                new String[]{
                        "ѧ��","\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u5b66\u5206","\u4efb\u8bfe\u8001\u5e08id"
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
        button3 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title_2"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("����γ�-��ʦ");
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
                            "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d","\u5b66\u5206", "\u4efb\u8bfe\u8001\u5e08 id"
                    }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                        Object.class, Object.class, Object.class, Object.class, Double.class, Object.class
                };
                boolean[] columnEditable = new boolean[] {
                        false, false, true
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
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 90, 615, 135);

        //---- button1 ----
        button1.setText("��ѯδ�����ʦ�Ŀγ�");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.addActionListener(e -> button1ActionPerformed());
        contentPane.add(button1);
        button1.setBounds(300, 55, 189, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(305, 460, 150, 40);

        //---- button3 ----
        button3.setText("��ѯ�ѷ����ʦ�Ŀγ�");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 2f));
        button3.addActionListener(e -> button3ActionPerformed());
        contentPane.add(button3);
        button3.setBounds(95, 55, 189, button3.getPreferredSize().height);

        //======== scrollPane2 ========
        {

            //---- table2 ----
            table2.setModel(new DefaultTableModel(
                    date2,
                    new String[] {
                            "����", "\u59d3\u540d", "����"
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
        label3.setText("��ʦ��");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(5, 270, 65, 27);

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
    private JButton button3;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
