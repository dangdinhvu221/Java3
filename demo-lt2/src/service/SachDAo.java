/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal4.Sach;
import jdbcUtill.jdbcUtill;

/**
 *
 * @author dangd
 */
public class SachDAo {

    public List<Sach> getAll(int id) {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.sach WHERE [danh_muc_id] = ?";
        try ( Connection conn = jdbcUtill.ketnoi();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setId(rs.getInt(1));
                s.setMaSach(rs.getString(2));
                s.setTenSach(rs.getString(3));
                s.setNgayNhap(rs.getDate(4));
                s.setSoLuong(rs.getInt(5));
                list.add(s);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Sach insert(Sach s) {
        String sql = "INSERT dbo.sach( ten_sach, ma_sach, ngay_nhap, so_luong, danh_muc_id) VALUES(?,?,?,?,?)";
        try ( Connection conn = jdbcUtill.ketnoi();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getTenSach());
            pstmt.setString(2, s.getMaSach());
            java.sql.Date ngayNhap = new java.sql.Date(s.getNgayNhap().getTime());
            pstmt.setDate(3, ngayNhap);
            pstmt.setInt(4, s.getSoLuong());
            pstmt.setInt(5, s.getDanhMucID());
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public int update(Sach s) {
        String sql = "UPDATE dbo.sach SET [ten_sach]=?, [ma_sach]=?, [ngay_nhap]=?, [so_luong] =? Where [id] = ?";
        try ( Connection conn = jdbcUtill.ketnoi();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, s.getTenSach());
            pstmt.setString(1, s.getMaSach());
            java.sql.Date ngayNhap = new java.sql.Date(s.getNgayNhap().getTime());
            pstmt.setDate(3, ngayNhap);
            pstmt.setInt(4, s.getSoLuong());
            pstmt.setInt(5, s.getId());
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM dbo.sach WHERE [id] = ?";
        try ( Connection conn = jdbcUtill.ketnoi();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
