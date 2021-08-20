/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbcUtill.jdbcUtill;
import modal.SinhVien;
import modal.khoaNganh;

/**
 *
 * @author dangd
 */
public class SinhVienDao {

    public List<SinhVien> getAll(String maKN) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "select Masv,Hoten, DienThoai,email, MaKN from SINHVIEN  WHERE MaKN = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maKN);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            SinhVien sv = new SinhVien();
            sv.setMaSV(rs.getString("Masv"));
            sv.setTenSV(rs.getString("Hoten"));
            sv.setSDT(rs.getString("DienThoai"));
            sv.setEmail(rs.getString("email"));
            sv.setMaKN(rs.getString("MaKN"));

            list.add(sv);
        }
        conn.close();
        return list;
    }
    
    public List<SinhVien> getAll() throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "select Masv,Hoten, DienThoai,email, MaKN from SINHVIEN ";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            SinhVien sv = new SinhVien();
            sv.setMaSV(rs.getString("Masv"));
            sv.setTenSV(rs.getString("Hoten"));
            sv.setSDT(rs.getString("DienThoai"));
            sv.setEmail(rs.getString("email"));
            sv.setMaKN(rs.getString("MaKN"));

            list.add(sv);
        }
        conn.close();
        return list;
    }

    public SinhVien insert(SinhVien sv) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "insert into SINHVIEN(Masv,Hoten,DienThoai,email,MaKN) values(?,?,?,?,?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sv.getMaSV());
        pstmt.setString(2, sv.getTenSV());
        pstmt.setString(3, sv.getSDT());
        pstmt.setString(4, sv.getEmail());
        pstmt.setString(5, sv.getMaKN());
        
        pstmt.executeUpdate();

        conn.close();
        return sv;
    }
    
//    public void update(SinhVien sv) throws Exception {
//        List<SinhVien> list = new ArrayList<>();
//        String sql = "UPDATE dbo.SINHVIEN SET [Hoten] = ?, [DienThoai] = ?, [email] = ? WHERE [Masv] = ?";
//        Connection conn = jdbcUtill.ketNoi();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(4, sv.getMaSV());
//        pstmt.setString(1, sv.getTenSV());
//        pstmt.setString(2, sv.getSDT());
//        pstmt.setString(3, sv.getEmail());
//        
//        pstmt.executeUpdate();
//        conn.close();
//    }
//    
    public void delete(String maSV) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "DELETE FROM dbo.SINHVIEN WHERE [Masv] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maSV);
        
        pstmt.executeUpdate();
        conn.close();
    }
}
