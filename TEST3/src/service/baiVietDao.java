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
import modal.baiViet;

import modal.danhMuc;

/**
 *
 * @author dangd
 */
public class baiVietDao {

    public List<baiViet> getAll(int id) throws Exception {
        List<baiViet> list = new ArrayList<>();
        String sql = "SELECT*FROM dbo.bai_viet WHERE [danh_muc_id] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            baiViet bv = new baiViet();
            bv.setId(rs.getInt(1));
            bv.setTieuD(rs.getString(2));
            bv.setNoiD(rs.getString(3));
            bv.setNgayT(rs.getDate(4));
            bv.setDanhM(rs.getInt(5));

            list.add(bv);
        }
        conn.close();

        return list;
    }

    public baiViet insert(baiViet bv) throws Exception {

        String sql = "INSERT dbo.bai_viet( tieu_de, noi_dung, ngay_tao, danh_muc_id) VALUES(?, ?, ?, ?)";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, bv.getTieuD());
        ps.setString(2, bv.getNoiD());
        java.sql.Date ngayT = new java.sql.Date(bv.getNgayT().getTime());
        ps.setDate(3, ngayT);
        ps.setInt(4, bv.getDanhM());
        int kq = ps.executeUpdate();
        conn.close();
        return bv;
    }

    public int update(baiViet bv) throws Exception {

        String sql = "UPDATE dbo.bai_viet SET tieu_de = ?, noi_dung = ?, ngay_tao = ? WHERE [id] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, bv.getTieuD());
        ps.setString(2, bv.getNoiD());
        java.sql.Date ngayT = new java.sql.Date(bv.getNgayT().getTime());
        ps.setDate(3, ngayT);
        ps.setInt(4, bv.getId());

        int kq = ps.executeUpdate();
        conn.close();
        return 0;
    }

    public int delete(int id) throws Exception {

        String sql = "DELETE FROM dbo.bai_viet WHERE [id] = ?";
        Connection conn = jdbcUtill.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int kq = ps.executeUpdate();
        conn.close();
        return 0;
    }

}
