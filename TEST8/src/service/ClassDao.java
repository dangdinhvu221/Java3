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
import jdbc.jdbcUtill;
import modal.Classs;

/**
 *
 * @author dangd
 */
public class ClassDao {
     public List<Classs> getAll() {
        List<Classs> list = new ArrayList<>();
        try {
            String sql = "select * from dbo.Class";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setMaKN(rs.getString(1));
                cl.setTenKN(rs.getString(2));
                list.add(cl);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
