/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcUtil;
import java.sql.*;
/**
 *
 * @author dangd
 */
public class ketnoi {
    public static Connection kettnoijdbc() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=quan_ly_blog ";
        String us = "sa";
        String pass = "v06052002";
        Connection conn = DriverManager.getConnection(url, us, pass);
        return conn;
    }
}
