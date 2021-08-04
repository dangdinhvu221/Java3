/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from;

import Service.STUDENTDAO;
import Service.GRADEDAO;
import Class.*;
import messageHelper.MessageDialogHelper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import validate.Validate;

/**
 *
 * @author dangd
 */
public class GRADEManagmentPanel extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private GRADEDAO gradeDao;
    private List<GRADE> list;
    private int index = 0;

    /**
     * Creates new form GRADEManagmentPanel
     */
    public GRADEManagmentPanel() {
        initComponents();
        this.titelTable();
        this.tblModel = (DefaultTableModel) this.tblShowData.getModel();
        this.list = new ArrayList<>();
        this.gradeDao = new GRADEDAO();
        this.fillTable();

    }

    public void titelTable() {
        this.tblModel = new DefaultTableModel();
        this.tblModel.setColumnIdentifiers(
                new Object[]{"MÃ SINH VIÊN", "HỌ VÀ TÊN", "TIẾNG ANH", "TIN HỌC", "GIÁO DỤC TC", "ĐIỂM TRUNG BÌNH"
                });
        this.tblShowData.setModel(this.tblModel);
    }

    public void fillTable() {
        this.list = this.gradeDao.FinTop(3);
        this.tblModel.setRowCount(0);
        this.list.forEach(grade -> {
            this.tblModel.addRow(new Object[]{
                grade.getCodeStudent(), grade.getFullName(), grade.getEnglish(), grade.getInformationtics(), grade.getGDTC(),
                (grade.getEnglish() + grade.getInformationtics() + grade.getGDTC()) / 3});
        });
        this.tblModel.fireTableDataChanged();
    }

    public void Save() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent1, sb, "Không được để trống mã Sinh Viên!!!");
        Validate.checkEmty(this.txtEnglish, sb, "Không được để trống điểm Tiếng Anh!!!");
        Validate.checkEmty(this.txtInformationtics, sb, "Không được để trống điểm Tin Học!!!");
        Validate.checkEmty(this.txtGDTC, sb, "Không được để trống điểm Giáo Dục TC!!!");
        Validate.checkPoin(this.txtEnglish, sb);
        Validate.checkPoin(this.txtInformationtics, sb);
        Validate.checkPoin(this.txtGDTC, sb);
        try {
            if (Validate.checkTrungGrade(this.txtCodeStudent1.getText()) == true) {
                sb.append("Trùng mã Sinh Viên");
                txtCodeStudent.setBorder(new LineBorder(Color.red));
            }
        } catch (Exception e) {
        }
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        GRADE grade = new GRADE();
        grade.setCodeStudent(this.txtCodeStudent1.getText());
        grade.setFullName(this.lblFullname.getText());
        grade.setEnglish(Float.parseFloat(this.txtEnglish.getText()));
        grade.setInformationtics(Float.parseFloat(this.txtInformationtics.getText()));
        grade.setGDTC(Float.parseFloat(this.txtGDTC.getText()));
        grade.setAvg(Float.parseFloat(this.lblDiemTB.getText()));
        this.gradeDao.Insert(grade);
        fillTable();
        JOptionPane.showMessageDialog(this, "thêm dữ liệu vào database thành công");
        New();
    }

    public void Update() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent1, sb, "Không được để trống mã Sinh Viên!!!");
        if (Validate.checkTrungGrade(txtCodeStudent1.getText()) == false) {
            MessageDialogHelper.showErrorDialog(this, "Không được sửa mã!!!", "Error");
        }

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        int chosse = MessageDialogHelper.showComfirmDialog(this, "bạn có muốn xóa hay ko!!!", "Hỏi");
        if (chosse == JOptionPane.YES_OPTION) {

            GRADE grade = new GRADE();
            grade.setCodeStudent(this.txtCodeStudent1.getText());
            grade.setFullName(this.lblFullname.getText());
            grade.setEnglish(Float.parseFloat(this.txtEnglish.getText()));
            grade.setInformationtics(Float.parseFloat(this.txtInformationtics.getText()));
            grade.setGDTC(Float.parseFloat(this.txtGDTC.getText()));
            grade.setAvg(Float.parseFloat(this.lblDiemTB.getText()));
            if (this.gradeDao.Update(grade) == 0) {
                MessageDialogHelper.showMessageDialog(this, "cập nhật vào databse thành công!!!", "Thông báo");
                fillTable();
                New();
            }
        } else {
            MessageDialogHelper.showErrorDialog(this, "Cập nhật ko thành công!!", "ERROR");
        }
    }

    public void Delete() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent1, sb, "Không được để trống mã Sinh Viên!!!");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        try {
            int chosse = MessageDialogHelper.showComfirmDialog(this, "bạn có muốn xóa hay ko!!!", "Hỏi");
            if (chosse == JOptionPane.YES_OPTION) {
                if (this.gradeDao.Delete(this.txtCodeStudent1.getText()) == 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!!!!");
                    this.fillTable();
                    this.New();
                }
            } else {
                MessageDialogHelper.showErrorDialog(this, "Xoá ko thành công!!!", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Error");
        }
    }

    public void New() {
        this.txtCodeStudent1.setText("");
        this.txtEnglish.setText("");
        this.txtInformationtics.setText("");
        this.txtGDTC.setText("");
        this.lblDiemTB.setText("0.0");
        this.lblFullname.setText("");

        this.txtCodeStudent1.setBorder(new LineBorder(Color.WHITE));
        this.txtEnglish.setBorder(new LineBorder(Color.WHITE));
        this.txtInformationtics.setBorder(new LineBorder(Color.WHITE));
        this.txtGDTC.setBorder(new LineBorder(Color.WHITE));
    }

    public void Find() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent, sb, "Không được để trống mã Sinh Viên!!!");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        String codeID = this.txtCodeStudent.getText();
        try {
            STUDENTDAO studentdao = new STUDENTDAO();
            GRADE grade = this.gradeDao.FindID(codeID);
            STUDENT st = studentdao.FindByID(codeID);
            int i;
            if (grade != null) {
                MessageDialogHelper.showMessageDialog(this, "Hiển thị thông tin sinh viên", "Thông báo");
                for (i = 0; i < this.list.size(); i++) {
                    if (this.list.get(i).getCodeStudent().equalsIgnoreCase(codeID)) {
                        this.showw(i);
                        this.tblShowData.setRowSelectionInterval(i, i);
                    }
                }
            } else if (studentdao.FindByID(codeID) != null) {
                this.lblFullname.setText(st.getFullname());
                this.txtCodeStudent1.setText(st.getFullname());
                this.txtEnglish.setText("0");
                this.txtGDTC.setText("0");
                this.txtInformationtics.setText("0");
                MessageDialogHelper.showMessageDialog(this, "sinh viên chưa có điểm", "Thông báo");
            } else {
                MessageDialogHelper.showErrorDialog(this, "Không có mã Sinh viên này!!!", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Error");
        }
    }

    public void showw(int index) {
        GRADE grade = list.get(index);
        this.txtCodeStudent1.setText(grade.getCodeStudent());
        this.lblFullname.setText(grade.getFullName());
        this.txtEnglish.setText(grade.getEnglish() + "");
        this.txtInformationtics.setText(grade.getInformationtics() + "");
        this.txtGDTC.setText(grade.getGDTC() + "");
        this.lblDiemTB.setText(String.format("%.2f", grade.getAvg()));
    }

    public void mouseClick() {
        try {
            index = this.tblShowData.getSelectedRow();
            showw(index);
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodeStudent = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodeStudent1 = new javax.swing.JTextField();
        txtEnglish = new javax.swing.JTextField();
        txtInformationtics = new javax.swing.JTextField();
        txtGDTC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblDiemTB = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShowData = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gpa-icon-64.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("TÌM KIẾM:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("MÃ SINH VIÊN:");

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-32.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(txtCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("HỌ TÊN SINH VIÊN:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("MÃ SINH VIÊN:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("TIẾNG ANH:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("TIN HỌC:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("GIÁO DỤC TC:");

        txtCodeStudent1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodeStudent1FocusLost(evt);
            }
        });

        txtEnglish.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEnglishFocusLost(evt);
            }
        });

        txtInformationtics.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInformationticsFocusLost(evt);
            }
        });

        txtGDTC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGDTCFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("ĐIỂM TB:");

        lblDiemTB.setFont(new java.awt.Font("Times New Roman", 1, 55)); // NOI18N
        lblDiemTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiemTB.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblFullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblFullnameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCodeStudent1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInformationtics, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEnglish, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodeStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInformationtics, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new-icon-16.png"))); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-icon.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon-16.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-First-icon-48.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-backward-icon-48.png"))); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-forward-icon-48.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Last-icon-48.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("3 SINH VIÊN CÓ ĐIỂM CAO NHẤT:");

        tblShowData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowDataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblShowData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1)))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.New();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.Save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        this.Update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        this.Delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowDataMouseClicked
        // TODO add your handling code here:
        this.mouseClick();
    }//GEN-LAST:event_tblShowDataMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        this.Find();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        this.showw(this.index);
        this.tblShowData.setRowSelectionInterval(this.index, this.index);
    }//GEN-LAST:event_btnFirstActionPerformed
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            if (this.index > 0) {
                this.index--;
                this.showw(this.index);
                this.tblShowData.setRowSelectionInterval(this.index, this.index);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            if (this.index < this.list.size()) {
                this.index++;
                this.showw(this.index);
                this.tblShowData.setRowSelectionInterval(this.index, this.index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        try {
            this.index = list.size() - 1;
            this.showw(this.index);
            this.tblShowData.setRowSelectionInterval(this.index, this.index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtCodeStudent1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeStudent1FocusLost
//         TODO add your handling code here:
        try {
            STUDENTDAO studentdao = new STUDENTDAO();
            STUDENT sv = studentdao.FindByID(this.txtCodeStudent1.getText());
            if (sv != null) {
                this.lblFullname.setText(sv.getFullname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtCodeStudent1FocusLost

    private void txtEnglishFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnglishFocusLost
        // TODO add your handling code here:
        this.AVG();
    }//GEN-LAST:event_txtEnglishFocusLost

    private void txtGDTCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGDTCFocusLost
        // TODO add your handling code here:
        this.AVG();
    }//GEN-LAST:event_txtGDTCFocusLost

    private void txtInformationticsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInformationticsFocusLost
        // TODO add your handling code here:
        this.AVG();
    }//GEN-LAST:event_txtInformationticsFocusLost

    private void lblFullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblFullnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFullnameFocusLost
    public void AVG() {
        if (txtEnglish.getText().isEmpty() || txtInformationtics.getText().isEmpty() || txtGDTC.getText().isEmpty()) {
            return;
        } else {
            float english = Float.parseFloat(txtEnglish.getText());
            float informationtics = Float.parseFloat(txtInformationtics.getText());
            float GDTC = Float.parseFloat(txtGDTC.getText());
            float avg = (english + informationtics + GDTC) / 3;
            String st = String.format("%.2f", avg);
            this.lblDiemTB.setText(st);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JTable tblShowData;
    private javax.swing.JTextField txtCodeStudent;
    private javax.swing.JTextField txtCodeStudent1;
    private javax.swing.JTextField txtEnglish;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtInformationtics;
    // End of variables declaration//GEN-END:variables
}
