/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import jdbcUtill.jdbcUtill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal.KhoaNganh;
import modal.SinhVien;

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
                SinhVien kn = new SinhVien();
                kn.setMaSV(rs.getString("Masv"));
                kn.setTenSV(rs.getString("Hoten"));
                kn.setSdt(rs.getString("DienThoai"));
                kn.setEmail(rs.getString("email"));
                kn.setMaKN(rs.getString("MaKN"));
                list.add(kn);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "select * from SINHVIEN";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SinhVien kn = new SinhVien();
                kn.setMaSV(rs.getString("Masv"));
                kn.setTenSV(rs.getString("Hoten"));
                kn.setSdt(rs.getString("DienThoai"));
                kn.setEmail(rs.getString("email"));
                kn.setMaKN(rs.getString("MaKN"));
                list.add(kn);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SinhVien insert(SinhVien kn) {
        try {
            String sql = "insert into SINHVIEN(Masv,Hoten,DienThoai,email,MaKN) values(?,?,?,?,?)";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kn.getMaSV());
            pstmt.setString(2, kn.getTenSV());
            pstmt.setString(3, kn.getSdt());
            pstmt.setString(4, kn.getEmail());
            pstmt.setString(5, kn.getMaKN());

            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kn;
    }

    public void delete(String maSV) {
        try {
            String sql = "DELETE FROM dbo.SINHVIEN WHERE [Masv] = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSV);

            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
