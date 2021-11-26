package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class SelectManager_Teacher {

    public Object[][] SelectManger_Student() {
        Connection connection = null;
        Statement statement = null;
        Object[][] obj1 =null;
        try {
            connection = DBManager.getConn();
            //4������sql���
            String sql = "SELECT * FROM �γ̱� WHERE ��ʦid is null ";
            //5����ȡִ��sql�Ķ���Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            int i1= 0;
            while (rs.next()){
                i1++;
            }System.out.println("����:"+i1);
            obj1 = new Object[i1][];
            rs = statement.executeQuery(sql);
            int i2=0;
            while (rs.next()) {
                obj1[i2] = new Object[]{
                        rs.getString("�γ̺�"),
                        rs.getString("�γ���"),
                        rs.getDouble("ѧ��"),
                        null
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
