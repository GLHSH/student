package com.sx.DBC;

import com.sx.User.User;
import com.sx.jdbc.DBManager;

import java.sql.*;
import java.util.Arrays;

public class SelectTeacher_Some {
    User user;
    private Object[][] obj1;

    public SelectTeacher_Some(User user) {
        this.user=user;
    }

    public Object[][] S() {
        Connection connection = DBManager.getConn();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select ѧ��,�γ̱�.�γ̺�,�γ���,ѧ��,ѧ��id,�ɼ� from �γ̱�,ѡ�α� where �γ̱�.�γ̺�=ѡ�α�.�γ̺� and ��ʦid='"+user.getUid()+"' and ѧ��='202101' and ѧ��id is not null and �ɼ� is null order by �γ̱�.�γ̺�";
            ResultSet rs=statement.executeQuery(sql);
            int i1=0,i2=0;
            while (rs.next()){
                i1++;
            }
            System.out.println("����:"+i1);
            obj1=new Object[i1][];
            rs=statement.executeQuery(sql);
            while (rs.next()){
                obj1[i2]=new Object[]{
                        rs.getString("ѧ��"),
                        rs.getString("�γ̱�.�γ̺�"),
                        rs.getString("�γ���"),
                        rs.getString("ѧ��"),
                        rs.getString("ѧ��id"),
                        rs.getString("�ɼ�")
                };
                System.out.println(Arrays.toString(obj1[i2]));
                i2++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj1;
    }
}
