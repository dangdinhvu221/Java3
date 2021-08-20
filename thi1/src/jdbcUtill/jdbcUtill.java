/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcUtill;
import java.sql.*;

/**
 *
 * @author dangd
 */
public class jdbcUtill {
    public static Connection ketNoi() throws Exception{
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QLSach";
        String us = "sa", pass = "v06052002";
        Connection conn = DriverManager.getConnection(url,us,pass);
        return conn;
    }
}
