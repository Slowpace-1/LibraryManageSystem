package com.littleheap.DataBase;

import java.sql.*;

import com.littleheap.Static.Information;

public class UpdateDeleteDemo {

    public static void main(String[] args)throws Exception{
        try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
                
            String url="jdbc:mysql://localhost:3306/BookManageSYS";    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");

            //��ѯ���ݵĴ���
            String sql = "select * from stu";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t"+"����"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getInt(3) + "\t");
                    System.out.println();
                }
                
            //�޸����ݵĴ���
            String sql2 = "update stu set name=? where number=?";
            PreparedStatement pst = conn.prepareStatement(sql2);
            pst.setString(1,"8888");
            pst.setInt(2,198);
            pst.executeUpdate();
                
            //ɾ�����ݵĴ���
            String sql3 = "delete from stu where number=?";
            pst = conn.prepareStatement(sql3);
            pst.setInt(1,701);
            pst.executeUpdate();
                
            ResultSet rs2 = stmt.executeQuery(sql);//�������ݶ���
            System.out.println("���"+"\t"+"����"+"\t"+"����");
            while (rs.next()){
                System.out.print(rs2.getInt(1) + "\t");
                System.out.print(rs2.getString(2) + "\t");
                System.out.print(rs2.getInt(3) + "\t");
                System.out.println();
            }
                
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}