/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import modal.baiViet;
import java.sql.*;
import jdbcUtil.ketnoi;

/**
 *
 * @author dangd
 */
public class BaiVietDao {

    public List<baiViet> getAll(int id) {
        List<baiViet> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.bai_viet WHERE [danh_muc_id] = ?";
        try ( Connection conn = ketnoi.kettnoijdbc();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                baiViet bv = new baiViet();
                bv.setId(rs.getInt(1));
                bv.setTieuDe(rs.getString(2));
                bv.setNoiDung(rs.getString(3));
                bv.setNgayTao(rs.getDate(4));
                bv.setDanhMucID(rs.getInt(5));
                list.add(bv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public baiViet insert(baiViet bv) {
        String sql = "INSERT dbo.bai_viet( tieu_de, noi_dung, ngay_tao, danh_muc_id) VALUES(?, ?, ?, ?)";
        try ( Connection conn = ketnoi.kettnoijdbc();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bv.getTieuDe());
            pstmt.setString(2, bv.getNoiDung());
            java.sql.Date ngayTaoSQL = new java.sql.Date(bv.getNgayTao().getTime());
            pstmt.setDate(3, ngayTaoSQL);
            pstmt.setInt(4, bv.getDanhMucID());

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bv;
    }

    public int Delete(int id) {
        String sql = "DELETE FROM dbo.bai_viet WHERE [id] = ?";
        try ( Connection conn = ketnoi.kettnoijdbc();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(baiViet bv) {
        String sql = "UPDATE dbo.bai_viet SET [tieu_de] = ?, [noi_dung] = ?, [ngay_tao] = ?, [danh_muc_id] = ? WHERE [id] = ?";
        try ( Connection conn = ketnoi.kettnoijdbc();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(5, bv.getId());
            pstmt.setString(1, bv.getTieuDe());
            pstmt.setString(2, bv.getNoiDung());
            java.sql.Date ngayTaoSQL = new java.sql.Date(bv.getNgayTao().getTime());
            pstmt.setDate(3, ngayTaoSQL);
            pstmt.setInt(4, bv.getDanhMucID());
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
