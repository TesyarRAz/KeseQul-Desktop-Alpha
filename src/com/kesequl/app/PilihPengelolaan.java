/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app;

import com.kesequl.app.entity.Peran;
import com.kesequl.app.entity.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user65
 */
public final class PilihPengelolaan extends javax.swing.JFrame implements Runnable {

    private static final long serialVersionUID = 3832638279994197418L;

    private JFrame frameUtama = null;
    
    /**
     * Creates new form PilihPengelolaan
     * @param user
     */
    public PilihPengelolaan(User user) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/icon_kesequl.png")).getImage());
        
        boolean valid = false;
        for (Peran peran : user.getPerans()) {
            
            if (peran.getNamaLevel().toLowerCase().equals("admin") || peran.getNamaLevel().toLowerCase().equals("superadmin") || peran.getNamaLevel().toLowerCase().equals("tu")) {
                valid = true;
            }
            
            if (user.getPerans().size() == 1) {
                if (peran.getNamaLevel().toLowerCase().equals("admin") || peran.getNamaLevel().toLowerCase().equals("superadmin")) {
                    frameUtama = new PengelolaanAdmin(user, this);
                } else if (peran.getNamaLevel().toLowerCase().equals("tu")) {
                    frameUtama = new PengelolaanTU(user, this);
                }
                
                break;
            } else {
                JButton button = new JButton(peran.getNamaLevel().charAt(0) + peran.getNamaLevel().substring(1));
                button.addActionListener(e -> {
                    JFrame frame = null;
                    if (peran.getNamaLevel().toLowerCase().equals("admin")) {
                        frame = new PengelolaanAdmin(user, PilihPengelolaan.this);
                    } else if (peran.getNamaLevel().toLowerCase().equals("tu")) {
                        frame = new PengelolaanTU(user, PilihPengelolaan.this);
                    }
                    
                    if (frame != null) {
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
                
                jPanel1.add(button);
            }
        }
        
        if (!valid) {
            JOptionPane.showMessageDialog(PilihPengelolaan.this, "Anda bukan admin atau superadmin");
            System.exit(0);
        }
    }
    
    @Override
    public void run() {
        if (frameUtama != null) {
            frameUtama.setLocationRelativeTo(null);
            frameUtama.setVisible(true);
            
            dispose();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
