package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.*;

public class SelectAllTeacher {

    public SelectAllTeacher() {
    }

    public Object[][] s(){
        int i1 = 0,i2 = 0;
        Connection connection = null;
        Statement statement = null;
        Object[][] obj =null;
        try {
            connection = DBManager.getConn();
            //4������sql���
            String sql = "SELECT * FROM ��ʦ�� " ;
            //5����ȡִ��sql�Ķ���Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                i1++;
            }
            obj = new Object[i1][];
            rs = null;
            rs = statement.executeQuery(sql);
            System.out.println(i1);
            while (rs.next()) {
                obj[i2] = new Object[]{
                        rs.getString("��ʦid"),
                        rs.getString("��ʦ����"),
                        rs.getString("����")
                };
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
        return obj;
    }
}

