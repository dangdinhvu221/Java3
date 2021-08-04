/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author dangd
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";
        String username = "sa";
        String password = "v06052002";
        Connection conn = DriverManager.getConnection(connectionUrl, username, password);
        return conn;
    }
}
