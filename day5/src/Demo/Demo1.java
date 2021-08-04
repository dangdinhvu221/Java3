/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo1 {

    public static void main(String[] args) {
        USER user = new USER(1, "admindt", "admin", "Đào tạo");
        Connection conn;
        try {
            //B1: load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // B2: kết nối vs DB
            String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PolyApp; user= vuddph14036; password= 123456";
            conn = DriverManager.getConnection(connectionUrl);
            // Câu truy vấn 
            String query = "DELETE FROM dbo.USERS WHERE id = ?";
            // b3: Tạo PreparedStatement thực hiện câu truy vấn
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, user.getId());
            
            // executeUpdate() thực thi truy vấn thêm, sửa, xoá
            // giá trị trả về của executeUpdate được lưu trong biến kq
            // thể hiện có bao nhiêu bản ghi trong db bị ảnh hưởng ở câu truy vấn
            int kq = pstmt.executeUpdate();
            //B4: Đóng
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
