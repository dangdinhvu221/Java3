/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author dangd
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TestAss1";
        String user = "sa", password = "v06052002";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
