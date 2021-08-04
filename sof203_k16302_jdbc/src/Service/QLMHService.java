/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import databaseHelper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Class.*;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author dangd
 */
public class QLMHService {

    public List<MonHoc> getAll(int chuyenNganhId) {
        List<MonHoc> list = new ArrayList<>();
        String sql = "select * from mon_hoc WHERE [chuyen_nganh_id] = ?";
        try ( Connection conn = DatabaseHelper.openConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, chuyenNganhId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String mamh = rs.getString("ma_mon_hoc");
                String tenmh = rs.getString("ten_mon_hoc");
                Date ngayTao = rs.getString("ngay_tao");
                int cn = rs.getInt("chuyen_nganh_id");
                MonHoc mh = new MonHoc(id, mamh, tenmh, ngayTao, cn);
                list.add(mh);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public MonHoc insert(MonHoc monHoc) {
        //OUTPUT INSERTSET.ID
        String sql = "INSERT INTO dbo.mon_hoc(id, ma_mon_hoc, ten_mon_hoc, ngay_tao, chuyen_nganh_id) VALUES(?,?,?,?,?)";
        try ( Connection conn = DatabaseHelper.openConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, monHoc.getId());
            pstmt.setString(2, monHoc.getMaMonHoc());
            pstmt.setString(3, monHoc.getTenMonHoc());
            pstmt.setDate(4, (java.sql.Date) monHoc.getNgayTao());
            pstmt.setInt(5, monHoc.getChuyenNganhID());
            int kq = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monHoc;
    }

    public int update(MonHoc monHoc){
        String sql = "update from mon_hoc set [ma_mon_hoc] = ?, [ten_mon_hoc] = ?, [ngay_tao] = ?, [chuyen_nganh_id] = ? where [id] = ?";
        try ( Connection conn = DatabaseHelper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(5, monHoc.getId());
            pstmt.setString(1, monHoc.getMaMonHoc());
            pstmt.setString(2, monHoc.getTenMonHoc());
//            java.sql.Date ngayTaoSQL = new java.sql.Date(monHoc.getNgayTao().getTime());
//            pstmt.setDate(3, ngayTaoSQL
            pstmt.setInt(4, monHoc.getChuyenNganhID());
            int kq = pstmt.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) throws Exception {
        String sql = "delete from mon_hoc where [id] = ?";
        try ( Connection conn = DatabaseHelper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int kq = pstmt.executeUpdate();
            conn.close();
        }
        return 0;
    }
}
