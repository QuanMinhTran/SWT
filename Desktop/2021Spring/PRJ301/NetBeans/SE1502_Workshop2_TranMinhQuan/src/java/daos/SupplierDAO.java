/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnect;

/**
 *
 * @author Admin
 */
public class SupplierDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

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

    public List<Suppliers> GetAllSuppliers() throws Exception {
        List<Suppliers> lst = null;

        String sql = "SELECT * FROM tblSuppliers";
        try {
            DBConnect db = new DBConnect();
            con = db.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("SupplierID");
                String name = rs.getString("SupplierName");
                String desc = rs.getString("Description");

                Suppliers s = new Suppliers(id, name, desc);
                lst.add(s);
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public Suppliers getSupplierByID(String id) throws Exception {
        Suppliers result = null;
        try {
            String sql = "SELECT *\n"
                    + "FROM tblSuppliers\n"
                    + "WHERE SupplierID=?";

            DBConnect db = new DBConnect();
            con = db.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("SupplierName");
                String desc = rs.getString("Description");
                result = new Suppliers(id, name, desc);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
