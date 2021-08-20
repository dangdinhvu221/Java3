/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.Date;

/**
 *
 * @author dangd
 */
public class SinhVien {
    private String maSV, hoTen, khoaNganh, gioiTinh, idClass;
    private Date ngaySinh;

    public SinhVien() {
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoaNganh() {
        return khoaNganh;
    }

    public void setKhoaNganh(String khoaNganh) {
        this.khoaNganh = khoaNganh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    
}
