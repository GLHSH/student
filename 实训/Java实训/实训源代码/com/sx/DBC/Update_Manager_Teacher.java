package com.sx.DBC;

import com.sx.jdbc.DBManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class Update_Manager_Teacher {
    Object[][] date3;
    public Update_Manager_Teacher(Object[][] date3) {
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
            //����γ�-ѧ��
            for (int i= 0;i<date3.length;i++) {
                sql = "update �γ̱� set ��ʦid=' "+date3[i][1]+"' WHERE �γ̺�='"+date3[i][0]+"'";
                int result = statement.executeUpdate(sql);
                System.out.println(result);
                a++;
            }
            JOptionPane.showMessageDialog(null,"���䷽�� �ύ�ɹ�");
        } catch (Exception e) {
            if (a!=0){
                JOptionPane.showMessageDialog(null,"�ɹ��ύ"+a+"������");
            }
            JOptionPane.showMessageDialog(null,"���º����ο���Ϣ��������\n�������±��еĽ�ʦ����");
        }
    }
}
