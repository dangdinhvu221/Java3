/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal4;

import java.util.Date;

/**
 *
 * @author dangd
 */
public class Sach {
    private int id, danhMucID, soLuong;
    private String maSach, tenSach;
    private Date ngayNhap;

    public Sach() {
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDanhMucID() {
        return danhMucID;
    }

    public void setDanhMucID(int danhMucID) {
        this.danhMucID = danhMucID;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    
}
