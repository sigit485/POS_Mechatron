/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.sql.*;
import javax.swing.*;

public class cekdata {
    private com.mysql.jdbc.Statement stat;
    private com.mysql.jdbc.Connection Con;
    private ResultSet res;
    private String t;
    private Component rootPane;
    koneksi konek;
    
    public cekdata(){
        try{
            konek = new koneksi();
            Con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/penjualanarduino", "root", "");
            stat=(com.mysql.jdbc.Statement) Con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String[][] cekTblBarang(){
     String[][] data =null;
     try{
         t ="select* from barang order by kd_barang"; 
         res= stat.executeQuery(t);
         res.last();
         data = new String[res.getRow()][47];
         int i = 0;
         res.beforeFirst();
         while(res.next()){
             data[i][0] = res.getString("kd_barang");
             data[i][1] = res.getString("nama_barang");
             data[i][2] = res.getString("stok");
             data[i][3] = res.getString("berat");
             data[i][4] = res.getString("deskripsi");
             data[i][5] = res.getString("supplier");
             data[i][6] = res.getString("harga");
             data[i][7] = res.getString("harga_beli");
            
             i++;
         }
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null,"Data tidak dapat ditampilkan ke tabel!\n"+e,"Table view",JOptionPane.ERROR_MESSAGE);

     }
     return data;
 }
    
    public String[][] CekPopUpBarang(String kode){
     String[][] data =null;
     try{
         t = "select * from barang where kd_barang like '%"+kode+"%' or nama_barang like '%"+kode+"%' order by kd_barang asc";
         res  = stat.executeQuery(t);
         res.last();
         data = new String[res.getRow()][47];
         int i = 0;
         res.beforeFirst();
         while(res.next()){
             data[i][0] = res.getString("kd_barang");
             data[i][1] = res.getString("nama_barang");
             data[i][2] = res.getString("stok");
             data[i][3] = res.getString("berat");
             data[i][4] = res.getString("deskripsi");
             data[i][5] = res.getString("supplier");
             data[i][6] = res.getString("harga");
             data[i][7] = res.getString("harga_beli");
             i++;
         }
     }
     catch(Exception e){
             JOptionPane.showMessageDialog(null,
             "Data Barang tidak dapat ditampilkan!",
             "Tampil Data",JOptionPane.ERROR_MESSAGE);
     }
     return data;
 }
    
    public String[][] cekTblPenjualan(){
     String[][] data =null;
     try{
         t ="select* from t_jual order by jual_nofa desc"; 
         res= stat.executeQuery(t);
         res.last();
         data = new String[res.getRow()][47];
         int i = 0;
         res.beforeFirst();
         while(res.next()){
             data[i][0] = res.getString("jual_nofa");
             data[i][1] = res.getString("jual_tgl");
             data[i][2] = res.getString("jual_pelanggan");
             data[i][3] = res.getString("jual_total");
             data[i][4] = res.getString("jual_cash");
             data[i][5] = res.getString("jual_kembali");
             data[i][6] = res.getString("jual_barangid");
             data[i][7] = res.getString("jual_harga");
             data[i][8] = res.getString("jual_qty");
             data[i][9] = res.getString("jual_subtotal");
             data[i][10] = res.getString("jual_nama_barang");
             i++;
         }
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null,"Data tidak dapat ditampilkan ke tabel!\n"+e,"Table view",JOptionPane.ERROR_MESSAGE);

     }
     return data;
 }
    
     public String[][] CekPopUpPenjualan(String kode){
     String[][] data =null;
     try{
           t = "select * from t_jual where jual_nofa like '%"+kode+"%' or jual_nama_barang like '%"+kode+"%' order by jual_nofa asc";
           res  = stat.executeQuery(t);
         res.last();
         data = new String[res.getRow()][47];
         int i = 0;
         res.beforeFirst();
         while(res.next()){
             data[i][0] = res.getString("jual_nofa");
             data[i][1] = res.getString("jual_tgl");
             data[i][2] = res.getString("jual_pelanggan");
             data[i][3] = res.getString("jual_total");
             data[i][4] = res.getString("jual_cash");
             data[i][5] = res.getString("jual_kembali");
             data[i][6] = res.getString("jual_barangid");
             data[i][7] = res.getString("jual_harga");
             data[i][8] = res.getString("jual_qty");
             data[i][9] = res.getString("jual_subtotal");
             data[i][10] = res.getString("jual_nama_barang");
             i++;
         }
     }
     catch(Exception e){
             JOptionPane.showMessageDialog(null,
             "Data Faktur tidak dapat ditampilkan!",
             "Tampil Data",JOptionPane.ERROR_MESSAGE);
     }
     return data;
 }
    
}
