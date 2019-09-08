/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app;

import com.kesequl.app.entity.Admin;
import com.kesequl.app.entity.Tu;
import com.kesequl.app.entity.User;
import com.kesequl.app.network.Client;
import com.kesequl.app.network.KesequlHttpCallback;
import com.kesequl.app.network.KesequlHttpRequest;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user65
 */
public final class KelolaTU extends javax.swing.JFrame {
    private static final long serialVersionUID = 7903221809928432190L;

    private final User user;
    private final Admin admin;
    
    private final List<Tu> listTU = new ArrayList<>();
    
    private boolean editMode = false;
    private Tu editEntity = null;
    
    private Runnable parentRunnable;
    /**
     * Creates new form TambahTu
     * @param user
     * @param admin
     */
    public KelolaTU(User user, Admin admin, Runnable parentRunnable) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/icon_kesequl.png")).getImage());
        
        this.user = user;
        this.admin = admin;
        this.parentRunnable = parentRunnable;
        
        btnRefreshActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_jk = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNip = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbL = new javax.swing.JRadioButton();
        rbP = new javax.swing.JRadioButton();
        txtLahir = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtGambar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBan = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TU");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIP", "Username", "Email", "Nama", "Gender", "Tanggal Lahir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nama");

        jLabel7.setText("NIP");

        jLabel9.setText("Gender");

        jLabel11.setText("Tanggal Lahir");

        jLabel2.setText(":");

        jLabel3.setText(":");

        jLabel5.setText(":");

        jLabel6.setText(":");

        txtNip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNipKeyTyped(evt);
            }
        });

        rbL.setBackground(new java.awt.Color(255, 255, 255));
        rb_jk.add(rbL);
        rbL.setSelected(true);
        rbL.setText("L");

        rbP.setBackground(new java.awt.Color(255, 255, 255));
        rb_jk.add(rbP);
        rbP.setText("P");

        txtLahir.setDateFormatString("dd-MM-yyyy");

        jLabel16.setText("Email");

        jLabel19.setText(":");

        jLabel13.setText("Username");

        jLabel15.setText("Password");

        jLabel18.setText(":");

        jLabel17.setText(":");

        txtGambar.setEditable(false);

        jButton1.setText("Gambar");

        jLabel20.setText("Foto Profile");

        jLabel21.setText(":");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama)
                            .addComponent(txtNip)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbL)
                                .addGap(18, 18, 18)
                                .addComponent(rbP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 269, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsername))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(txtNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(rbL)
                    .addComponent(rbP))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBan.setText("Ban");
        btnBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanActionPerformed(evt);
            }
        });

        btnNext.setText("->");

        btnPrev.setText("<-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTambah))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnRefresh)
                    .addComponent(btnPrev))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBan))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        btnRefresh.setEnabled(false);
        
        KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.GET);
        req.setUrl("admin/alltu?token=" + user.getToken());
        Client.executeConnectionList(req, Tu.class, new KesequlHttpCallback<List<Tu>>() {
            @Override
            public void onSuccess(int status, String pesan, List<Tu> data) {
                if (!Client.isTokenExpired(KelolaTU.this, status, user)) {
                    if (status == 1) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setNumRows(0);

                        listTU.clear();
                        listTU.addAll(data);

                        if (listTU != null) {
                            listTU.forEach(tu -> {
                                model.addRow(new Object[] {
                                    tu.getNip(),
                                    tu.getUser().getUsername(),
                                    tu.getUser().getEmail(),
                                    tu.getNama(),
                                    tu.getGender() == 'L' ? "Laki-Laki" : "Perempuan",
                                    tu.getTtl().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                                });
                            });
                        }
                        table.setModel(model);
                    }
                }
                
            }

            @Override
            public void onFailed(Exception ex) {
                JOptionPane.showMessageDialog(KelolaTU.this, ex.getMessage());
            }

            @Override
            public void onDone() {
                if (parentRunnable != null) {
                    parentRunnable.run();
                    parentRunnable = null;
                }
                btnRefresh.setEnabled(true);
            }
        });
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nip = txtNip.getText().trim();
        String nama = txtNama.getText().trim();
        String gender = rbL.isSelected() ? "L" : "P";
        String tanggal_lahir = txtLahir.getDate() != null ? LocalDate.parse(DateFormat.getDateInstance(DateFormat.SHORT).format(txtLahir.getDate()), DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)).toString() : "";
        String email = txtEmail.getText().trim();
        String username = txtUsername.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();
        
        if (nip.isEmpty() || nama.isEmpty() || gender.isEmpty() || tanggal_lahir.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak boleh ada inputan yang kosong");
            return;
        }
        
        KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
        req.setUrl("tu/tambahtu?token=" + user.getToken());
        req.setVal(
                "nip=" + nip +
                "&nama=" + nama + 
                "&gender=" + gender + 
                "&tanggal_lahir=" + tanggal_lahir + 
                "&email=" + email + 
                "&username=" + username + 
                "&password=" + password
        );
        Client.executeConnection(req, null, new KesequlHttpCallback() {
            @Override
            public void onPrepare() {
                btnTambah.setEnabled(false);
            }
            @Override
            public void onSuccess(int status, String pesan, Object data) {
                if (!Client.isTokenExpired(KelolaTU.this, status, user)) {
                    if (status == 1) {
                        btnTambah.setEnabled(true);
                        btnRefreshActionPerformed(evt);
                        
                        txtNip.setText("");
                        txtNama.setText("");
                        rbL.setSelected(true);
                        txtLahir.setDate(null);
                        txtEmail.setText("");
                        txtUsername.setText("");
                        txtPassword.setText("");
                    }
                    
                    JOptionPane.showMessageDialog(KelolaTU.this, pesan);
                }
            }

            @Override
            public void onFailed(Exception ex) {
                JOptionPane.showMessageDialog(KelolaTU.this, ex);
            }
            
            @Override
            public void onDone() {
                btnTambah.setEnabled(true);
                btnRefreshActionPerformed(evt);
            }
        });
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtNipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNipKeyTyped
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_txtNipKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (!editMode) {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Mau Diedit");
                return;
            }
            
            Tu tuS = listTU.get(row);

            editMode = true;
            editEntity = tuS;
            
            txtNama.setText(tuS.getNama());
            txtNip.setText(String.valueOf(tuS.getNip()));
            // Harus dikurangi 1900, karena library Date otomatis menambahkan 1900
            txtLahir.setDate(new Date(tuS.getTtl().getYear() - 1900, tuS.getTtl().getMonthValue(), tuS.getTtl().getDayOfMonth()));
            rbL.setSelected(tuS.getGender() == 'L');
            txtUsername.setText(tuS.getUser().getUsername());
            txtEmail.setText(tuS.getUser().getEmail());
        } else {
            String nip = txtNip.getText().trim();
            String nama = txtNama.getText().trim();
            String gender = rbL.isSelected() ? "L" : "P";
            String tanggal_lahir = txtLahir.getDate() != null ? LocalDate.parse(DateFormat.getDateInstance(DateFormat.SHORT).format(txtLahir.getDate()), DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)).toString() : "";
            String email = txtEmail.getText().trim();
            String username = txtUsername.getText().trim();
            String password = String.valueOf(txtPassword.getPassword()).trim();
            
            if (nip.isEmpty() || nama.isEmpty() || gender.isEmpty() || tanggal_lahir.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tidak boleh ada inputan yang kosong");
                return;
            }
            
            KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
            req.setUrl("tu/edittu?token=" + user.getToken());
            req.setVal(
                "id_user=" + editEntity.getUser().getIdUser() +
                "&nip=" + nip +
                "&nama=" + nama + 
                "&gender=" + gender + 
                "&tanggal_lahir=" + tanggal_lahir + 
                "&email=" + email + 
                "&username=" + username + 
                "&password=" + password
            );
            
            Client.executeConnection(req, null, new KesequlHttpCallback() {
                @Override
                public void onSuccess(int status, String pesan, Object data) {
                    if (!Client.isTokenExpired(KelolaTU.this, status, user)) {
                        if (status == 1) {
                            editMode = false;
                            editEntity = null;
                            
                            txtNip.setText("");
                            txtNama.setText("");
                            rbL.setSelected(true);
                            txtLahir.setDate(null);
                            txtEmail.setText("");
                            txtUsername.setText("");
                            txtPassword.setText("");
                        }
                        JOptionPane.showMessageDialog(KelolaTU.this, pesan);
                    }
                }

                @Override
                public void onFailed(Exception ex) {
                    JOptionPane.showMessageDialog(KelolaTU.this, ex.getMessage());
                }
                
                @Override
                public void onDone() {
                    btnRefresh.setEnabled(!editMode);
                    btnBan.setEnabled(!editMode);
                    btnTambah.setEnabled(!editMode);
                    btnEdit.setText(!editMode ? "Edit" : "Terapkan");
                    btnHapus.setEnabled(!editMode);
                    
                    btnRefreshActionPerformed(evt);
                }
            });
        }
        
        btnRefresh.setEnabled(!editMode);
        btnBan.setEnabled(!editMode);
        btnTambah.setEnabled(!editMode);
        btnEdit.setText(!editMode ? "Edit" : "Terapkan");
        btnHapus.setEnabled(!editMode);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Mau Diedit");
            return;
        }

        Tu tuS = listTU.get(row);
        
        if (JOptionPane.showConfirmDialog(this, "Yakin ingin dihapus ?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            btnHapus.setEnabled(false);
            KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
            req.setUrl("tu/hapustu?token=" + user.getToken());
            req.setVal("id_user=" + tuS.getUser().getIdUser());
            
            Client.executeConnection(req, null, new KesequlHttpCallback() {
                @Override
                public void onSuccess(int status, String pesan, Object data) {
                    if (!Client.isTokenExpired(KelolaTU.this, status, user))
                        JOptionPane.showMessageDialog(KelolaTU.this, pesan);
                }

                @Override
                public void onFailed(Exception ex) {
                    JOptionPane.showMessageDialog(KelolaTU.this, ex.getMessage());
                }
                
                @Override
                public void onDone() {
                    btnHapus.setEnabled(true);
                    btnRefreshActionPerformed(evt);
                }
            });
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Mau Diedit");
            return;
        }

        Tu tuS = listTU.get(row);
        
        String reason = JOptionPane.showInputDialog(this, "Masukan Alasan Ban");
        if (reason != null) {
            btnBan.setEnabled(false);
            
            KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
            req.setUrl("user/ban?token=" + user.getToken());
            req.setVal("id_user=" + tuS.getUser().getIdUser() + "&reason_ban=" + reason);
            
            Client.executeConnection(req, null, new KesequlHttpCallback() {
                @Override
                public void onSuccess(int status, String pesan, Object data) {
                    if (!Client.isTokenExpired(KelolaTU.this, status, user))
                        JOptionPane.showMessageDialog(KelolaTU.this, pesan);
                }

                @Override
                public void onFailed(Exception ex) {
                    JOptionPane.showMessageDialog(KelolaTU.this, ex.getMessage());
                }
                
                @Override
                public void onDone() {
                    btnBan.setEnabled(true);
                    btnRefreshActionPerformed(evt);
                }
            });
        }
    }//GEN-LAST:event_btnBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBan;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbL;
    private javax.swing.JRadioButton rbP;
    private javax.swing.ButtonGroup rb_jk;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGambar;
    private com.toedter.calendar.JDateChooser txtLahir;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNip;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
