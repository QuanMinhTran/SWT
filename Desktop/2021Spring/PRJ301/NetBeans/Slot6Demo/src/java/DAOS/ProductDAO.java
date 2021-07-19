/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.Product;
import UTILS.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    
    public ArrayList<Product> getAllProducts() throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql="SELECT * FROM Products";
        
        ArrayList<Product> lst = new ArrayList<>();
        
        try{
            con = DBConnect.makeConnection();
            
            if(con != null){
                pstm = con.prepareStatement(sql);
                
                rs = pstm.executeQuery();
                
                while(rs.next())
                {
                    String id = rs.getString("ProductID");
                    String n = rs.getString("ProductName");
                    String desc = rs.getString("ProductDescription");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String imageurl = rs.getString("ImageUrl");
                    
                    Product p = new Product(id, n, desc, quantity, price, imageurl);
                    lst.add(p);
                }
            }
        }
        finally{
            if(rs!=null)
            {
                rs.close();
            }
            if(pstm!=null)
            {
                pstm.close();
            }
            if(con!=null)
            {
                con.close();
            }
                
        }
        return  lst;
    }
        
    public Product getProductbyId(String pid) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs =null;
        String sql="SELECT * FROM Products WHERE ProductId=?";
        try{
            con = DBConnect.makeConnection();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, pid);
                rs = pstm.executeQuery();
                
                if(rs.next()){
                    String id = rs.getString("ProductId");
                    String name = rs.getString("ProductName");
                    String description = rs.getString("ProductDescription");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String imgURL = rs.getString("ImageUrl");
                    
                    Product p = new Product(id, name, description, quantity, price, imgURL);
                    return p;
                    
                }
            }
        } 
        finally{
            if(rs != null){
                rs.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return null;
    }
    
    public boolean createProduct(Product p) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO Products(ProductID, "
                + "ProductName, ProductDescription, Quantity, Price, ImageURL)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try{
            con = DBConnect.makeConnection();
            if(con!=null)
            {
                pstm = con.prepareStatement(sql);
                
                pstm.setString(1, p.getId());
                pstm.setString(2, p.getName());
                pstm.setString(3, p.getDescription());
                pstm.setInt(4, p.getQuantity());
                pstm.setDouble(5, p.getPrice());
                pstm.setString(6, p.getImgURL());
                
                pstm.executeUpdate();
                
                return true;
                
            }
                
        }
        finally{
            if(pstm!=null)
            {
                pstm.close();
            }
            if(con!=null)
            {
                con.close();
            }
                
        }
        
        
        return false;
    }
    
    public boolean deleteProduct(String id) throws SQLException, NamingException 
    {
        Connection con =null;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM Products WHERE ProductID=?";
        
        try{
            con = DBConnect.makeConnection();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, id);
                
                pstm.executeUpdate();
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
        finally{
            if(pstm !=null)
            {
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateProduct(Product pd) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql="UPDATE Products SET ProductName=?, ProductDescription=?,"
                +"Quantity=?, Price=?, imageURL=? WHERE ProductID=?";
        try{
            con = DBConnect.makeConnection();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                
                pstm.setString(1, pd.getName());
                pstm.setString(2, pd.getDescription());
                pstm.setInt(3, pd.getQuantity());
                pstm.setDouble(4, pd.getPrice());
                pstm.setString(5, pd.getImgURL());
                pstm.setString(6, pd.getId());
                
                pstm.executeUpdate();
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            if(pstm!=null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
}
