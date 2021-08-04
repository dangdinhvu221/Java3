/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author dangd
 */
public class SanPham {
    private String maSP, tenSP, DVT, nhaCungCap;
    private double donGiaBan;

    public SanPham(String maSP, String tenSP, String DVT , double donGiaBan, String nhaCungCap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.DVT = DVT;
        this.nhaCungCap = nhaCungCap;
        this.donGiaBan = donGiaBan;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }
    
    
}
