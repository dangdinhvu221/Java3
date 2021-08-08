/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import modal.USER;
import DatabaseHelper.DatabaseHalper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dangd
 */
public class UserDao {
    public USER checkLogIn(String Username, String Password) throws Exception {
        String sql = "select * from dbo.USERS "
                + "WHERE [Username] = ? AND [Password] = ?";
        try ( Connection conn = DatabaseHalper.openConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, Username);
            pstmt.setString(2, Password);

            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    USER user = new USER();
                    user.setUsername(Username);
                    user.setPassword(Password);
                    user.setRole(rs.getString("Role"));
                    return user;
                }
            }
            return null;
        }
    }
}
