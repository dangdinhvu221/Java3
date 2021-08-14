/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbcUtill.jdbcUtill;
import modal4.danhMuc;

/**
 *
 * @author dangd
 */
public class danhMucDao {
    public List<danhMuc> getAll() {
        List<danhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.danh_muc";
        try ( Connection conn = jdbcUtill.ketnoi(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                danhMuc s = new danhMuc();
                s.setId(rs.getInt(1));
                s.setTenDanhMuc(rs.getString(2));
                list.add(s);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
