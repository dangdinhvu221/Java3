/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbcUtill;
import modal.TheLoai;

/**
 *
 * @author dangd
 */
public class theLoaiDao {

    public List<TheLoai> getAll() {
        List<TheLoai> list = new ArrayList<>();
        try {
            String sql = "SELECT*FROM dbo.THELOAI";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setMaTL(rs.getString(1));
                tl.setTenTL(rs.getString(2));
                list.add(tl);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
