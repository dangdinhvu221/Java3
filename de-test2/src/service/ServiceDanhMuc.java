/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import modal.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DatabaseHelper.DatabaseHelper;

/**
 *
 * @author dangd
 */
public class ServiceDanhMuc {
    public List<DanhMuc> getAll(){
        List<DanhMuc> listDM = new ArrayList<>();
        String sql = "SELECT * FROM dbo.danh_muc";
        try (Connection conn = DatabaseHelper.openConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {      
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(1));
                dm.setTenDanhMuc(rs.getString(2));
                listDM.add(dm);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDM;
    }
    
}
