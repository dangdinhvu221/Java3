/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import modal.STUDENT;
import Service.STUDENTDAO;
import messageHelper.MessageDialogHelper;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import validate.Validate;

/**
 *
 * @author dangd
 */
public class StudenManagmentPanel extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private List<STUDENT> list;
    private STUDENTDAO studentDao;
    private String Images = "";
    private ImageIcon img = new ImageIcon(getClass().getResource("/image/avatar-icon.png"));

    public StudenManagmentPanel() {
        initComponents();
        this.studentDao = new STUDENTDAO();
        this.list = new ArrayList<>();
        this.tblModel = (DefaultTableModel) this.tblShowData.getModel();
        this.titelTable();
        this.fillTable();

    }

    public void fillTable() {
        try {
            list = studentDao.FindByAll();
            tblModel.setRowCount(0);
            list.forEach(student -> {
                tblModel.addRow(new Object[]{student.getCodeStuden(), student.getFullname(), student.getEmail(),
                    student.getPhoneNumber(), student.getGender(), student.getAddress(), student.getImages()});
            });
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void New() {
        this.txtCodeStudent.setText("");
        this.txtFullname.setText("");
        this.txtEmail.setText("");
        this.txtPhoneNumber.setText("");
        this.rdoMale.setSelected(true);
        this.txtAddress.setText("");
        this.lblAvatar4.setIcon(this.img);
        lblAvatar4.setText("");

        this.txtCodeStudent.setBorder(new LineBorder(Color.WHITE));
        this.txtFullname.setBorder(new LineBorder(Color.WHITE));
        this.txtEmail.setBorder(new LineBorder(Color.WHITE));
        this.txtPhoneNumber.setBorder(new LineBorder(Color.WHITE));
        this.rdoMale.setBorder(new LineBorder(Color.WHITE));
        this.txtAddress.setBorder(new LineBorder(Color.WHITE));
    }

    public void showw(int index) {
        STUDENT student = list.get(index);
        this.txtCodeStudent.setText(student.getCodeStuden());
        this.txtFullname.setText(student.getFullname());
        this.txtEmail.setText(student.getEmail());
        this.txtPhoneNumber.setText(student.getPhoneNumber());
        this.txtAddress.setText(student.getAddress());
        this.lblAvatar4.setText(student.getImages());
        String role = (String) this.tblShowData.getValueAt(index, 6);
        String role1 = (String) this.tblShowData.getValueAt(index, 4);
        try {
            if (role1.equalsIgnoreCase("nam")) {
                this.rdoMale.setSelected(true);
            } else {
                this.rdoFemale.setSelected(true);
            }
            if (role.equalsIgnoreCase("No link avarta!!!!")) {
                this.lblAvatar4.setIcon(img);
            } else {
                ImageIcon imgIcon = new ImageIcon(getClass().getResource("/image/" + student.getImages()));
                this.lblAvatar4.setIcon(imgIcon);
            }
        } catch (Exception e) {
        }
    }

    public void mouseClick() {
        int row = this.tblShowData.getSelectedRow();
        this.showw(row);
    }

    public void titelTable() {
        this.tblModel.setColumnIdentifiers(new Object[]{
            "MÃ SINH VIÊN", "HỌ VÀ TÊN", "EMAIL", "SĐT", "GIỚI TÍNH", "ĐỊA CHỈ", "HÌNH"
        });
        this.tblShowData.setModel(this.tblModel);
    }

    public void insert() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent, sb, "Không được để trống mã Sinh Viên !!!");
        Validate.checkEmty(this.txtFullname, sb, "Không được để trống tên Sinh Viên !!!");
        Validate.checkEmty(this.txtEmail, sb, "Không được để trống email Sinh Viên !!!");
        Validate.checkEmty(this.txtPhoneNumber, sb, "Không được để trống sđt Sinh Viên !!!");
        Validate.checkEmail(this.txtEmail, sb);
        Validate.checkPhoneNumber(this.txtPhoneNumber, sb);
        try {
            if (Validate.checkTrungStudent(this.txtCodeStudent.getText()) == true) {
                sb.append("Trùng mã Sinh Viên");
                this.txtCodeStudent.setBorder(new LineBorder(Color.red));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        try {
            String gender = rdoMale.isSelected() ? "Nam" : "Nữ";
            STUDENT student = new STUDENT();
            student.setCodeStuden(this.txtCodeStudent.getText().toUpperCase());
            student.setFullname(this.txtFullname.getText().toUpperCase());
            student.setEmail(this.txtEmail.getText());
            student.setPhoneNumber(this.txtPhoneNumber.getText());
            student.setGender(gender);
            student.setAddress(txtAddress.getText());
            student.setImages(this.lblAvatar4.getText());
            if (this.Images.isEmpty()) {
                student.setImages("No link avarta!!!!");
                this.lblAvatar4.setIcon(img);
            } else {
                student.setImages(this.lblAvatar4.getText());
            }
            this.studentDao.Insert(student);
            JOptionPane.showMessageDialog(this, "Thêm vào databse thành công!!!");
            fillTable();
            New();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showMessageDialog(this, "Thêm vào database không thành công!!!", "Thông báo");
        }
    }

    public void update() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent, sb, "Không được để trống mã Sinh Viên !!!");
        Validate.checkEmail(this.txtEmail, sb);
        Validate.checkPhoneNumber(this.txtPhoneNumber, sb);
        try {
            if (Validate.checkTrungStudent(this.txtCodeStudent.getText()) == false) {
                sb.append("Không được sửa mã sinh viên!!!!");
                this.txtCodeStudent.setBorder(new LineBorder(Color.red));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error");
            return;
        }
        try {
            int chosse = MessageDialogHelper.showComfirmDialog(this, "bạn có muốn cập nhật hay ko!!!", "Hỏi");
            if (chosse == JOptionPane.YES_OPTION) {
                String gender = this.rdoMale.isSelected() ? "Nam" : "Nữ";
                STUDENT student = new STUDENT();
                student.setCodeStuden(this.txtCodeStudent.getText().toUpperCase());
                student.setFullname(this.txtFullname.getText());
                student.setEmail(this.txtEmail.getText());
                student.setPhoneNumber(this.txtPhoneNumber.getText());
                student.setGender(gender);
                student.setAddress(this.txtAddress.getText());
                student.setImages(lblAvatar4.getText());
                student.setImages(this.lblAvatar4.getText());
                if (this.studentDao.Update(student) == 0) {
                    MessageDialogHelper.showMessageDialog(this, "cập nhật vào databse thành công!!!", "Thông báo");
                    fillTable();
                    New();
                }
            } else {
                MessageDialogHelper.showErrorDialog(this, "ERROR!!!", "Thông báo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void delete() {
        StringBuilder sb = new StringBuilder();
        Validate.checkEmty(this.txtCodeStudent, sb, "Không được để trống mã Sinh Viên !!!");
        try {
            if (Validate.checkTrungStudent(this.txtCodeStudent.getText()) == false);
        } catch (Exception e) {
            sb.append("Không có mã sinh viên!!!!");
            e.printStackTrace();
        }
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Error!!!");
            return;
        }
        try {
            int chosse = MessageDialogHelper.showComfirmDialog(this, "bạn có muốn xóa hay ko!!!", "Hỏi");
            if (chosse == JOptionPane.YES_OPTION) {
                if (this.studentDao.Delete(this.txtCodeStudent.getText()) == 0) {
                    MessageDialogHelper.showMessageDialog(this, "Xóa thành công!!!!", "Thông báo!!");
                    fillTable();
                    New();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, "Xoá ko thành công!!!", "Thông báo!!");
        }
    }

    public void Avartar() {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fileName = new FileNameExtensionFilter("Hinh anh", ImageIO.getReaderFileSuffixes());
        jfc.setFileFilter(fileName);
        jfc.setMultiSelectionEnabled(false);

        int chosse = jfc.showOpenDialog(null);
        if (chosse == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            STUDENT student = new STUDENT();
            this.Images = file.getName();
            this.lblAvatar4.setText(this.Images);
            student.setImages(this.lblAvatar4.getText());
            this.lblAvatar4.setIcon(new ImageIcon(file.getAbsolutePath()));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodeStudent = new javax.swing.JTextField();
        txtFullname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lblAvatar4 = new javax.swing.JLabel();
        btnAvatar4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblShowData = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Student-3-icon.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("MÃ SINH VIÊN:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("HỌ VÀ TÊN:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("EMAIL:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("SỐ ĐIỆN THOẠI:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("GIỚI TÍNH:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("ĐỊA CHỈ:");

        txtCodeStudent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtFullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtPhoneNumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        buttonGroup1.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoMale.setSelected(true);
        rdoMale.setText("NAM");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoFemale.setText("NỮ");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));

        lblAvatar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/avatar-icon.png"))); // NOI18N

        btnAvatar4.setBackground(new java.awt.Color(0, 204, 153));
        btnAvatar4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAvatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/open-file-icon-16.png"))); // NOI18N
        btnAvatar4.setText("AVATAR");
        btnAvatar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar4, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAvatar4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNew.setBackground(new java.awt.Color(0, 204, 153));
        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new-icon-16.png"))); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 204, 153));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-icon.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 204, 153));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon-16.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 204, 153));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblShowData.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblShowData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SINH VIÊN", "HỌ VÀ TÊN", "EMAIL", "SỐ ĐIỆN THOẠI", "GIỚI TÍNH", "ĐỊA CHỈ", "HÌNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane4.setViewportView(tblShowData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addGap(18, 18, 18)
                                .addComponent(rdoFemale))
                            .addComponent(txtCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator3)))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodeStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvatar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar4ActionPerformed
        // TODO add your handling code here:
        this.Avartar();
    }//GEN-LAST:event_btnAvatar4ActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.New();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowDataMouseClicked
        // TODO add your handling code here:
        this.mouseClick();
    }//GEN-LAST:event_tblShowDataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvatar4;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAvatar4;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblShowData;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCodeStudent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
