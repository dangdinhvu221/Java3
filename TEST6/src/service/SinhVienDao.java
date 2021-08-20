/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modal.SinhVien;
import jdbcUtill.jdbcUtill;
import modal.ClassCBO;
import modal.User;

/**
 *
 * @author dangd
 */
public class SinhVienDao {

    public List<ClassCBO> getAllCl() {
        List<ClassCBO> list = new ArrayList<>();
        String sql = "select * from dbo.Class";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ClassCBO cl = new ClassCBO();
                cl.setIDClass(rs.getString("IDClass"));
                list.add(cl);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getAll(String id) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.STUDENT WHERE [IDClass] = ?";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("Masv"));
                sv.setHoTen(rs.getString("Hoten"));
                sv.setKhoaNganh(rs.getString("Khoanganh"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setNgaySinh(rs.getDate("Ngaysinh"));
                list.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SinhVien insert(SinhVien sv) {
        String sql = "insert into STUDENT(Masv,Hoten,Khoanganh,gioitinh,Ngaysinh,IDClass) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setString(3, sv.getKhoaNganh());
            pstmt.setString(4, sv.getGioiTinh());
            java.sql.Date ngaySinh = new java.sql.Date(sv.getNgaySinh().getTime());
            pstmt.setDate(5, ngaySinh);
            pstmt.setString(6, sv.getIdClass());

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }

    public int update(SinhVien sv) {
        String sql = "UPDATE dbo.STUDENT SET [Hoten] = ?, [gioitinh] = ?, [Ngaysinh] = ? WHERE [Masv] = ?";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, sv.getMaSV());
            pstmt.setString(1, sv.getHoTen());
            pstmt.setString(2, sv.getGioiTinh());
            java.sql.Date ngaySinh = new java.sql.Date(sv.getNgaySinh().getTime());
            pstmt.setDate(3, ngaySinh);

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String maSV) {
        String sql = "DELETE FROM dbo.STUDENT WHERE [Masv] = ?";
        try {
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSV);

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
