package com.styleattribute.ganiban_s;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;


public class User_MainFrame extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String templateFile = "";

    public User_MainFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt = con.prepareStatement("select*from billing");
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel mytable = (DefaultTableModel) jTable1.getModel();
            int rowCount = mytable.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                mytable.removeRow(i);
                ResultSetMetaData rsdm = rs.getMetaData();
                while (rs.next()) {
                    mytable.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("to_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ganiban Management Software");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reciept No", "Date", "Name of Owner", "Building Wing", "Flat No / shop No", "Rupees", "In Words", "From Month", "To Month", "Maintainance Charges", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bill Details");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name of the Owner :");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Bill");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Bill().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (evt.getActionCommand().equals("Search") && jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please type in the input section to search");
            return;
        }
        if (evt.getActionCommand().equals("Search")) {
            try {
                pstmt = con.prepareStatement("select * from billing where Reciept_no like '%" + jTextField1.getText() + "%' or Name like '%" + jTextField1.getText() + "%'or Flat_No_or_Shop_No like '%" + jTextField1.getText() + "%'or Date like '%" + jTextField1.getText() + "%'or Building_Wing like '%" + jTextField1.getText() + "%'");
                rs = pstmt.executeQuery();
                if (rs != null) {
                    DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                    int rowCount = aModel.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        aModel.removeRow(i);
                    }

                    while (rs.next()) {
                        aModel.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("From_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
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
        if (evt.getActionCommand().equals("Clear")) {
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (evt.getActionCommand().equals("Refresh")) {
            try {
                pstmt = con.prepareStatement("select * from billing");
                ResultSet rs = pstmt.executeQuery();
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = aModel.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    aModel.removeRow(i);
                }
                while (rs.next()) {
                    aModel.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("From_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
                }
                jTable1.setModel(aModel);
                jTextField1.setText("");
                //jTextField2.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(Admin_MainFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (evt.getActionCommand().equals("Print")) {
            int i = jTable1.getSelectedRowCount();
            if (i > 1) {
                try {
                    mutiple_Export();
                } catch (IOException ex) {
                    Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String Reciept = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                String Date = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String Name = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String Build_no = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                String flat_no = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                String rupees = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                String inwords = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
                String frommonth = jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString();
                String tomonth = jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();
                String Maintainance = jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
                String total = jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString();
                //Folder Selection
                JFileChooser export = new JFileChooser(new java.io.File("."));
                export.setDialogTitle("Select the Folder to Export Bill");
                export.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                export.setAcceptAllFileFilterUsed(false);
                if (export.showOpenDialog(export) == JFileChooser.APPROVE_OPTION) {

                    try {
                        String outputFile = export.getSelectedFile().toString();

                        File jarPath = new File(Admin_Export.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                        String propertiesPath = jarPath.getParentFile().getAbsolutePath();

                        templateFile = propertiesPath + "//template.docx";
                        this.updateDocument(templateFile, outputFile, Reciept, Date, Name, Build_no, flat_no, rupees, inwords, frommonth, tomonth, Maintainance, total);
                    } catch (Exception ex) {
                        Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed
    private void updateDocument(String templateFile, String outputFile, String Reciept,
            String Date, String Name, String Building_no, String flat_no, String rupees, String inwords, String frommonth, String tomonth,
            String Maintainance, String total) throws Exception {

        XWPFDocument doc = null;
        try {
            File openTemplates = new File(templateFile);
            doc = new XWPFDocument(OPCPackage.open(openTemplates));
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                runs.forEach(r -> {
                    String text = r.getText(0);
                    if (text != null && text.contains("${Reciept}")) {
                        text = text.replace("${Reciept}", Reciept);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${date}")) {
                        text = text.replace("${date}", Date);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${name}")) {
                        text = text.replace("${name}", Name);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${Build_no}")) {
                        text = text.replace("${Build_no}", Building_no);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${flat_no}")) {
                        text = text.replace("${flat_no}", flat_no);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${price}")) {
                        text = text.replace("${price}", rupees);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${inwords}")) {
                        text = text.replace("${inwords}", inwords);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("${from}")) {
                        text = text.replace("${from}", frommonth);
                        r.setText(text, 0);
                    }
                    if (text != null && text.contains("${to}")) {
                        if (tomonth.equals("")) {
                            text = text.replace("${to}", "---------------");
                            r.setText(text, 0);
                        } else {
                            text = text.replace("${to}", tomonth);
                            r.setText(text, 0);
                        }
                    }
                });

            }
        }
        for (XWPFTable tbl : doc.getTables()) {
            tbl.getRows().forEach(row -> {
                row.getTableCells().forEach(cell -> {
                    cell.getParagraphs().forEach(p -> {
                        p.getRuns().forEach(r -> {
                            String text = r.getText(0);
                            if (text != null && text.contains("${charges}")) {
                                text = text.replace("${charges}", Maintainance);
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("${total}")) {
                                text = text.replace("${total}", total);
                                r.setText(text, 0);
                            }
                        });
                    });
                });
            });
        }
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        try (FileOutputStream fos = new FileOutputStream(new File(outputFile + "/" + Name + "--" + date1 + ".docx"))) {
            XWPFParagraph paragraph = doc.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(paragraph.getParagraphText());
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.getMessage();
        }
        JOptionPane.showMessageDialog(null, "Exported Successfully!!!!!");
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (evt.getActionCommand().equals("Close")) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit");
            if (a == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mutiple_Export() throws IOException {
        int row = jTable1.getSelectedRowCount();
        String outputFile = "";
        JFileChooser export = new JFileChooser(new java.io.File("."));
        export.setDialogTitle("Select the Folder to Export Bill");
        export.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        export.setAcceptAllFileFilterUsed(false);
        if (export.showOpenDialog(export) == JFileChooser.APPROVE_OPTION) {
            try {
                outputFile = export.getSelectedFile().toString();

                File jarPath = new File(Admin_Export.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                String propertiesPath = jarPath.getParentFile().getAbsolutePath();
                templateFile = propertiesPath + "//template.docx";

            } catch (Exception ex) {
                Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int i = 0;
        for (i = 0; i <= row - 1; i++) {
            String Reciept = jTable1.getValueAt(i, 0).toString();
            String Date = jTable1.getValueAt(i, 1).toString();
            String Name = jTable1.getValueAt(i, 2).toString();
            String Build_no = jTable1.getValueAt(i, 3).toString();
            String flat_no = jTable1.getValueAt(i, 4).toString();
            String rupees = jTable1.getValueAt(i, 5).toString();
            String inwords = jTable1.getValueAt(i, 6).toString();
            String frommonth = jTable1.getValueAt(i, 7).toString();
            String tomonth = jTable1.getValueAt(i, 8).toString();
            String Maintainance = jTable1.getValueAt(i, 9).toString();
            String total = jTable1.getValueAt(i, 10).toString();

            XWPFDocument doc = null;
            try {
                doc = new XWPFDocument(OPCPackage.open(templateFile));
            } catch (InvalidFormatException ex) {
                Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("${Reciept}")) {
                            text = text.replace("${Reciept}", Reciept);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${date}")) {
                            text = text.replace("${date}", Date);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${name}")) {
                            text = text.replace("${name}", Name);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${Build_no}")) {
                            text = text.replace("${Build_no}", Build_no);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${flat_no}")) {
                            text = text.replace("${flat_no}", flat_no);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${price}")) {
                            text = text.replace("${price}", rupees);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${inwords}")) {
                            text = text.replace("${inwords}", inwords);
                            r.setText(text, 0);
                        } else if (text != null && text.contains("${from}")) {
                            text = text.replace("${from}", frommonth);
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("${to}")) {
                            if (tomonth.equals("")) {
                                text = text.replace("${to}", "---------------");
                                r.setText(text, 0);
                            } else {
                                text = text.replace("${to}", tomonth);
                                r.setText(text, 0);
                            }
                        }
                        r.setText(text, 0);
                    }

                }
            }
            for (XWPFTable tbl : doc.getTables()) {
                tbl.getRows().forEach(rows -> {
                    rows.getTableCells().forEach(cell -> {
                        cell.getParagraphs().forEach(p -> {
                            p.getRuns().forEach(r -> {
                                String text = r.getText(0);
                                if (text != null && text.contains("${charges}")) {
                                    text = text.replace("${charges}", Maintainance);
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("${total}")) {
                                    text = text.replace("${total}", total);
                                    r.setText(text, 0);
                                }
                            });
                        });
                    });
                });
            }
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
            Date date = new Date();
            String date1 = dateFormat.format(date);
            try (FileOutputStream fos = new FileOutputStream(new File(outputFile + "/" + Name + "--" + date1 + ".docx"))) {
                XWPFParagraph paragraph = doc.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText(paragraph.getParagraphText());
                doc.write(fos);
                fos.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        JOptionPane.showMessageDialog(null, "All Exported Successfully!!!!");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
