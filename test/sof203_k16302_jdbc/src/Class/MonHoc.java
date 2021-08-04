/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author dangd
 */
public class MonHoc {

    private int id;
    private String tenMonHoc, maMonHoc;
    private String ngayTao;
    private int chuyenNganhID;

    public MonHoc(int id, String maMonHoc, String tenMonHoc, String ngayTao, int chuyenNganhID) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.ngayTao = ngayTao;
        this.chuyenNganhID = chuyenNganhID;
    }

    public MonHoc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getChuyenNganhID() {
        return chuyenNganhID;
    }

    public void setChuyenNganhID(int chuyenNganhID) {
        this.chuyenNganhID = chuyenNganhID;
    }

}
