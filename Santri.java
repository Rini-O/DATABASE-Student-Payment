/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StudentPayment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_user
 */
public class Santri extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    private DefaultTableModel tableModel;
    private final String[] columns = {"NIS", "Nama", "Alamat", "Kelas ", "Saldo"};
    private final ArrayList<String[]> dataList = new ArrayList<>();

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/StudentPayment";
    String user = "postgres";
    String password = "rini123tok";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    /**
     * Creates new form Santri
     */
    public Santri() {
        initComponents();
        this.getAllData();
        this.refreshModel();
    }
    
    
    private void searchData(String keyword) {
           try {
               conn = DriverManager.getConnection(koneksi, user, password);
        // Koneksi ke database
        String sql = "SELECT * FROM santri WHERE nis LIKE ?";
        
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%"); // Menggunakan wildcard untuk pencarian

        // Menjalankan query dan mendapatkan hasil
        ResultSet rs = pstmt.executeQuery();

        // Menggunakan DbUtils untuk menampilkan hasil di tabel
        tblSantri.setModel(DbUtils.resultSetToTableModel(rs));
        
        bersih(); // Memanggil fungsi bersih untuk membersihkan input atau status

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error saat mencari data: " + ex.getMessage());
    } 


    }

    public final void getAllData() {
        try {
            Connection conn;
            Class.forName(driver);
            dataList.clear();
            String sql = "SELECT * FROM SANTRI ";

            conn = DriverManager.getConnection(koneksi, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            final ResultSet data = ps.getResultSet();
            while (data.next()) {
                final String[] row = new String[]{
                    data.getString("nis"),
                    data.getString("nama"),
                    data.getString("alamat"),
                    data.getString("kelas"),
                    data.getString("saldo")};

                dataList.add(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public final void getAll() {
        try {
           String sql = "SELECT * FROM SANTRI where nis = ? ";

            conn = DriverManager.getConnection(koneksi, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtNis2.getText());
            ps.executeQuery();
            final ResultSet data = ps.getResultSet();
            while (data.next()) {
                final String[] row = new String[]{
                    data.getString("nis"),
                    data.getString("nama"),
                    data.getString("alamat"),
                    data.getString("kelas"),
                    data.getString("saldo")};

                dataList.add(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public final void refreshModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        for (String[] data : dataList) {
            model.addRow(data);
        }
        tblSantri.setModel(model);
    }
//private void search() {
//        String sql = "SELECT nis FROM SANTRI ORDER BY nis"; // Mengambil semua ID pembeli
//        try ( PreparedStatement pstmt = conn.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {
//
//            List<Integer> ids = new ArrayList<>(); // Untuk menyimpan semua ID yang ada
//            while (rs.next()) {
//                String No_Urut = rs.getString("nis");
//                int idNumber = Integer.parseInt(No_Urut.replaceAll("\\D", "")); // Ambil angka dari ID
//                ids.add(idNumber);
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Format ID tidak valid.");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSantri = new javax.swing.JTable();
        btnInsert = new java.awt.Button();
        btnUpdate = new java.awt.Button();
        btnDelete = new java.awt.Button();
        jLabel7 = new javax.swing.JLabel();
        txtNis2 = new javax.swing.JTextField();
        btnCari = new java.awt.Button();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SANTRI");

        jLabel2.setText("NIS");

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat ");

        jLabel5.setText("Kelas");

        jLabel6.setText("Saldo");

        txtNis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNisActionPerformed(evt);
            }
        });

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        tblSantri.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSantri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSantriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSantri);

        btnInsert.setLabel("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setLabel("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setLabel("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("NIS");

        txtNis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNis2ActionPerformed(evt);
            }
        });

        btnCari.setLabel("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addContainerGap(474, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtNis2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtNis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void txtNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNisActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
       String key = txtNis2.getText();
        searchData(key);
    
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (txtNis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtKelas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtSaldo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else {
            try {
//                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);

                // Menyiapkan query SQL untuk memasukkan data
                String sql = "INSERT INTO Santri(nis, nama, alamat, kelas, saldo) VALUES(?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);

                // Mengambil data dari input pengguna
                String nis = txtNis.getText();
                String nama = txtNama.getText();
                String alamat = txtAlamat.getText();
                String kelas = txtKelas.getText();
                int saldo = Integer.parseInt(txtSaldo.getText());

                // Mengisi parameter untuk query SQL
                pstmt.setString(1, nis);
                pstmt.setString(2, nama);
                pstmt.setString(3, alamat);
                pstmt.setString(4, kelas);
                pstmt.setInt(5, saldo);
pstmt.executeUpdate();
      //conn.commit();
//                
                this.getAllData();
                this.refreshModel();
//
//                pstmt.close();
//                conn.close();
                JOptionPane.showMessageDialog(null, "Succes to insert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        bersih();

    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtNis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "NIS harus terisi untuk update data");
        } else if (txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama harus terisi");
        } else if (txtAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat harus terisi");
        } else if (txtKelas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kelas harus terisi");
        } else if (txtSaldo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Saldo harus terisi");
        } else {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                conn.setAutoCommit(false);

                String sql = "UPDATE Santri SET nama = ?, alamat = ?, kelas = ?, saldo = ? WHERE nis = ?";
                pstmt = conn.prepareStatement(sql);

                String nis, nama, alamat, kelas, saldo;
                nis = txtNis.getText();
                nama = txtNama.getText();
                alamat = txtAlamat.getText();
                kelas = txtKelas.getText();
                saldo = txtSaldo.getText();

                // Set parameter untuk query SQL
                pstmt.setString(1, nama);
                pstmt.setString(2, alamat);
                pstmt.setString(3, kelas);
                pstmt.setInt(4, Integer.parseInt(saldo));
                pstmt.setString(5, nis); // NIS sebagai kondisi WHERE

                // Eksekusi query
                pstmt.executeUpdate();

                conn.commit();
                this.getAllData();
                this.refreshModel();
                // Tutup koneksi
                pstmt.close();
                conn.close();

                
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + ex.getMessage());
            }
        }
        bersih();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtNis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "NIS harus terisi untuk menghapus data");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(koneksi, user, password);
                    conn.setAutoCommit(false);

                    String sql = "DELETE FROM Santri WHERE nis = ?";
                    pstmt = conn.prepareStatement(sql);

                    // Set parameter untuk query SQL
                    pstmt.setString(1, txtNis.getText());

                    // Eksekusi query
                    pstmt.executeUpdate();
                    conn.commit();

                    // Tutup koneksi
                    pstmt.close();
                    conn.close();

                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + ex.getMessage());
                }
            }
            bersih();

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblSantriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSantriMouseClicked
        int row = tblSantri.getSelectedRow();
        txtNis.setText(tblSantri.getValueAt(row, 0).toString());
        txtNama.setText(tblSantri.getValueAt(row, 1).toString());
        txtAlamat.setText(tblSantri.getValueAt(row, 2).toString());
        txtKelas.setText(tblSantri.getValueAt(row, 3).toString());
        txtSaldo.setText(tblSantri.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblSantriMouseClicked

    private void txtNis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNis2ActionPerformed
        // TODO add your hndling code here:
    }//GEN-LAST:event_txtNis2ActionPerformed

    private void bersih() {
        txtNis.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtKelas.setText("");
        txtSaldo.setText("");
    }

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
            java.util.logging.Logger.getLogger(Santri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Santri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Santri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Santri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Santri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCari;
    private java.awt.Button btnDelete;
    private java.awt.Button btnInsert;
    private java.awt.Button btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblSantri;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNis;
    private javax.swing.JTextField txtNis2;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
