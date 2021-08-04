/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHelper;

import java.sql.*;

/**
 *
 * @author dangd
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
        String username = "sa";
        String password = "v06052002";
        Connection conn = DriverManager.getConnection(url, username, password);
        
        return conn;
    }
}
