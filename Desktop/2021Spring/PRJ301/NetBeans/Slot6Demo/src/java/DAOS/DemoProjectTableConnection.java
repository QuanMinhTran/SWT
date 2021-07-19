/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DemoProjectTableConnection {
    public static void main(String[] args) {
        try{
            //jdbc driver type 4: native Protocol
            //1: khai báo lớp driver dung để kết nối CSDL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2: Tạo đối tượng kết nối CSDL gồm 3 tham số: url, username, password
            String url ="jdbc:sqlserver://localhost:1433;databaseName=ProductManagement";
            Connection c = DriverManager.getConnection(url,"Mem", "0941767748");
            
            //3: tạo đối tượng thực thi câu truy vấn Statement/Prepared Statement
            String sql ="SELECT * FROM Products";
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Đối tượng kết quả sau khi thực thi câu truy vấn
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                //duyệt qua từng mẫu tin
                String id = rs.getString("ProductID");
                String n = rs.getString("ProductName");
                String desc = rs.getString("ProductDescription");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Price");
                String imageurl = rs.getString("ImageUrl");
                
                System.out.println("ID: "+ id + " - "+n+" - "+desc+" - "+quantity+" - "+price+" - "+imageurl);
            }
            //5: Đóng kết nối
            rs.close();
            ps.close();
            c.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
