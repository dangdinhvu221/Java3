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
import jdbc.jdbcUtill;
import modal.Classs;
import modal.sinhVien;

/**
 *
 * @author dangd
 */
public class sinhVienDao {

    public List<sinhVien> getAll(String maKN) {
        List<sinhVien> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.STUDENT WHERE [IDClass] = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maKN);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sinhVien sv = new sinhVien();
                sv.setMaSV(rs.getString("Masv"));
                sv.setTenSV(rs.getString("Hoten"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setKhoaNganh(rs.getString("Khoanganh"));
                sv.setClass(rs.getString("IDClass"));
                list.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public sinhVien insert(sinhVien sv) {
        try {
            String sql = "insert into STUDENT(Masv,Hoten,gioitinh,Khoanganh, IDClass) VALUES (?,?,?,?,?)";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getGioiTinh());
            pstmt.setString(4, sv.getKhoaNganh());
            pstmt.setString(5, sv.getClasss());

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }

    public void delete(sinhVien sv) {
        try {
            String sql = "DELETE FROM dbo.STUDENT WHERE [Masv] = ?";
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
