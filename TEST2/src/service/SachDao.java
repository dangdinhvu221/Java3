/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import modal.Sach;
import modal.danhMuc;
import java.sql.*;
import jdbcUtill.jdbcUtill;

/**
 *
 * @author dangd
 */
public class SachDao {

    public List<Sach> getAll(int id) throws Exception {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.sach WHERE danh_muc_id = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Sach s = new Sach();
            s.setId(rs.getInt(1));
            s.setMaS(rs.getString(2));
            s.setTenS(rs.getString(3));
            s.setNgayNh(rs.getDate(4));
            s.setSoL(rs.getInt(5));
            list.add(s);
        }
        conn.close();

        return list;
    }

    public Sach insert(Sach s) throws Exception {
        String sql = "INSERT INTO dbo.sach(ten_sach, ma_sach, ngay_nhap, so_luong, danh_muc_id) VALUES (?,?,?,?,?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, s.getMaS());
        pstmt.setString(2, s.getTenS());
        java.sql.Date ngayNhap = new java.sql.Date(s.getNgayNh().getTime());
        pstmt.setDate(3, ngayNhap);
        pstmt.setInt(4, s.getSoL());
        pstmt.setInt(5, s.getDanhMucID());
        int kq = pstmt.executeUpdate();

        conn.close();
        return s;
    }

    public int update(Sach s) throws Exception {
        String sql = "UPDATE dbo.sach SET [ma_sach] = ?, [ten_sach] = ?, [ngay_nhap] = ?, [so_luong] = ? WHERE [id] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, s.getMaS());
        pstmt.setString(2, s.getTenS());
        java.sql.Date ngayNhap = new java.sql.Date(s.getNgayNh().getTime());
        pstmt.setDate(3, ngayNhap);
        pstmt.setInt(4, s.getSoL());
        pstmt.setInt(5, s.getId());
        int kq = pstmt.executeUpdate();

        conn.close();
        return 0;
    }

    public int delete(int id) throws Exception {
        String sql = "DELETE FROM dbo.sach WHERE [id] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int kq = pstmt.executeUpdate();
        conn.close();
        return 0;
    }
}
