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
            //����γ�-ѧ��
            for (int i= 0;i<obj.length;i++) {
//INSERT INTO `data`.`ѡ�α�` (`ѧ��`, `�γ̺�`, `ѧ��id`, `�ɼ�`) VALUES ('202101', '"+obj[i][0]+"', '"+obj[i][1]+"', NULL);
                sql = "INSERT INTO `data`.`ѡ�α�` (`ѧ��`, `�γ̺�`, `ѧ��id`, `�ɼ�`) VALUES ('202101', '"+obj[i][0]+"', '"+obj[i][1]+"', NULL)";
                //sql = "update ѡ�α� set ѧ��id=' "+obj[i][1]+"' WHERE �γ̺�='"+obj[i][0]+"'";
                int result = statement.executeUpdate(sql);
                System.out.println("result: "+result);
                a++;
            }
            JOptionPane.showMessageDialog(null,"���䷽�� �ύ�ɹ�");
        } catch (Exception e) {
            if (a!=0){
                JOptionPane.showMessageDialog(null,"�ɹ��ύ"+a+"������");
            }
            JOptionPane.showMessageDialog(null,"���º���ѡ����Ϣ��������\n�������±��е�ѧ��ѧ��");
        }
    }
}
