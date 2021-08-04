/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author dangd
 */
public class DemoJDBC {

    public static void main(String[] args) {
        // load driver JDBC
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception ex) {
        }
        // chuỗi kết nối tới DB
        // protocol://<host>:<pro> : DatabaseName = ; user = ; password = ;
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PolyApp; user= vuddph14036; password= 123456";

        // tạo kết nối (Connection) vào DB
        // tạo Statement để thực hiện câu lệnh truy vấn
        String SQL = "SELECT * FROM USERS";
        try ( Connection con = DriverManager.getConnection(connectionUrl);
                PreparedStatement pstmt = con.prepareStatement(SQL)) {
            
            ResultSet rs = pstmt.executeQuery();
            // Lặp lại dữ liệu trong tập kết quả và hiển thị nó.
            // rs.next còn dữ liệu có thể đọc được -> true;
            // rs.next ko còn dữ liệu để đọc -> false
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String role =  rs.getString("Role");
                
//                System.out.println(rs.getInt("id") + "| " 
//                                    + rs.getString("Username") + "| "
//                                    + rs.getString("Password") + "| " 
//                                    + rs.getString("Role"));
                System.out.printf("%d | %s | %s | %s\n", id, username, password, role);
            }
            con.close();
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
