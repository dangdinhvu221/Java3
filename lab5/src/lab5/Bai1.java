/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import DatabaseHelper.DatabaseHelper;
import java.sql.*;

/**
 *
 * @author dangd
 */
public class Bai1 {

    public static void main(String[] args) {
        String sql = "SELECT * FROM dbo.STUDENT";
        try ( Connection conn = DatabaseHelper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.print(rs.getString("MaSV") + ", ");
                    System.out.print(rs.getString("TenSV") + ", ");
                    System.out.print(rs.getString("Email") + ", ");
                    System.out.print(rs.getString("SoDT") + ", ");
                    System.out.println(rs.getString("GioiTinh"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
