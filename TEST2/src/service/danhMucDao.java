/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal.danhMuc;
import jdbcUtill.jdbcUtill;
/**
 *
 * @author dangd
 */
public class danhMucDao {
    public List<danhMuc> getAll()throws Exception{
        List<danhMuc> list = new ArrayList<>();
        String sql = "SELECT*FROM danh_muc";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
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
