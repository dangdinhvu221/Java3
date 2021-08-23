/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modal.Sach;
import modal.TheLoai;
import service.SachDao;
import service.theLoaiDao;

/**
 *
 * @author dangd
 */
public class NewJFrame extends javax.swing.JFrame {

    DefaultTableModel tblModal;
    List<Sach> listS;
    List<TheLoai> listTL;
    SachDao sD;
    theLoaiDao thLoaiDao;
    int index = 0;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tblModal = (DefaultTableModel) tblShow.getModel();
        listTL = new ArrayList<>();
        listS = new ArrayList<>();
        sD = new SachDao();
        thLoaiDao = new theLoaiDao();
        loadCbo();
    }

    public void loadCbo() {
        cboTheL.removeAllItems();
        listTL = thLoaiDao.getAll();
        for (TheLoai tl : listTL) {
            cboTheL.addItem(tl.getMaTL());
        }
    }

    public void fillTable(String maKN) {
        tblModal.setRowCount(0);
        listS = sD.getAll(maKN);
        for (Sach sach : listS) {
            tblModal.addRow(new Object[]{sach.getMaS(), sach.getTenS(), sach.getMaTL(), sach.getNxb(), sach.getSoL(), sach.getGiaT()});
        }
        tblModal.fireTableDataChanged();
    }

    public void clear() {
        txtMaS.setText("");
        txtTenS.setText("");
        txtNXB.setText("");
        txtSoL.setText("");
        txtGiaT.setText("");
    }

    public void mouseClick() {
        index = tblShow.getSelectedRow();
        Sach s = listS.get(index);
        txtMaS.setText(s.getMaS());
        txtTenS.setText(s.getTenS());
        txtNXB.setText(s.getNxb());
        txtSoL.setText(s.getSoL() + "");
        txtGiaT.setText(s.getGiaT() + "");
    }

    public boolean checkTrung(String maS) {
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMaS().equalsIgnoreCase(maS)) {
                return true;
            }
        }
        return false;
    }

    public void insert() {
        if (checkTrung(txtMaS.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trùng mã sách!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtMaS.getText().isEmpty() || txtTenS.getText().isEmpty() || txtNXB.getText().isEmpty() || txtSoL.getText().isEmpty() || txtGiaT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Sach s = new Sach();
            s.setMaS(txtMaS.getText());
            s.setTenS(txtTenS.getText());
            s.setMaTL(cboTheL.getSelectedItem() + "");
            s.setNxb(txtNXB.getText());
            try {
                if (Double.parseDouble(txtGiaT.getText()) > 0 && Integer.parseInt(txtSoL.getText()) > 0) {
                    s.setSoL(Integer.parseInt(txtSoL.getText()));
                    s.setGiaT(Double.parseDouble(txtGiaT.getText()));
                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng hoặc giá tiền phải lớn hơn 0!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số lượng hoặc giá tiền sai định dạng!!!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            sD.insert(s);
            JOptionPane.showMessageDialog(this, "thêm thành công !!!!");
            fillTable(cboTheL.getSelectedItem() + "");

            clear();
        }

    }

    public void update() {
        if (checkTrung(txtMaS.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được sửa mã sách!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtMaS.getText().isEmpty() || txtTenS.getText().isEmpty() || txtNXB.getText().isEmpty() || txtSoL.getText().isEmpty() || txtGiaT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Sach s = new Sach();
            s.setMaS(txtMaS.getText());
            s.setTenS(txtTenS.getText());
            s.setNxb(txtNXB.getText());
            s.setSoL(Integer.parseInt(txtSoL.getText()));
            s.setGiaT(Double.parseDouble(txtGiaT.getText()));
            sD.update(s);
            JOptionPane.showMessageDialog(this, "Sửa thành công !!!!");
            fillTable(cboTheL.getSelectedItem() + "");

            clear();
        }
    }

    public void delete() {
        index = tblShow.getSelectedRow();
        if (txtMaS.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (index == -1) {
            return;
        } else {
            Sach s = listS.get(index);
            s.setMaS(txtMaS.getText());
            sD.delete(s);
            JOptionPane.showMessageDialog(this, "Xoá thành công !!!!");
            fillTable(cboTheL.getSelectedItem() + "");

            clear();
        }
    }

    public void close() {
        System.exit(0);
    }

    public void cboClick() {
        fillTable(cboTheL.getSelectedItem() + "");
        index = cboTheL.getSelectedIndex();
        if (index == -1) {
            return;
        } else {
            TheLoai tl = listTL.get(index);
            lblTL.setText(tl.getTenTL());
        }
        if (listS.isEmpty()) {
            return;
        } else {
            tblShow.setRowSelectionInterval(0, 0);
            mouseClick();
        }
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
        cboTheL = new javax.swing.JComboBox<>();
        lblTL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaS = new javax.swing.JTextField();
        txtTenS = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtSoL = new javax.swing.JTextField();
        txtGiaT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Thể loại:");

        cboTheL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTheL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTheLActionPerformed(evt);
            }
        });

        lblTL.setText("jLabel2");

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Mã thể loại", "NXB", "Số lượng", "Giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jLabel3.setText("Mã sách:");

        jLabel4.setText("Tên sách:");

        jLabel5.setText("NXB:");

        jLabel6.setText("Số lượng:");

        jLabel7.setText("Giá tiền:");

        jButton1.setText("SAVE");
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

        jButton4.setText("CLOSE");
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

        jButton5.setText("NEW");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(cboTheL, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblTL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTheL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTheLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTheLActionPerformed
        cboClick();        // TODO add your handling code here:
    }//GEN-LAST:event_cboTheLActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insert();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        close();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
    }//GEN-LAST:event_jButton4MouseClicked

    private void tblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowMouseClicked
        mouseClick();        // TODO add your handling code here:
        // TODO add your handling code here:
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
    private javax.swing.JComboBox<String> cboTheL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTL;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtGiaT;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSoL;
    private javax.swing.JTextField txtTenS;
    // End of variables declaration//GEN-END:variables
}
