package com.styleattribute.ganiban_s;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_MainFrame extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Admin_MainFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
            pstmt = con.prepareStatement("select * from customers_details");
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel mytable = (DefaultTableModel) jTable1.getModel();
            int rowCount = mytable.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                mytable.removeRow(i);
                ResultSetMetaData rsdm = rs.getMetaData();
                while (rs.next()) {
                    mytable.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
                }
                jTable1.setModel(mytable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ganiban Management Software");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Details of Ganiban Housing Society . LTD");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Flat No", "Floor No", "Building Wing", "Flat Status", "Name of the Owner", "Name of the Renter", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Search Field :");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Name of the Owner :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Flat Status :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Select Status","Owned","Rented","Empty"}));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Name of the Renter :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Mobile Number :");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Name of the Owner :");

        jTextField4.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setText("Building Wing :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Select Wing","Shop","A","B","C"}));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("New Customer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Billing");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Export Details");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Add User");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Manage Users");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Income");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem7.setText("Expenses");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setText("Manage Income & Expenses");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Close");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1539, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(128, 128, 128)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Admin_Export().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new Admin_Income().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void multiple_Delete() {
        int row = jTable1.getSelectedRowCount();
        int i = 0;
        int a = JOptionPane.showConfirmDialog(null, "Do you Want to Delete Customer's Data ?");
        for (i = 0; i <= row - 1; i++) {
            if (a == 0) {
                try {
                    String flat_no = jTable1.getValueAt(i, 0).toString();
                    pstmt = con.prepareStatement("delete from customers_details where Flat_No=?");
                    pstmt.setString(1, flat_no);
                    int j = pstmt.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            pstmt = con.prepareStatement("select * from customers_details");
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
            int rowCount = aModel.getRowCount();
            for (int m = rowCount - 1; m >= 0; m--) {
                aModel.removeRow(m);
            }
            while (rs.next()) {
                aModel.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
            }
            jTable1.setModel(aModel);
            jTextField7.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jComboBox1.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Data removed Successfully!!!");
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String Build = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String Flat_Status = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String Name = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String Name_R = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
        String Mobile_Number = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();

        jTextField7.setText(Name);
        jComboBox1.setSelectedItem(Flat_Status);
        jTextField2.setText(Name_R);
        jTextField3.setText(Mobile_Number);
        jComboBox2.setSelectedItem(Build);

        if (Name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select the Data you Want to Delete");
        } else {
            jTextField4.setText(Name);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (evt.getActionCommand().equals("Search") && jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please type in the input section to search");
            return;
        }
        if (evt.getActionCommand().equals("Search")) {
            try {
                pstmt = con.prepareStatement("select * from customers_details where Flat_No like '%" + jTextField1.getText() + "%' or Name_of_the_Owner like '%" + jTextField1.getText() + "%' or Mobile_Number like '%" + jTextField1.getText() + "%'or Floor_No like '%" + jTextField1.getText() + "%'");
                rs = pstmt.executeQuery();
                if (rs != null) {
                    DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                    int rowCount = aModel.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        aModel.removeRow(i);
                    }

                    while (rs.next()) {
                        aModel.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
                    }
                    jTable1.setModel(aModel);
                } else {
                    JOptionPane.showMessageDialog(null, "No result found...");
                    return;
                }
            } catch (SQLException e) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (evt.getActionCommand().equals("Update") && jComboBox1.getSelectedItem().equals("Select Status") && jTextField2.getText().equals("") && jTextField3.getText().equals("") && jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select Details in Order to Update");
            return;
        } else if (evt.getActionCommand().equals("Update") && jComboBox1.getSelectedItem().equals("Empty") && jTextField2.getText().equals("") && jTextField3.getText().equals("") && jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select Details in Order to Update");
            return;
        } else {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
            } catch (SQLException ex) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String Flat_Status = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String Name = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                String Name_r = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                String Mobile_Number = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                String Build = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();

                String name = jTextField7.getText();
                String Name_R = jTextField2.getText();
                String Mob_no = jTextField3.getText();
                String Flat_s = (String) jComboBox1.getSelectedItem();
                String Build_u = jComboBox2.getSelectedItem().toString();
                if (name.equals(Name) && Name_R.equals(Name_r) && Mob_no.equals(Mobile_Number) && Flat_s.equals(Flat_Status) && Build.equals(Build_u)) {
                    JOptionPane.showMessageDialog(null, "All update Successfully!!!");
                    return;
                }
                //give rs power etc... then rs.get will work....

                String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();

                if (name.equals("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid Name!!!!");
                    return;
                }
                if (Name_R.equals("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid Renter's Name!!!!");
                    return;
                }
                if (Flat_s.equals("Select status")) {
                    JOptionPane.showMessageDialog(null, "Please select the Flat Status!!!!");
                    return;
                }

                if (Build_u.equals("Select Wing")) {
                    JOptionPane.showMessageDialog(null, "Please Select Building Wing to Update");

                }
                if (!Mob_no.equals("") && !Mob_no.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid Number!!!!!");
                    return;
                } else if (Mob_no.length() < 10 && Mob_no.length() > 17) {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                    return;
                } else if (!Mob_no.equals("") && Double.parseDouble(Mob_no) < 7000000000D) {
                    JOptionPane.showMessageDialog(null, "Invalid mobile number , mobile number range Starts From 7,8,9");
                    return;
                }
                pstmt = con.prepareStatement("Update customers_details set Flat_Status=?,Name_of_the_Owner=?,Name_of_the_Renter=?,Mobile_Number=?,Building_Wing=? where Flat_No=?");
                pstmt.setString(1, Flat_s);
                pstmt.setString(2, name);
                pstmt.setString(3, Name_R);
                pstmt.setString(4, Mob_no);
                pstmt.setString(5, Build_u);
                pstmt.setString(6, id);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Updated Successfully!!!!");
                    try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
                        pstmt = con.prepareStatement("select * from customers_details");
                        ResultSet rs = pstmt.executeQuery();
                        DefaultTableModel mytable = (DefaultTableModel) jTable1.getModel();
                        int rowCount = mytable.getRowCount();
                        for (int j = rowCount - 1; j >= 0; j--) {
                            mytable.removeRow(j);
                            ResultSetMetaData rsdm = rs.getMetaData();
                            while (rs.next()) {
                                mytable.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
                            }
                            jTable1.setModel(mytable);
                            jTextField7.setText("");
                            jTextField2.setText("");
                            jTextField3.setText("");
                            jTextField4.setText("");
                            jComboBox1.setSelectedIndex(0);
                            jComboBox2.setSelectedIndex(0);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, id);
                    return;
                }

            } catch (Exception exc) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, exc);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (evt.getActionCommand().equals("Refresh")) {
            try {
                pstmt = con.prepareStatement("select * from customers_details");
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = aModel.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    aModel.removeRow(i);
                }
                while (rs.next()) {
                    aModel.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
                }
                jTable1.setModel(aModel);
                jTextField7.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
            } catch (SQLException ex) {
                Logger.getLogger(Admin_MainFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (evt.getActionCommand().equals("Delete")) {
            int k = jTable1.getSelectedRowCount();
            if (k == 0) {
                JOptionPane.showMessageDialog(null, "Please Select the Data you want to Delete");
                return;
            } else if (k > 1) {
                multiple_Delete();
            } else {
                int a = JOptionPane.showConfirmDialog(null, "Do you Want to Delete Customer's Data ?");
                if (a == 0) {
                    try {
                        String flat_no = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                        if (flat_no.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Select the data you want to Delete");
                            return;
                        } else {
                            pstmt = con.prepareStatement("delete from customers_details where Flat_No=?");
                            pstmt.setString(1, flat_no);
                            int i = pstmt.executeUpdate();
                            if (i > 0) {
                                jTextField7.setText("");
                                jComboBox1.setSelectedIndex(0);
                                jTextField3.setText("");
                                jTextField2.setText("");
                                JOptionPane.showMessageDialog(null, "Data removed Successfully!!!");
                                try {
                                    pstmt = con.prepareStatement("select * from customers_details");
                                    ResultSet rs = pstmt.executeQuery();
                                    DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                                    int rowCount = aModel.getRowCount();
                                    for (int j = rowCount - 1; j >= 0; j--) {
                                        aModel.removeRow(j);
                                    }
                                    while (rs.next()) {
                                        aModel.addRow(new Object[]{rs.getString("Flat_No"), rs.getString("Floor_No"), rs.getString("Building_Wing"), rs.getString("Flat_Status"), rs.getString("Name_of_the_Owner"), rs.getString("Name_of_the_Renter"), rs.getString("Mobile_Number")});
                                    }
                                    jTable1.setModel(aModel);
                                    jTextField7.setText("");
                                    jTextField2.setText("");
                                    jTextField3.setText("");
                                    jTextField4.setText("");
                                    jComboBox1.setSelectedIndex(0);
                                } catch (SQLException ex) {
                                    Logger.getLogger(Admin_MainFrame.class
                                            .getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Something Went Wrong While Deleting");
                                return;
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (evt.getActionCommand().equals("Clear")) {
            jTextField7.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jComboBox1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (evt.getActionCommand().equals("Exit")) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit");
            if (a == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            new Admin_Expenses().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Admin_NewCustomer().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Admin_AddUser().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (evt.getActionCommand().equals("Close")) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit");
            if (a == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new Bill().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new Admin_ManageUsers().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Manage_Income_Expenses().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
