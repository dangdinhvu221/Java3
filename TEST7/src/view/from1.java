/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modal.SinhVien;
import modal.khoaNganh;
import service.SinhVienDao;
import service.khoaNganhDao;

/**
 *
 * @author dangd
 */
public class from1 extends javax.swing.JFrame {

    List<SinhVien> listSV;
    List<khoaNganh> listKN;
    int index = 0;
    khoaNganhDao nganhDao;
    SinhVienDao sinhVienDao;
    from2 f1;

  

    /**
     * Creates new form from1
     */
    public from1(String masv, String hoten, String makn, String email) {
        initComponents();
        setLocationRelativeTo(null);
        listKN = new ArrayList<>();
        listSV = new ArrayList<>();
        nganhDao = new khoaNganhDao();
        sinhVienDao = new SinhVienDao();
        loadcbo();
        TXTHT.setText(hoten);
        TXTEMAIL.setText(email);
        TXTMASV.setText(masv);
        CBOKN.setSelectedItem(makn);
        f1 = new from2();
        f1.setVisible(true);
    }

    public void loadcbo() {
        try {
            listKN = nganhDao.getAll();
            CBOKN.removeAllItems();
            for (khoaNganh kn : listKN) {
                CBOKN.addItem(kn.getMaKN());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkTrung(String maSV) {
        try {
            listSV = sinhVienDao.getAll();
            for (int i = 0; i < listSV.size(); i++) {
                if (listSV.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void them() {
        if (checkTrung(TXTMASV.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trung ma!!!");
            return;
        }
        if (TXTHT.getText().isEmpty() || TXTMASV.getText().isEmpty() || TXTEMAIL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko dc de trong!!!");
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSV(TXTMASV.getText());
            sv.setHoTen(TXTHT.getText());
            sv.setEmail(TXTEMAIL.getText());
            sv.setMaKN(CBOKN.getSelectedItem() + "");
            sinhVienDao.insert(sv);
            JOptionPane.showMessageDialog(this, "them thanh cong!!!");
            new from2().setVisible(true);
            f1.dispose();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "them ko thanh cong!!!");
            return;
        }
    }

    public void sua() {
        if (checkTrung(TXTMASV.getText()) == false) {
            JOptionPane.showMessageDialog(this, "ko dc sua ma!!!");
            return;
        }
        if (TXTHT.getText().isEmpty() || TXTMASV.getText().isEmpty() || TXTEMAIL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko dc de trong!!!");
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSV(TXTMASV.getText());
            sv.setHoTen(TXTHT.getText());
            sv.setEmail(TXTEMAIL.getText());
            sv.setMaKN(CBOKN.getSelectedItem() + "");
            sinhVienDao.update(sv);
            JOptionPane.showMessageDialog(this, "sua thanh cong!!!");
            new from2().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "sua ko thanh cong!!!");
            return;
        }
    }

    public void xoa() {
        if (TXTMASV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko dc de trong!!!");
            return;
        }
        try {
            sinhVienDao.delete(TXTMASV.getText());
            JOptionPane.showMessageDialog(this, "xoa thanh cong!!!");
            from2 f = new from2();
            f.fillTable();
            lammoi();        // TODO add your handling code here:
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "xoa ko thanh cong!!!");
            return;
        }
    }

    public void lammoi() {
        TXTHT.setText("");
        TXTEMAIL.setText("");
        TXTMASV.setText("");
        CBOKN.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXTMASV = new javax.swing.JTextField();
        TXTHT = new javax.swing.JTextField();
        TXTEMAIL = new javax.swing.JTextField();
        CBOKN = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MASV");

        jLabel2.setText("HOTEN");

        jLabel3.setText("EMAIL");

        jLabel4.setText("MAKN");

        TXTHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTHTActionPerformed(evt);
            }
        });

        CBOKN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("THEM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SUA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("XOA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBOKN, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTMASV, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTHT, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTMASV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TXTHT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)))
                .addGap(15, 15, 15)
                .addComponent(jButton3)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXTEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CBOKN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTHTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        them();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sua();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xoa();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        lammoi();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(from1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(from1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(from1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(from1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new from1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOKN;
    private javax.swing.JTextField TXTEMAIL;
    private javax.swing.JTextField TXTHT;
    private javax.swing.JTextField TXTMASV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
