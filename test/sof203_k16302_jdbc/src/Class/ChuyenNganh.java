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
public class ChuyenNganh {
    private int id;
    private String tenChuyenNganh;

    public ChuyenNganh() {
    }

    public ChuyenNganh(int id, String tenChuyenNganh) {
        this.id = id;
        this.tenChuyenNganh = tenChuyenNganh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }
    
    
}
