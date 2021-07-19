/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Laptops;
import dtos.Suppliers;
import dtos.Users;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import utils.DBConnect;

/**
 *
 * @author Admin
 */
public class LaptopDAO implements Serializable {

    
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public LaptopDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (con != null) {
            con.close();
        }
        if (pstm != null) {
            pstm.close();
        }
    }

    public Users checkLogin(String username, String password) throws Exception {
        Users result = null;
        try {
            String sql = "SELECT FullName\n"
                    + "FROM tblUsers\n"
                    + "WHERE Username=? AND Password=?";

            DBConnect db = new DBConnect();

            con = db.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("FullName");
                result = new Users(username, fullName);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<Laptops> GetAllLaptop() throws Exception {
        List<Laptops> list = null;
        try {
            String sql = "SELECT * "
                    + "FROM tblLaptops";
            DBConnect db = new DBConnect();
            con = db.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("LaptopName");
                String TI = rs.getString("TechnicalInformation");
                int year = rs.getInt("YearOfManufacture");
                String producer = rs.getString("Producer");
                String status = rs.getString("Status");
                String sid = rs.getString("SupplierID");

                SupplierDAO dao = new SupplierDAO();
                Suppliers s = dao.getSupplierByID(sid);
                Laptops l = new Laptops(id, name, TI, year, producer, status, s);
                list.add(l);

            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public Laptops GetLaptopByID(String lid) throws Exception {
        String sql = "SELECT *"
                + "FROM tblLaptops"
                + "WHERE ID=?";
        try {
            DBConnect db = new DBConnect();
            con = db.getConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, lid);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String name = rs.getString("LaptopName");
                    String TI = rs.getString("TechnicalInformation");
                    int year = rs.getInt("YearOfManufacture");
                    String producer = rs.getString("Producer");
                    String status = rs.getString("Status");
                    String sid = rs.getString("SupplierID");

                    SupplierDAO dao = new SupplierDAO();
                    Suppliers s = dao.getSupplierByID(sid);
                    Laptops l = new Laptops(id, name, TI, year, producer, status, s);
                    return l;
                }
            }
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean DeleteLaptop(String lid) throws Exception {
        boolean check = false;
        String sql = "DELETE FROM tblLaptops WHERE ID=?";
        try {
            DBConnect db = new DBConnect();
            con = db.getConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, lid);

                check = pstm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean UpdateLaptop(Laptops lap) throws Exception {
        String sql = "UPDATE tblLaptops SET LaptopName=?, TechnicalInformation=?,"
                + "YearOfManufacture=?, Producer=?, Status=?, SupplierID=? WHERE ID=?";
        try {
            DBConnect db = new DBConnect();
            con = db.getConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(7, lap.getId());
                pstm.setString(1, lap.getLaptopName());
                pstm.setString(2, lap.getTechnicalInformation());
                pstm.setInt(3, lap.getYearOfManufacture());
                pstm.setString(4, lap.getProducer());
                pstm.setString(5, lap.getStatus());
                pstm.setString(6, lap.getSupplierID().getSupplierID());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean addLaptop(Laptops lap) throws Exception {
        String sql = "INSERT INTO tblLaptops(ID, "
                + "LaptopName, TechnicalInformation, YearOfManufacture, Producer, Status, SupplierID)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            DBConnect db = new DBConnect();
            con = db.getConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, lap.getId());
                pstm.setString(2, lap.getLaptopName());
                pstm.setString(3, lap.getTechnicalInformation());
                pstm.setInt(4, lap.getYearOfManufacture());
                pstm.setString(5, lap.getProducer());
                pstm.setString(6, lap.getStatus());
                pstm.setString(7, lap.getSupplierID().getSupplierID());

                pstm.executeQuery();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

}
