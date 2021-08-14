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
public class baiViet {
    private int id;
    private String tieuD, noiD;
    private Date ngayT;
    private int danhM;

    public baiViet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuD() {
        return tieuD;
    }

    public void setTieuD(String tieuD) {
        this.tieuD = tieuD;
    }

    public String getNoiD() {
        return noiD;
    }

    public void setNoiD(String noiD) {
        this.noiD = noiD;
    }

    public Date getNgayT() {
        return ngayT;
    }

    public void setNgayT(Date ngayT) {
        this.ngayT = ngayT;
    }

    public int getDanhM() {
        return danhM;
    }

    public void setDanhM(int danhM) {
        this.danhM = danhM;
    }
    
    
}
