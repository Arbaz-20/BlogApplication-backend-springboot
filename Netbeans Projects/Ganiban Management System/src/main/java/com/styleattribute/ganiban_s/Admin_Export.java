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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

public class Admin_Export extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String templateFile = "";

    public Admin_Export() {
        initComponents();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Export.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt = con.prepareStatement("select * from billing");
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
        cal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ganiban Management Software");
        setResizable(false);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bill Details");

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Flat No :");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Total Income :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("jLabel5");

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
                    aModel.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("to_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
                }
                jTable1.setModel(aModel);
                jTextField1.setText("");
                jTextField2.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (evt.getActionCommand().equals("Delete")) {
            int k = jTable1.getSelectedRowCount();
            jTextField2.setText(String.valueOf(k));
            if (k == 0) {
                JOptionPane.showMessageDialog(null, "Please Select the Data you want to Delete");
                return;
            } else if (k > 1) {
                multiple_Delete();
            } else {
                String Reciept_no = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                jTextField2.setText(Reciept_no);

                int a = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Customer's Data ???");
                if (a == 0) {
                    try {
                        Reciept_no = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                        jTextField2.setText(Reciept_no);
                        if (Reciept_no.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Select the data you want to Delete");
                            return;
                        } else {
                            pstmt = con.prepareStatement("delete from billing where Reciept_no=?");
                            pstmt.setString(1, Reciept_no);
                            int i = pstmt.executeUpdate();
                            if (i > 0) {
                                JOptionPane.showMessageDialog(null, "Data removed Successfully!!!");
                                try {
                                    pstmt = con.prepareStatement("select * from billing");
                                    ResultSet rs = pstmt.executeQuery();
                                    DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                                    int rowCount = aModel.getRowCount();
                                    for (int j = rowCount - 1; j >= 0; j--) {
                                        aModel.removeRow(j);
                                    }
                                    while (rs.next()) {
                                        aModel.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("to_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
                                    }
                                    jTable1.setModel(aModel);
                                    jTextField1.setText("");
                                    jTextField2.setText("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Something Went Wrong While Deleting");
                                return;
                            }
                        }
                        jTextField2.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error While Deleting!!!!");
                    return;
                }
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (evt.getActionCommand().equals("Export")) {
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

                jTextField2.setText(Reciept);
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
    }//GEN-LAST:event_jButton1ActionPerformed
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (evt.getActionCommand().equals("Search") && jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please type in the input section to search");
            return;
        }
        if (evt.getActionCommand().equals("Search")) {
            try {
                pstmt = con.prepareStatement("select * from billing where Building_Wing like '%" + jTextField1.getText() + "%' or Reciept_No like '%" + jTextField1.getText() + "%'or Flat_No_or_Shop_No like '%" + jTextField1.getText() + "%'or Name like'%" + jTextField1.getText() + "%'or Date like'%" + jTextField1.getText() + "%'");
                rs = pstmt.executeQuery();
                if (rs != null) {
                    DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                    int rowCount = aModel.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        aModel.removeRow(i);
                    }

                    while (rs.next()) {
                        aModel.addRow(new Object[]{rs.getString("Reciept_no"), rs.getString("Date"), rs.getString("Name"), rs.getString("Building_Wing"), rs.getString("Flat_No_or_Shop_No"), rs.getString("Rupees"), rs.getString("Only_Rupees_inwords"), rs.getString("From_month"), rs.getString("to_month"), rs.getString("Maintainance_Charges"), rs.getString("Total")});
                    }
                    jTable1.setModel(aModel);
                } else {
                    JOptionPane.showMessageDialog(null, "No result found...");
                    return;
                }
            } catch (SQLException e) {
                Logger.getLogger(Admin_MainFrame.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    private void multiple_Delete() {
        int row = jTable1.getSelectedRowCount();
        int i = 0;
        int a = JOptionPane.showConfirmDialog(null, "Do you Want to Delete Customer's Data ?");
        if (a == 0) {
            for (i = 0; i <= row - 1; i++) {
                if (a == 0) {
                    try {
                        String Reciept_no = jTable1.getValueAt(i, 0).toString();
                        pstmt = con.prepareStatement("delete from billing where Reciept_no=?");
                        pstmt.setString(1, Reciept_no);
                        int j = pstmt.executeUpdate();

                    } catch (SQLException e) {
                        e.getMessage();
                    }
                }
            }
            try {
                pstmt = con.prepareStatement("select * from billing");
                ResultSet result = pstmt.executeQuery();
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = aModel.getRowCount();
                for (int m = rowCount - 1; m >= 0; m--) {
                    aModel.removeRow(m);
                }
                while (result.next()) {
                    aModel.addRow(new Object[]{result.getString("Reciept_no"), result.getString("Date"), result.getString("Name"), result.getString("Building_Wing"), result.getString("Flat_No_or_Shop_No"), result.getString("Rupees"), result.getString("Only_Rupees_inwords"), result.getString("From_month"), result.getString("to_month"), result.getString("Maintainance_Charges"), result.getString("Total")});
                }
                jTable1.setModel(aModel);
            } catch (SQLException ex) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Data removed Successfully!!!");
        }

    }
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed

    }//GEN-LAST:event_jTable1MousePressed
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
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String Flat_no = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        if (Flat_no.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select the Data you Want to Delete");
        } else {
            jTextField2.setText(Flat_no);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int i = 0;
        int row = jTable1.getRowCount();
        int variable = 0;
        int count = 0;
        for (i = 0; i <= row - 1; i++) {
            variable = Integer.parseInt(jTable1.getValueAt(i, 10).toString());
            count += variable;
        }
        jLabel5.setText(String.valueOf(count));
    }//GEN-LAST:event_jButton6ActionPerformed
    public void cal() {

        int i = 0;
        int row = jTable1.getRowCount();
        int variable = 0;
        int count = 0;
        for (i = 0; i <= row - 1; i++) {
            variable = Integer.parseInt(jTable1.getValueAt(i, 10).toString());
            count += variable;
        }
        jLabel5.setText(String.valueOf(count));

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Export().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
