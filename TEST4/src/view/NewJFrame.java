/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modal.Sach;
import modal.theLoai;
import service.SachDao;
import service.theLoaiDao;

/**
 *
 * @author dangd
 */
public class NewJFrame extends javax.swing.JFrame {

    List<theLoai> listTL;
    List<Sach> listS;
    SachDao sD;
    theLoaiDao loaiDao;
    DefaultTableModel tblModel;
    int index = 0;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tblModel = (DefaultTableModel) tblShow.getModel();
        listS = new ArrayList<>();
        listTL = new ArrayList<>();
        sD = new SachDao();
        loaiDao = new theLoaiDao();
        loadCBO();
    }

    public void loadCBO() {
        try {
            listTL = loaiDao.getAll();
            cboTL.removeAllItems();
            for (theLoai loai : listTL) {
                cboTL.addItem(loai.getMaTL());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillTable(String code) {
        try {
            listS = sD.getAll(code);
            tblModel.setRowCount(0);
            for (Sach s : listS) {
                tblModel.addRow(new Object[]{s.getTenS(), s.getMaS(), s.getNxb(), s.getNgayNhap(), s.getMaTL()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkTRung(String code) {
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMaS().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void them() {
        if (checkTRung(txtMaS.getText()) == true) {
            JOptionPane.showMessageDialog(this, "trung ma !!!!");
            return;
        }
        if (txtMaS.getText().isEmpty() || txtTenS.getText().isEmpty() || txtNXB.getText().isEmpty() || txtNgayNh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko dc de trong!!!!");
            return;
        }
        try {
            Date ngayNh = null;
            Sach s = new Sach();
            s.setTenS(txtTenS.getText());
            s.setMaS(txtMaS.getText());
            s.setNxb(txtNXB.getText());
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ngayNh = sdf.parse(txtNgayNh.getText());
                s.setNgayNhap(ngayNh);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ko đúng định dạng!!!!");
                e.printStackTrace();
                return;
            }
            s.setMaTL(cboTL.getSelectedItem() + "");
            sD.insert(s);
            fillTable(cboTL.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "thêm không thành công");
            lamMoi();
            return;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sua() {
        if (txtMaS.getText().isEmpty() || txtTenS.getText().isEmpty() || txtNXB.getText().isEmpty() || txtNgayNh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko dc de trong!!!!");
            return;
        }
        try {
            Date ngayNh = null;
//            index = tblShow.getSelectedRow();
            Sach s = new Sach();
            s.setTenS(txtTenS.getText());
            s.setMaS(txtMaS.getText());
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ngayNh = sdf.parse(txtNgayNh.getText());
                s.setNgayNhap(ngayNh);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ko đúng định dạng!!!!");
                e.printStackTrace();
                return;
            }
            s.setNxb(txtNXB.getText());

            if (sD.update(s) == 0) {
                JOptionPane.showMessageDialog(this, "sửa không thành công");
                fillTable(cboTL.getSelectedItem() + "");
                lamMoi();

                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoa() {
        try {
//            Date ngayNh = null;
//            index = tblShow.getSelectedRow();
//            Sach s = listS.get(index);
//            String maS = s.getMaS();
            if (sD.delete(txtMaS.getText()) == 0) {
                JOptionPane.showMessageDialog(this, "xoá  thành công");
                fillTable(cboTL.getSelectedItem() + "");
                lamMoi();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lamMoi() {
        txtTenS.setText("");
        txtMaS.setText("");
        txtNXB.setText("");
        txtNgayNh.setText("");
    }

    public void mouseClick() {
        index = tblShow.getSelectedRow();
        txtTenS.setText(tblShow.getValueAt(index, 0).toString());
        txtMaS.setText(tblShow.getValueAt(index, 1).toString());
        txtNXB.setText(tblShow.getValueAt(index, 2).toString());
        txtNgayNh.setText(tblShow.getValueAt(index, 3).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTL = new javax.swing.JComboBox<>();
        lbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenS = new javax.swing.JTextField();
        txtMaS = new javax.swing.JTextField();
        txtNgayNh = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboTL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTLActionPerformed(evt);
            }
        });

        lbl.setText("jLabel1");

        jLabel2.setText("TÊN SACH:");

        jLabel3.setText("MÃ SÁCH:");

        jLabel4.setText("NGÀY NHẬP");

        jLabel5.setText("NXB");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLEAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayNh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(43, 43, 43))
        );

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÊN SÁCH", "MÃ SÁCH", "NXB", "NGÀY NHẬP", "MÃ THỂ LOẠI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(cboTL, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTL, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sua();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xoa();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtTenS.setText("");
        txtMaS.setText("");
        txtNXB.setText("");
        txtNgayNh.setText("");     // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
    }//GEN-LAST:event_jButton4MouseClicked

    private void cboTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTLActionPerformed
//        // TODO add your handling code here:
        fillTable(cboTL.getSelectedItem() + "");
        lbl.setText(cboTL.getSelectedItem() + "");
    }//GEN-LAST:event_cboTLActionPerformed

    private void tblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowMouseClicked
        // TODO add your handling code here:
        mouseClick();
    }//GEN-LAST:event_tblShowMouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboTL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNgayNh;
    private javax.swing.JTextField txtTenS;
    // End of variables declaration//GEN-END:variables
}
