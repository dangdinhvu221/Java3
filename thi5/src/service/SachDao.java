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
import modal.Sach;
import modal.TheLoai;

/**
 *
 * @author dangd
 */
public class SachDao {

    public List<Sach> getAll(String maTL) {
        List<Sach> list = new ArrayList<>();
        try {
            String sql = "SELECT*FROM dbo.SACH JOIN dbo.THELOAI ON THELOAI.MaTheLoai = SACH.MaTheLoai WHERE SACH.MaTheLoai = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maTL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaS(rs.getString("Masach"));
                s.setTenS(rs.getString("TenSach"));
                s.setMaTL(rs.getString("MaTheLoai"));
                s.setNxb(rs.getString("NXB"));
                s.setSoL(rs.getInt("SoLuong"));
                s.setGiaT(rs.getDouble("Giatien"));
                list.add(s);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Sach s) {
        List<Sach> list = new ArrayList<>();
        try {
            String sql = "UPDATE dbo.SACH SET [TenSach] = ?, [NXB] = ?, [SoLuong] = ?, [Giatien] = ? WHERE [Masach] = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, s.getMaS());
            pstmt.setString(1, s.getTenS());
            pstmt.setString(2, s.getNxb());
            pstmt.setInt(3, s.getSoL());
            pstmt.setDouble(4, s.getGiaT());

            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Sach s) {
        List<Sach> list = new ArrayList<>();
        try {
            String sql = "DELETE FROM dbo.SACH WHERE [Masach] = ?";
            Connection conn = jdbcUtill.ketnoi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s.getMaS());
            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
