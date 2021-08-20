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
import modal.theLoai;
import service.sachDao;
import service.theLoaiDao;

/**
 *
 * @author dangd
 */
public class from1 extends javax.swing.JFrame {

    List<Sach> listS;
    List<theLoai> listTL;
    DefaultTableModel tblModal;
    sachDao sD;
    theLoaiDao tlDao;
    int index = 0;

    /**
     * Creates new form from1
     */
    public from1() {
        initComponents();
        setLocationRelativeTo(null);
        sD = new sachDao();
        tlDao = new theLoaiDao();
        listTL = new ArrayList<>();
        listS = new ArrayList<>();
        tblModal = (DefaultTableModel) tblShow.getModel();
        loadCbo();
    }

    public void loadCbo() {
        try {
            listTL = tlDao.getAll();
            jComboBox1.removeAllItems();
            for (theLoai tl : listTL) {
                jComboBox1.addItem(tl.getMaTL());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillTable(String maTL) {
        try {
            listS = sD.getAll(maTL);
            tblModal.setRowCount(0);
            for (Sach sach : listS) {
                tblModal.addRow(new Object[]{sach.getMaS(), sach.getTenS(), sach.getMaTL(), sach.getNXB(), sach.getSoLuong(), sach.getGiaTien()});
            }
            tblModal.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseeClick() {
        index = tblShow.getSelectedRow();
        txtmaS.setText(tblShow.getValueAt(index, 0).toString());
        txtTens.setText(tblShow.getValueAt(index, 1).toString());
        txtNXB.setText(tblShow.getValueAt(index, 3).toString());
        txtSL.setText(tblShow.getValueAt(index, 4).toString());
        txtGiaT.setText(tblShow.getValueAt(index, 5).toString());
    }

    public boolean checkTrung(String maS) {
        try {
            for (int i = 0; i < listS.size(); i++) {
                if (listS.get(i).getMaS().equalsIgnoreCase(maS)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void save() {
        if (checkTrung(txtmaS.getText()) == true) {
            JOptionPane.showMessageDialog(this, "TRung ma", "hoi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtGiaT.getText().isEmpty() || txtSL.getText().isEmpty() || txtNXB.getText().isEmpty() || txtmaS.getText().isEmpty() || txtTens.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko duoc de trong!!!", "hoi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Sach s = new Sach();
            s.setMaS(txtmaS.getText());
            s.setTenS(txtTens.getText());
            s.setMaTL(jComboBox1.getSelectedItem() + "");
            s.setNXB(txtNXB.getText());
            s.setSoLuong(Integer.parseInt(txtSL.getText()));
            s.setGiaTien(Double.parseDouble(txtGiaT.getText()));

            sD.insert(s);
            JOptionPane.showMessageDialog(this, "them thanh cong!!!");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (checkTrung(txtmaS.getText()) == false) {
            JOptionPane.showMessageDialog(this, "ko dc sua ma!!!", "hoi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtGiaT.getText().isEmpty() || txtSL.getText().isEmpty() || txtNXB.getText().isEmpty() || txtmaS.getText().isEmpty() || txtTens.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko duoc de trong!!!", "hoi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Sach s = new Sach();
            s.setMaS(txtmaS.getText());
            s.setTenS(txtTens.getText());
            s.setMaTL(jComboBox1.getSelectedItem() + "");
            s.setNXB(txtNXB.getText());
            s.setSoLuong(Integer.parseInt(txtSL.getText()));
            s.setGiaTien(Double.parseDouble(txtGiaT.getText()));

            sD.insert(s);
            JOptionPane.showMessageDialog(this, "them thanh cong!!!");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        if (txtmaS.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko duoc de trong!!!", "hoi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            sD.delete(txtmaS.getText());
            JOptionPane.showMessageDialog(this, "them thanh cong!!!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        txtGiaT.setText("");
        txtNXB.setText("");
        txtTens.setText("");
        txtGiaT.setText("");
        txtSL.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmaS = new javax.swing.JTextField();
        txtTens = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        txtGiaT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        lbl.setText("jLabel1");

        jLabel2.setText("thể loại:");

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma sách", "tên sách", "Mã TL", "NXB", "So Lượng", "Giá tiền"
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

        jLabel7.setText("Giá tiền");

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTens, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtmaS, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaT, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmaS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTens, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();        // TODO add your handling code here:
        fillTable(jComboBox1.getSelectedItem() + "");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        save();
        fillTable(jComboBox1.getSelectedItem() + "");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete();
        fillTable(jComboBox1.getSelectedItem() + "");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String maTL = jComboBox1.getSelectedItem() + "";
        fillTable(maTL);
        index = jComboBox1.getSelectedIndex();
        if (index == -1) {
            return;
        } else {
            theLoai tl = listTL.get(index);
            String TL = tl.getTenTL();
            lbl.setText(TL);
        }
        if (listS.isEmpty()) {
            return;
        } else {
            index = 0;
            tblShow.setRowSelectionInterval(index, index);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowMouseClicked
        mouseeClick();        // TODO add your handling code here:
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
                new from1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtGiaT;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTens;
    private javax.swing.JTextField txtmaS;
    // End of variables declaration//GEN-END:variables
}
