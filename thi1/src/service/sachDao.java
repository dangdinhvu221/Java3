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
import jdbcUtill.jdbcUtill;
import modal.Sach;
import modal.theLoai;

/**
 *
 * @author dangd
 */
public class sachDao {

    public List<Sach> getAll(String maTL) throws Exception {
        List<Sach> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.SACH  WHERE MaTheLoai = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maTL);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Sach s = new Sach();
            s.setMaS(rs.getString("Masach"));
            s.setTenS(rs.getString("TenSach"));
            s.setMaTL(rs.getString("MaTheLoai"));
            s.setNXB(rs.getString("NXB"));
            s.setSoLuong(rs.getInt("SoLuong"));
            s.setGiaTien(rs.getDouble("Giatien"));

            list.add(s);
        }
        return list;
    }

    public Sach insert(Sach s) throws Exception {
        String sql = "insert into SACH(Masach,TenSach,MaTheLoai,NXB,SoLuong,Giatien) values(?,?,?,?,?,?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, s.getMaS());
        pstmt.setString(2, s.getTenS());
        pstmt.setString(3, s.getMaTL());
        pstmt.setString(4, s.getNXB());
        pstmt.setInt(5, s.getSoLuong());
        pstmt.setDouble(6, s.getGiaTien());

        int kq = pstmt.executeUpdate();
        return s;
    }

    public void update(Sach s) throws Exception {
        String sql = "UPDATE dbo.SACH SET [TenSach] = ?, [NXB] = ?, [SoLuong] = ?, [Giatien] = ? WHERE [Masach] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(5, s.getMaS());
        pstmt.setString(1, s.getTenS());
        pstmt.setString(2, s.getNXB());
        pstmt.setInt(3, s.getSoLuong());
        pstmt.setDouble(4, s.getGiaTien());

        int kq = pstmt.executeUpdate();
    }

    public void delete(String maS) throws Exception {
        String sql = "DELETE FROM dbo.SACH WHERE [Masach] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maS);
        int kq = pstmt.executeUpdate();

    }

}
