/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jdbcUtill.jdbcUtill;
import modal.Sach;

/**
 *
 * @author dangd
 */
public class SachDao {

    public List<Sach> getAll(String code) throws Exception {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.SACH  WHERE [MaTheLoai] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, code);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Sach s = new Sach();
            s.setMaS(rs.getString("Masach"));
            s.setTenS(rs.getString("TenSach"));
            s.setNgayNhap(rs.getDate("NgayNhap"));
            s.setNxb(rs.getString("NXB"));
            s.setMaTL(rs.getString("MaTheLoai"));
            list.add(s);
        }
        conn.close();
        return list;
    }

    public Sach insert(Sach s) throws Exception {
        String sql = "insert into SACH(Masach, TenSach, NgayNhap, NXB, MaTheLoai) VALUES(?,?,?,?,?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, s.getMaS());
        pstmt.setString(2, s.getTenS());
        java.sql.Date ngayNh = new java.sql.Date(s.getNgayNhap().getTime());
        pstmt.setDate(3, ngayNh);
        pstmt.setString(4, s.getNxb());
        pstmt.setString(5, s.getMaTL());

        int kq = pstmt.executeUpdate();
        conn.close();
        return s;
    }
    
    public int update(Sach s) throws Exception {
        String sql = "UPDATE dbo.SACH SET  [TenSach] = ?, [NgayNhap] = ?, [NXB] = ? WHERE [Masach] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(4, s.getMaS());
        pstmt.setString(1, s.getTenS());
        java.sql.Date ngayNh = new java.sql.Date(s.getNgayNhap().getTime());
        pstmt.setDate(2, ngayNh);
        pstmt.setString(3, s.getNxb());

        int kq = pstmt.executeUpdate();
        conn.close();
        return 0;
    }
    
    public int delete(String code) throws Exception {
        String sql = "DELETE FROM dbo.SACH WHERE [Masach] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, code);

        int kq = pstmt.executeUpdate();
        conn.close();
        return 0;
    }
}
