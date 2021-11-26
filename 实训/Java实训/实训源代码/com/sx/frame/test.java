package com.sx.frame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Wed Sep 15 10:38:46 CST 2021
 */
public class test extends JFrame {
    Object[]rs = new Object[5];
    int i = 0;
    public test() {
        initComponents();
    }

    public static void main(String[] args) {
        new test();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        while (i<3){
            rs[i]= table1.getValueAt(i,1);
            int s1 = table1.getRowCount();
            System.out.println("testÐÐÊý:"+s1);
            System.out.println(rs[i]);
            System.out.println("i:"+i);
            ++i;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.sx.form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();

        //======== this ========
        setVisible(true);
        setTitle(bundle.getString("this.title_3"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"1", 2},
                    {"3", 4},
                    {"5", 6},
                },
                new String[] {
                    null, "\u6210\u7ee9"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, true
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
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 100, 515, 320);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(535, 100), button1.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(125, 15, 155, 70);

        contentPane.setPreferredSize(new Dimension(640, 470));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JScrollPane scrollPane2;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
