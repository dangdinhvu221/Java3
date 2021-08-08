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
public class BaiViet {

    private int id;
    private String tieuDe, noiDung;
    private Date ngayTao;
    private int danhMucID;

    public BaiViet() {
    }

    public BaiViet(int id, String tieuDe, String noiDung, Date ngayTao, int danhMucID) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.danhMucID = danhMucID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getDanhMucID() {
        return danhMucID;
    }

    public void setDanhMucID(int danhMucID) {
        this.danhMucID = danhMucID;
    }

}
