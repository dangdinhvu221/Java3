/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from;

import Class.*;
import Service.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangd
 */
public class managmentUser extends javax.swing.JFrame {

    private QLMHService monHocDao;
    private DefaultTableModel tblModel;
    private List<MonHoc> listMH;
    private QLChuyenNganhService chuyenNganhDao;
    private List<ChuyenNganh> listCN;
    /**
     * Creates new form managmentUser
     */
    public managmentUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.monHocDao = new QLMHService();
        this.tblModel = (DefaultTableModel) this.tblShow.getModel();
        this.chuyenNganhDao = new QLChuyenNganhService();
        this.listMH = new ArrayList<>();
        this.listCN = new ArrayList<>();
        this.loadCbb();
    }

    private void loadCbb() {
        this.listCN = this.chuyenNganhDao.getAll();
        // xoá tất cả phần tử ở cbb
        this.cboChuyenNganh.removeAllItems();
        this.listCN.forEach(chuyenNganh -> {
            this.cboChuyenNganh.addItem(chuyenNganh.getTenChuyenNganh());
        });
    }

    private void fillTable(int id) {
        this.listMH = this.monHocDao.getAll(id);
        this.tblModel.setRowCount(0);
        this.listMH.forEach(monHoc -> {
            this.tblModel.addRow(new Object[]{monHoc.getMaMonHoc(), monHoc.getTenMonHoc(),
                monHoc.getNgayTao(), monHoc.getChuyenNganhID()});
        });
        this.tblModel.fireTableDataChanged();
    }

    public void them() {
        try {
            Date ngayTaoo = null;
            String maMH = txtMaMh.getText();
            String tenMH = txtTenMH.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                ngayTaoo = sdf.parse(txtNgayTao.getText());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Ko đúng định dạng");
                return;
            }
            int chuyenNganh = cboChuyenNganh.getSelectedIndex();
            ChuyenNganh cn = listCN.get(chuyenNganh);
            int chuyenNganhID = cn.getId();
            MonHoc mh = new MonHoc(0, maMH, tenMH, ngayTaoo, chuyenNganhID);
            monHocDao.insert(mh);
            JOptionPane.showMessageDialog(this, "okok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        Date ngayTaoo = null;
        int index = tblShow.getSelectedRow();
        MonHoc mh = listMH.get(index);
        mh.setMaMonHoc(txtMaMh.getText());
        mh.setTenMonHoc(txtTenMH.getText());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ngayTaoo = sdf.parse(txtNgayTao.getText());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ko đúng định dạng");
            return;
        }
        mh.setNgayTao(ngayTaoo);
        mh.setChuyenNganhID(cboChuyenNganh.getSelectedIndex());
        if(monHocDao.update(mh) == 0){
            JOptionPane.showMessageDialog(this, "okoko");
            return;
        }
    }

//    public void showw(int index) {
//        MonHoc mh = listMH.get(index);
//        txtMaMh.setText(mh.getMaMonHoc());
//        txtTenMH.setText(mh.getTenMonHoc());
//        txtNgayTao.setText(mh.getNgayTao() + "");
//        cboChuyenNganh.setSelectedItem(mh.getChuyenNganhID());
//    }
//
//    public void mouseClick() {
//        try {
//            index = this.tblShow.getSelectedRow();
//            showw(index);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        txtMaMh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        cboChuyenNganh = new javax.swing.JComboBox<>();
        lblChuyenNganh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Tên MH:");

        jLabel2.setText("Mã MH:");

        jLabel3.setText("Ngày tạo:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");

        btnLamMoi.setText("làm mới");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(txtNgayTao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ MH", "TÊN MH", "NGÀY TẠO", "CHUYÊN NGÀNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cboChuyenNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UDPM", "TKDH", "QTKD", "SPA" }));
        cboChuyenNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChuyenNganhActionPerformed(evt);
            }
        });

        lblChuyenNganh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblChuyenNganh.setText("Chuyên Ngành:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(cboChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lblChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cboChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void cboChuyenNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChuyenNganhActionPerformed
        // TODO add your handling code here:
        int viTri = cboChuyenNganh.getSelectedIndex();
        if (viTri == -1) {
            return;
        }
        ChuyenNganh cn = listCN.get(viTri);
        int id = cn.getId();
        lblChuyenNganh.setText(cboChuyenNganh.getSelectedItem() + "");
        this.fillTable(id);
    }//GEN-LAST:event_cboChuyenNganhActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowMouseClicked
        // TODO add your handling code here:
//        mouseClick();
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
            java.util.logging.Logger.getLogger(managmentUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managmentUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managmentUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managmentUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managmentUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChuyenNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChuyenNganh;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtMaMh;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}