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
import modal.danhMuc;

/**
 *
 * @author dangd
 */
public class danhMucDao {
    public List<danhMuc> getAll() throws Exception {
        List<danhMuc> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.danh_muc";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            danhMuc dm = new danhMuc();
            dm.setId(rs.getInt(1));
            dm.setTenDanhMuc(rs.getString(2));
            list.add(dm);
        }
        conn.close();
        
        return list;
    }
}
