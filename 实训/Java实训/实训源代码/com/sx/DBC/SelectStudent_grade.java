package com.sx.DBC;

import com.sx.jdbc.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStudent_grade {
    String sno,xueqi;
    int i1=0,i2=0;
    public SelectStudent_grade(String sno, String xueqi) {
        this.sno = sno;
        this.xueqi = xueqi;
    }

    public Object[][] S_S() {
        Connection connection = null;
        Statement statement = null;
        Object[][] obj =null;
        System.out.println("Sno:"+sno);
        System.out.println("ѧ��:"+xueqi);
        try {
            connection = DBManager.getConn();
            //4������sql���
            String sql = "SELECT * \n" +
                    "FROM ѡ�α�,�γ̱�,��ʦ��,`ѧ����`\n" +
                    "WHERE  ѡ�α�.�γ̺�=�γ̱�.�γ̺�\n" +
                    "AND ��ʦ��.��ʦid=�γ̱�.��ʦid\n" +
                    "AND ѡ�α�.`ѧ��id`=`ѧ����`.`ѧ��id`\n" +
                    "AND ѡ�α�.ѧ��id="+sno+" and ѧ��='"+xueqi+"'";
            //5����ȡִ��sql�Ķ���Statement
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                if(rs.getInt("�ɼ�")!=0) {
                    i1++;
                }
            }
            System.out.println("SSG_i1:"+i1);
            obj = new Object[i1][];
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getInt("�ɼ�")!=0){
                    obj[i2] = new Object[]{
                            rs.getString("ѧ��"),
                            rs.getString("�γ̺�"),
                            rs.getString("�γ���"),
                            rs.getString("��ʦ����"),
                            rs.getDouble("ѧ��"),
                            rs.getInt("�ɼ�")
                    };
                    i2++;
                }

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
