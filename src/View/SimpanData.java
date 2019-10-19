/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.*;
import javax.swing.*;


public class SimpanData {
     private com.mysql.jdbc.Statement stat;
    private com.mysql.jdbc.Connection Con;
    private ResultSet res;
    private String t;
    koneksi konek;
    
    public SimpanData(){
        try{
            konek = new koneksi();
            Con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/penjualanarduino", "root", "");
            stat=(com.mysql.jdbc.Statement) Con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void simpanPenjualan(String no_penjualan, String tgl_faktur, String nama_pembeli,String kd_barang,String nama_barang, String harga, String banyak,
            String total, String dibayar, String uang_kembali){

        try{
            t = "insert into penjualan values('"+ no_penjualan+"','"+tgl_faktur+"','"+kd_barang+"','"+nama_pembeli+"','"+nama_barang+"','"+harga+"','"+banyak+"','"+total+"','"+dibayar+"','"+uang_kembali+"')";
		stat.executeUpdate(t);
            JOptionPane.showMessageDialog(null,"Data Formulir berhasil disimpan!",
                    "Simpan Data",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal disimpan!"+e,
             "Simpan Data",JOptionPane.ERROR_MESSAGE);
        }
    }

    void simpanPenjualan(String text, String toString, java.util.Date date, String toString0, String text0, String toString1, String text1, String toString2, String text2, String toString3, String text3, String toString4, String text4, String toString5, String text5, String toString6, String text6, String toString7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
