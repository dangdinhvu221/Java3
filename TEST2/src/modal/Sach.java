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
public class Sach {
    private int id;
    private String tenS, maS;
    private Date ngayNh;
    private int soL, danhMucID;

    public Sach() {
    }

    public int getDanhMucID() {
        return danhMucID;
    }

    public void setDanhMucID(int danhMucID) {
        this.danhMucID = danhMucID;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public Date getNgayNh() {
        return ngayNh;
    }

    public void setNgayNh(Date ngayNh) {
        this.ngayNh = ngayNh;
    }

    public int getSoL() {
        return soL;
    }

    public void setSoL(int soL) {
        this.soL = soL;
    }
    
    
}
