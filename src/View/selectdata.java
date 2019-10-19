/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import java.util.Date;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class selectdata {
    private com.mysql.jdbc.Statement stat;
    private com.mysql.jdbc.Connection Con;
    private ResultSet res;
    private String t;
    private Component rootPane;
    koneksi konek;
   
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date tanggal = new Date();

    DateFormat bulan = new SimpleDateFormat("MM");
    DateFormat tahun = new SimpleDateFormat("yyyy");  
    
    private String getBulan() {  
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();  
        return dateFormat.format(date);
    } 
        private String getTahun() {  
        DateFormat dateFormat = new SimpleDateFormat("yy");
        Date date = new Date();  
        return dateFormat.format(date);
    }  
        
        public selectdata(){
        try{
            konek = new koneksi();
            Con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/penjualanarduino", "root", "");
            stat=(com.mysql.jdbc.Statement) Con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
        
    public String[] selectDataFaktur(String kode){
        String[] data=new String[2];
        try{
           t = "select* from penjualan WHERE no_faktur='"+kode+"'";
           res  = stat.executeQuery(t);
           if(res.next()){ // tampilkan data yang sudah ada
               data[0]=res.getString("no_faktur");
               data[1]=res.getString("tgl_faktur");
           }else {
               data=null;
           }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,
             "Data Test tidak dapat ditampilkan!",
             "Tampil Data",JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }   
    
    public String selectnofaktur(){
        String kode="";
        try{
            t = "SELECT no_faktur FROM penjualan ORDER BY no_faktur DESC";
            res = stat.executeQuery(t);

            if(res.next()){
                kode = res.getString("no_faktur");
                kode = kode.substring(2, 5);
                int temp = Integer.parseInt(kode)+1;
                if(temp<=9) kode="T000"+temp;
                else if( temp>=10 && temp<=99 )kode="T00"+temp;
                else if( temp>=100 && temp<=999 )kode="T0"+temp;
            }
            else{
                kode="T0001";
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,
            "kode faktur tidak dapat ditampilkan!\n"+e,
            "AutoNumber",JOptionPane.ERROR_MESSAGE);
        }
        return kode;
    }
}
