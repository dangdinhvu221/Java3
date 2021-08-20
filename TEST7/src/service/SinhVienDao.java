/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal.khoaNganh;
import jdbcUtill.jdbcUtill;
import modal.SinhVien;

/**
 *
 * @author dangd
 */
public class SinhVienDao {

    public List<SinhVien> getAll() throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "select * from SINHVIEN JOIN dbo.KHOANGANH ON KHOANGANH.MaKN = SINHVIEN.MaKN";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            SinhVien sv = new SinhVien();
            sv.setMaSV(rs.getString("Masv"));
            sv.setHoTen(rs.getString("Hoten"));
            sv.setMaKN(rs.getString("MaKN"));
            sv.setTenKN(rs.getString("TenKN"));
            sv.setEmail(rs.getString("email"));

            list.add(sv);
        }
        return list;
    }

    public SinhVien insert(SinhVien sv) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "insert into SINHVIEN(Masv,Hoten,email,MaKN) values(?,?,?,?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sv.getMaSV());
        pstmt.setString(2, sv.getHoTen());
        pstmt.setString(3, sv.getEmail());
        pstmt.setString(4, sv.getMaKN());

        int kq = pstmt.executeUpdate();
        return sv;
    }
    
     public void delete(String maSV) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "DELETE FROM dbo.SINHVIEN WHERE [Masv] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maSV);

        int kq = pstmt.executeUpdate();
    }
     
      public void update(SinhVien sv) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "UPDATE dbo.SINHVIEN SET [Hoten] = ?, [email] = ? WHERE [Masv] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(3, sv.getMaSV());
        pstmt.setString(1, sv.getHoTen());
        pstmt.setString(2, sv.getEmail());

        int kq = pstmt.executeUpdate();
    }
}
