/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.SinhVien;
import jdbc.jdbcUtill;

/**
 *
 * @author dangd
 */
public class SinhVienDao {

    public List<SinhVien> getAll(String maKN) {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "select * from SINHVIEN  WHERE MaKN = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maKN);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("Masv"));
                sv.setTenSV(rs.getString("Hoten"));
                sv.setSdt(rs.getString("DienThoai"));
                sv.setEmail(rs.getString("email"));
                sv.setMaKN(rs.getString("MaKN"));

                list.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SinhVien insert(SinhVien sv) {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "insert into SINHVIEN(Masv,Hoten,DienThoai,email,MaKN) values(?,?,?,?,?)";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getSdt());
            pstmt.setString(4, sv.getEmail());
            pstmt.setString(5, sv.getMaKN());

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }
    
    public void delete(SinhVien sv) {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "DELETE FROM dbo.SINHVIEN WHERE [Masv] = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
