/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Color;

/**
 *
 * @author dangd
 */
public class BAI1 extends javax.swing.JFrame {

    /**
     * Creates new form BAI1
     */
    public BAI1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRed = new javax.swing.JButton();
        btnGreen = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCenter = new javax.swing.JButton();
        btnSouth = new javax.swing.JButton();
        btnNorth = new javax.swing.JButton();
        btnWest = new javax.swing.JButton();
        btnEast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtComment = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 30));

        btnRed.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRed.setForeground(new java.awt.Color(255, 0, 0));
        btnRed.setText("Red");
        btnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedActionPerformed(evt);
            }
        });
        jPanel1.add(btnRed);

        btnGreen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnGreen.setForeground(new java.awt.Color(51, 255, 51));
        btnGreen.setText("Green");
        btnGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGreenActionPerformed(evt);
            }
        });
        jPanel1.add(btnGreen);

        btnYellow.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnYellow.setForeground(new java.awt.Color(255, 255, 0));
        btnYellow.setText("Yellow");
        btnYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYellowActionPerformed(evt);
            }
        });
        jPanel1.add(btnYellow);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        btnCenter.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCenter.setText("Center");
        jPanel2.add(btnCenter, java.awt.BorderLayout.CENTER);

        btnSouth.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSouth.setText("South");
        jPanel2.add(btnSouth, java.awt.BorderLayout.PAGE_END);

        btnNorth.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnNorth.setText("North");
        jPanel2.add(btnNorth, java.awt.BorderLayout.PAGE_START);

        btnWest.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnWest.setText("West");
        jPanel2.add(btnWest, java.awt.BorderLayout.LINE_START);

        btnEast.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEast.setText("East");
        jPanel2.add(btnEast, java.awt.BorderLayout.LINE_END);

        txtComment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtComment.setForeground(new java.awt.Color(0, 153, 0));
        txtComment.setText("CHÀO CÁC BẠN SINH VIÊN FPT - POLYTECHNIC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtComment, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtComment, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));
        jPanel4.setLayout(new java.awt.GridLayout(2, 5, 5, 5));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton1);

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton2);

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton3);

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton4);

        jButton5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton5);

        jButton6.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton6);

        jButton7.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton7);

        jButton8.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton8);

        jButton9.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton9);

        jButton10.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.add(jButton10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedActionPerformed
        // TODO add your handling code here:
        jPanel1.setBackground(Color.RED);
    }//GEN-LAST:event_btnRedActionPerformed

    private void btnGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGreenActionPerformed
        // TODO add your handling code here:
        jPanel1.setBackground(Color.GREEN);
    }//GEN-LAST:event_btnGreenActionPerformed

    private void btnYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYellowActionPerformed
        // TODO add your handling code here:
        jPanel1.setBackground(Color.YELLOW);
    }//GEN-LAST:event_btnYellowActionPerformed

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
            java.util.logging.Logger.getLogger(BAI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BAI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BAI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BAI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BAI1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCenter;
    private javax.swing.JButton btnEast;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnNorth;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnSouth;
    private javax.swing.JButton btnWest;
    private javax.swing.JButton btnYellow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtComment;
    // End of variables declaration//GEN-END:variables
}
