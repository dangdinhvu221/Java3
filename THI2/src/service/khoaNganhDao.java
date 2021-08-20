/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import modal.khoaNganh;
import java.sql.*;
import jdbcUtill.jdbcUtill;

/**
 *
 * @author dangd
 */
public class khoaNganhDao {

    public List<khoaNganh> getAll() throws Exception {
        List<khoaNganh> list = new ArrayList<>();
        String sql = "select * from KHOANGANH";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            khoaNganh kn = new khoaNganh();
            kn.setMaKN(rs.getString(1));
            kn.setTenKN(rs.getString(2));
            list.add(kn);
        }
        conn.close();
        return list;
    }
}
