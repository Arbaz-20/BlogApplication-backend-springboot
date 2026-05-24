package com.styleattribute.ganiban_s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        //Database Tables 
        createTables();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ganiban Management Software");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selelct Between Given Option");

        jButton1.setText("Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Admin_Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new User_login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Veritabanı tablolarını otomatik olarak oluşturur.
     * database_schema.sql dosyasındaki tüm CREATE TABLE sorgularını çalıştırır.
     */
    private void createTables() {
        Connection con = null;
        Statement stmt = null;
        
        try {
            // Veritabanı bağlantısı
            con = DriverManager.getConnection("jdbc:mysql://localhost/maintainance", "root", "roottoor");
            stmt = con.createStatement();
            
            // 1. Admin Tablosu
            String createAdminTable = "CREATE TABLE IF NOT EXISTS admin ("
                    + "login_ID VARCHAR(50) PRIMARY KEY,"
                    + "password VARCHAR(50) NOT NULL"
                    + ")";
            stmt.executeUpdate(createAdminTable);
            
            // 2. Users Tablosu
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "Login_ID VARCHAR(50) NOT NULL,"
                    + "password VARCHAR(50) NOT NULL"
                    + ")";
            stmt.executeUpdate(createUsersTable);
            
            // 3. Customers Details Tablosu
            String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers_details ("
                    + "Flat_No VARCHAR(50) PRIMARY KEY,"
                    + "Floor_No VARCHAR(10) NOT NULL,"
                    + "Building_Wing VARCHAR(10) NOT NULL,"
                    + "Flat_Status VARCHAR(20) NOT NULL,"
                    + "Name_of_the_Owner VARCHAR(100) NOT NULL,"
                    + "Name_of_the_Renter VARCHAR(100),"
                    + "Mobile_Number VARCHAR(15)"
                    + ")";
            stmt.executeUpdate(createCustomersTable);
            
            // 4. Billing Tablosu
            String createBillingTable = "CREATE TABLE IF NOT EXISTS billing ("
                    + "Reciept_no VARCHAR(20) PRIMARY KEY,"
                    + "Date VARCHAR(20) NOT NULL,"
                    + "Name VARCHAR(100) NOT NULL,"
                    + "Building_Wing VARCHAR(10) NOT NULL,"
                    + "Flat_No_or_Shop_No VARCHAR(50) NOT NULL,"
                    + "Rupees VARCHAR(20) NOT NULL,"
                    + "Only_Rupees_inwords VARCHAR(500),"
                    + "From_month VARCHAR(20),"
                    + "to_month VARCHAR(20),"
                    + "Maintainance_Charges VARCHAR(20),"
                    + "Total VARCHAR(20) NOT NULL"
                    + ")";
            stmt.executeUpdate(createBillingTable);
            
            // 5. Income Tablosu
            String createIncomeTable = "CREATE TABLE IF NOT EXISTS income ("
                    + "ID VARCHAR(20) PRIMARY KEY,"
                    + "Date VARCHAR(20) NOT NULL,"
                    + "Sender VARCHAR(100) NOT NULL,"
                    + "Income_Mode VARCHAR(50) NOT NULL,"
                    + "Cheque_No VARCHAR(50),"
                    + "Bank_Transaction VARCHAR(50),"
                    + "Amount VARCHAR(20) NOT NULL,"
                    + "Discription TEXT NOT NULL"
                    + ")";
            stmt.executeUpdate(createIncomeTable);
            
            // 6. Expenses Tablosu
            String createExpensesTable = "CREATE TABLE IF NOT EXISTS expenses ("
                    + "ID VARCHAR(20) PRIMARY KEY,"
                    + "Date VARCHAR(20) NOT NULL,"
                    + "Reciever VARCHAR(100) NOT NULL,"
                    + "Expense_Mode VARCHAR(50) NOT NULL,"
                    + "Cheque_No VARCHAR(50),"
                    + "Bank_Transaction VARCHAR(50),"
                    + "Amount VARCHAR(20) NOT NULL,"
                    + "Discription TEXT NOT NULL"
                    + ")";
            stmt.executeUpdate(createExpensesTable);
            
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Tüm veritabanı tabloları başarıyla oluşturuldu.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Veritabanı tabloları oluşturulurken hata oluştu: " + ex.getMessage(), ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage(), ex);
            }
        }
    }

    public static void main(String args[]) {

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
