/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal.theLoai;
import jdbcUtill.jdbcUtill;

/**
 *
 *
 * @author dangd
 */
public class theLoaiDao {

    public List<theLoai> getAll() throws Exception {
        List<theLoai> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.THELOAI";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            theLoai tl = new theLoai();
            tl.setMaTL(rs.getString(1));
            tl.setTenTL(rs.getString(2));
            list.add(tl);
        }
        return list;
    }
}
