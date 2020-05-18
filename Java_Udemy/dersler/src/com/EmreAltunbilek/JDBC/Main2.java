package com.EmreAltunbilek.JDBC;

import java.sql.*;

/*
UPDATE - DELETE PREPARED STATEMENT İŞLEMLERİ
 */
public class Main2 {
    public static void main(String[] args) {
        try(
                Connection baglanti = DriverManager.getConnection("jdbc:sqlite:test.db");
                Statement statement = baglanti.createStatement();
            )
        {

            /*
            statement.execute("UPDATE KISILER SET ISIM = 'ahmet kayra' where ISIM = 'kayra'");
            int etkilenensatirSayisi = statement.executeUpdate("update KISILER set ISIM = 'furkan sahin' where ISIM  = 'furkan'");
            System.out.println("statement.executeUpdate methodu o SQL'den etkilenen satır sayısını verir. Int olarak geriye bir değer döndürür.");
            System.out.println(etkilenensatirSayisi);
            statement.execute("DELETE from KISILER where ISIM = 'sahin'");
             */

            ResultSet result = statement.executeQuery("SELECT * FROM KISILER");
            while (result.next()){
                System.out.print("Adi : " + result.getString("ISIM") + " Emaili : " + result.getString("EMAIL"));
                System.out.println();
            }

            System.out.println("**************************");

            //PREPARED STATEMENT
            //Bir sorguyu hazırlıyoruz ama parametre vermiyoruz.
            //Mesela bir FX uygulamasında kullanıcıdan girilen bir değer ile sorgunun çalıştırılmasını isteyebilriz.
            //Bunu ise (SELECT * FROM TABLO_ADI WHERE = ? şeklinde yapıyoruz.)

            PreparedStatement preparedStatement = baglanti.prepareStatement("select * from KISILER where isim = ? or email = ?");
            preparedStatement.setString(1,"irfan");
            preparedStatement.setString(2, "kulaksiz@kulaksiz");
            result = preparedStatement.executeQuery();

            while (result.next()){
                System.out.print("Adi : " + result.getString("ISIM") + " Emaili : " + result.getString("EMAIL"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
