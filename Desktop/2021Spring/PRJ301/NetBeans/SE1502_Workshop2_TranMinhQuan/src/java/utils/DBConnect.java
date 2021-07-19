/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class DBConnect {
        public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+servername+":"+portNumber+";databaseName="+dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
}
    
    private final String servername = "localhost";
    private final String dbname = "SE1502_Workshop2_TranMinhQuan";
    private final String portNumber = "1433";
    private final String userID = "Mem";
    private final String password = "0941767748";
    
}
