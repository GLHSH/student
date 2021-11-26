package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class SelectManager_Student_All {
    public SelectManager_Student_All() {

    }

    public Object[][] S() {
        Connection connection = null;
        Statement statement = null;
        Object[][] obj1 =null;
        try {
            connection = DBManager.getConn();
            int  i1=0 , i2=0;
            //4������sql���
            String sql = "SELECT DISTINCT ѧ��,ѡ�α�.�γ̺�,�γ���,ѧ��,��ʦ����,ѡ�α�.ѧ��id FROM ѡ�α�,�γ̱�,��ʦ��  WHERE ѡ�α�.�γ̺�=�γ̱�.�γ̺� and �γ̱�.��ʦid=��ʦ��.��ʦid  and ѧ��='202101' and ѡ�α�.ѧ��id is not null  order by �γ̱�.�γ̺�";
            //5����ȡִ��sql�Ķ���Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                i1++;
            }System.out.println("����:"+i1);
            obj1 = new Object[i1][];
            rs = null;
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                obj1[i2] = new Object[]{
                        rs.getString("ѧ��"),
                        rs.getString("�γ̺�"),
                        rs.getString("�γ���"),
                        rs.getDouble("ѧ��"),
                        rs.getString("��ʦ����"),
                        rs.getString("ѡ�α�.ѧ��id")
                };
                System.out.println(Arrays.toString(obj1[i2]));
                i2++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7���ر���Դ
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return obj1;
    }
}
