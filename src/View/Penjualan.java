/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import PopUp.pop_up_barang;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
/**
 *
 * @author User
 */
public class Penjualan extends javax.swing.JFrame {
    private Statement stat;
    private Connection con;
    private ResultSet res;
    private String t;
    private PreparedStatement pst;
//    private Component rootPane;
    cekdata cek = new cekdata();
    SimpanData simpan = new SimpanData();
    selectdata select = new selectdata();
    String[] dataPopup = new String[15];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date tanggal = new Date();
    int ada = 0;
    //DefaultTableModel tableModel;
    
    public Penjualan() {
        initComponents();
        setLocationRelativeTo(null);
        koneksi();
        Date date = new Date();
        tgl_faktur.setDate(date);
        cmbValue();
        tabel();
        bersih();
    }
    
    private void koneksi(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/penjualanarduino", "root", "");
    stat=(Statement) con.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, e);
    }
    }
    
     void bersih(){
    no_penjualan.setText(select.selectnofaktur());
    tgl_faktur.setDate(new Date());
    tgl_faktur.setEnabled(false);
    cmb_pembeli.setSelectedItem("Umum");
       kd_barang.setText("");
       nama_barang.setText("");
       harga.setText("");
       banyak.setText("");
       total.setText("");
       dibayar.setText("");
       uang_kembali.setText("");
    }
    
    private void tabel(){ 
    DefaultTableModel t= new DefaultTableModel();
     t.addColumn("no_faktur"); 
     t.addColumn("tgl_faktur"); 
     t.addColumn("pembeli"); 
     t.addColumn("kd_barang");
     t.addColumn("nama_barang"); 
     t.addColumn("harga"); 
     t.addColumn("banyak"); 
     t.addColumn("total");
     t.addColumn("dibayar");
     t.addColumn("uang_kembali");
     tbl_penjualan.setModel(t); try{ res=stat.executeQuery("select * from penjualan"); 
     while (res.next()) { 
     t.addRow(new Object[]{ res.getString("no_faktur"),
     res.getString("tgl_faktur"), 
     res.getString("pembeli"), 
     res.getString("kd_barang"), 
     res.getString("nama_barang"), 
     res.getString("harga"), 
     res.getString("banyak"), 
     res.getString("total"),
     res.getString("dibayar"),
     res.getString("uang_kembali") 
     }); 
     }
     }catch (Exception e) { 
     JOptionPane.showMessageDialog(rootPane, e); 
     } 
    }
    
     public void setDataPopup(String[] datapopup) {
        this.dataPopup = datapopup;

    }

    public String[] getDataPopup() {
        return dataPopup;
    }
    
    public  boolean kosong(){
        boolean stats=false;
        if(no_penjualan.getText().equals("") ||
                tgl_faktur.getDate().equals("") ||
                cmb_pembeli.getSelectedItem().equals("Umum") ||
                kd_barang.getText().equals("") ||
                nama_barang.getText().equals("") ||
                harga.getText().equals("") ||
                banyak.getText().equals("") ||
                total.getText().equals("") ||
                dibayar.getText().equals("") ||
                uang_kembali.getText().equals("") )
                

        {stats=true;
        }else stats=false;
        return stats;
    }
    
    void Simpan (){
          if(kosong() == false){
                simpan.simpanPenjualan(no_penjualan.getText(), sdf.format(tgl_faktur.getDate()), kd_barang.getText(), cmb_pembeli.getSelectedItem().toString(), nama_barang.getText(), harga.getText(), banyak.getText(), total.getText(), dibayar.getText(), uang_kembali.getText());
                                           
                  bersih();
                  //tabel();
            }else{
                JOptionPane.showMessageDialog(null, "Data penjualan belum lengkap!","Simpan Data",
                        JOptionPane.WARNING_MESSAGE);
            }
      }
    
    private void cmbValue(){
        try{
            String sql = "select * from Pelanggan";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            
            while(res.next()){
                String name = res.getString("nama_pelanggan");
                cmb_pembeli.addItem(name);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void no_transaksi(){
        try {
            String sql = "SELECT id_transaksi FROM transaksi";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            if(res.last()){
                no_penjualan.setText(String.valueOf(res.getInt(1)+1));
            }
            else
                no_penjualan.setText("1");
        } catch (Exception e) {
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

        txt_no_faktur = new javax.swing.JLabel();
        txt_kd_barang = new javax.swing.JLabel();
        txt_nama_barang = new javax.swing.JLabel();
        txt_harga = new javax.swing.JLabel();
        txt_banyak = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();
        txt_dibayar = new javax.swing.JLabel();
        txt_uang_kembali = new javax.swing.JLabel();
        no_penjualan = new javax.swing.JTextField();
        kd_barang = new javax.swing.JTextField();
        nama_barang = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        dibayar = new javax.swing.JTextField();
        uang_kembali = new javax.swing.JTextField();
        banyak = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        Cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_penjualan = new javax.swing.JTable();
        btn_cari = new javax.swing.JButton();
        tgl_faktur = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_pembeli = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_no_faktur.setText("No. Faktur Penjualan");

        txt_kd_barang.setText("Kode Barang");

        txt_nama_barang.setText("Nama Barang");

        txt_harga.setText("Harga");

        txt_banyak.setText("Banyak");

        txt_total.setText("Total");

        txt_dibayar.setText("Dibayar");

        txt_uang_kembali.setText("Uang Kembali");

        banyak.setText("1");

        btn_simpan.setText("Beli");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        Cetak.setText("Cetak");

        tbl_penjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.Faktur", "Tanggal", "Kode Barang", "Nama Barang", "Harga", "Banyak", "Total", "Dibayar", "Uang Kembali"
            }
        ));
        jScrollPane1.setViewportView(tbl_penjualan);

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        tgl_faktur.setDateFormatString("d MMM yyyy");

        jLabel1.setText("Tanggal");

        jLabel2.setText("Nama Pembeli");

        cmb_pembeli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_pembeliItemStateChanged(evt);
            }
        });
        cmb_pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pembeliActionPerformed(evt);
            }
        });

        jButton1.setText("Faktur Baru");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_no_faktur)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(no_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tgl_faktur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(69, 69, 69))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_total)
                                            .addComponent(txt_dibayar)
                                            .addComponent(txt_uang_kembali))
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(uang_kembali)
                                            .addComponent(dibayar)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                                .addGap(10, 10, 10))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_kd_barang)
                                            .addComponent(txt_nama_barang)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_harga)
                                                .addComponent(txt_banyak)))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(nama_barang, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kd_barang, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmb_pembeli, javax.swing.GroupLayout.Alignment.LEADING, 0, 296, Short.MAX_VALUE)
                                                .addComponent(harga))
                                            .addComponent(banyak, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btn_cari))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_simpan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cetak)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_no_faktur)
                            .addComponent(no_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tgl_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kd_barang)
                            .addComponent(kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama_barang)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_harga))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(banyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_banyak))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dibayar)
                            .addComponent(dibayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_uang_kembali)
                            .addComponent(uang_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_simpan)
                            .addComponent(btn_hapus)
                            .addComponent(btn_edit)
                            .addComponent(Cetak))))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
Simpan();
tabel();
//        try {
// stat.executeUpdate("insert into penjualan values (" 
//                + "no_faktur='"+no_penjualan.getText()+"',"
//                + "tgl_faktur='"+tgl_faktur.getDate()+"',"
//                + "pembeli='"+cmb_pembeli.getSelectedItem().toString()+"',"
//                + "kd_barang='"+kd_barang.getText()+"',"
//                + "nama_barang='"+nama_barang.getText()+"',"
//                + "harga='"+harga.getText()+"',"
//                + "banyak='"+banyak.getText()+"',"
//                + "total='"+total.getText()+"',"
//                + "dibayar='"+dibayar.getText()+"',"
//                + "uang_kembali='"+uang_kembali.getText()+"')");
//bersih(); 
//JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data"); 
//} catch (SQLException | HeadlessException e) { 
//JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
//}finally{
//         tabel();       
// } 
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
         try { 
        stat.executeUpdate("delete from penjualan where " 
        + "no_faktur='"+no_penjualan.getText()
        +"'" ); 
        JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (SQLException | HeadlessException e) { 
        JOptionPane.showMessageDialog(null, "pesan salah : "+e);
         } finally{
         tabel();
          }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
      try {
            stat.executeUpdate("update penjualan set "
                + "no_faktur='"+no_penjualan.getText()+"',"
                + "tgl_faktur='"+tgl_faktur.getDate()+"',"
                + "nama_pembeli='"+cmb_pembeli.getSelectedItem()+"',"
                + "kd_barang='"+kd_barang.getText()+"',"
                + "nama_barang='"+nama_barang.getText()+"',"
                + "harga='"+harga.getText()+"',"
                + "banyak='"+banyak.getText()+"',"
                + "total='"+total.getText()+"',"
                + "dibayar='"+dibayar.getText()+"',"
                + "uang_kembali='"+uang_kembali.getText()+"'"
                + " where " + "no_faktur='"+no_penjualan.getText()+"'" );
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil Di update");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }finally{
         tabel();
        }     
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                pop_up_barang dialog = new pop_up_barang(new javax.swing.JFrame(), true);
                dialog.setVisible(true);

                kd_barang.setText(dialog.getData()[0]);
                nama_barang.setText(dialog.getData()[1]);
                harga.setText(dialog.getData()[3]);
                
           

            }
        });  
    }//GEN-LAST:event_btn_cariActionPerformed

    private void cmb_pembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_pembeliActionPerformed

    private void cmb_pembeliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_pembeliItemStateChanged
// 
    }//GEN-LAST:event_cmb_pembeliItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        no_transaksi();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JTextField banyak;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cmb_pembeli;
    private javax.swing.JTextField dibayar;
    private javax.swing.JTextField harga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kd_barang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTextField no_penjualan;
    private javax.swing.JTable tbl_penjualan;
    private com.toedter.calendar.JDateChooser tgl_faktur;
    private javax.swing.JTextField total;
    private javax.swing.JLabel txt_banyak;
    private javax.swing.JLabel txt_dibayar;
    private javax.swing.JLabel txt_harga;
    private javax.swing.JLabel txt_kd_barang;
    private javax.swing.JLabel txt_nama_barang;
    private javax.swing.JLabel txt_no_faktur;
    private javax.swing.JLabel txt_total;
    private javax.swing.JLabel txt_uang_kembali;
    private javax.swing.JTextField uang_kembali;
    // End of variables declaration//GEN-END:variables
}
