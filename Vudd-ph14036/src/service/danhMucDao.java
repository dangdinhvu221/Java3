/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import modal.danhMuc;
import jdbcUtil.ketnoi;
import java.sql.*;
/**
 *
 * @author dangd
 */
public class danhMucDao {
    List<danhMuc> list = new ArrayList<>();
    public List<danhMuc> getAll(){
        String sql = "SELECT*FROM dbo.danh_muc";
        try (Connection conn = ketnoi.kettnoijdbc();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                danhMuc dm = new danhMuc();
                dm.setId(rs.getInt(1));
                dm.setTenDAnhMuc(rs.getString(2));
                list.add(dm);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
