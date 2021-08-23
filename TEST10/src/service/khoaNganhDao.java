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
import modal.khoaNganh;
import jdbc.jdbcUtill;

/**
 *
 * @author dangd
 */
public class khoaNganhDao {

    public List<khoaNganh> getAll() {
        List<khoaNganh> list = new ArrayList<>();
        try {
            String sql = "select * from KHOANGANH";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                khoaNganh kn = new khoaNganh();
                kn.setMaKn(rs.getString(1));
                kn.setTenKN(rs.getString(2));
                list.add(kn);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
