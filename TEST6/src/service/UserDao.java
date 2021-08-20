/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import modal.User;
import jdbcUtill.jdbcUtill;

/**
 *
 * @author dangd
 */
public class UserDao {

    public User checkLogIn(String user, String passWord) {
        String sql = "select * from USERS WHERE [username] = ? AND [upassword] = ?";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, passWord);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setUsername(rs.getString(1));
                us.setPassword(rs.getString(2));
                us.setChucnang(rs.getString(3));
                return us;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
