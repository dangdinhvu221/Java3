/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Class.ChuyenNganh;
import databaseHelper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dangd
 */
public class QLChuyenNganhService {

    public List<ChuyenNganh> getAll() {
        List<ChuyenNganh> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.chuyen_nganh";
        try ( Connection conn = DatabaseHelper.openConnection();  
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            list.clear();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tenCN = rs.getString("ten_chuyen_nganh");
                ChuyenNganh cn = new ChuyenNganh(id, tenCN);
                list.add(cn);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
