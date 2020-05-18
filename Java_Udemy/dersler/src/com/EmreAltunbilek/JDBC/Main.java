package com.EmreAltunbilek.JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /*try {
            Connection baglanti = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = baglanti.createStatement(); // Statement nesnesi çalıştırılacak veritabanı sorguları için kullanılır.
            statement.execute("CREATE TABLE KISILER(isim TEXT, email TEXT)"); //Çalıştırılan sql kodu.
            statement.close(); // Performan ve çalışma açısından en önemli kavramlardan birisi oluşturulan
            baglanti.close(); // Connection'un ve statement'in muhakkak kapatılması lazım
        }catch (SQLException e){
            e.printStackTrace();
        }*/

        /*
        Aşağıdaki kavram trty with resources diye geçer.
        Bu şekilde yaparsak bütün kapatılması gereken nesneleri "acaba kapattık mı" derdinden kurtuluruzz.
         */

        /*
        AutoCommit diye bir özellik var. Bu özellik default olarak true gelir ve direk sorgulamadan
        veritabanına kaydeder.

        Aam biz bunun değerini false yaptığımızda kod çalışsa bile veritabanına kaydetmez.
        Kaydetmesini istiyorsak kodumuz bitince tekrar commit ile tetiklememiz lazım.
         */
        try(Connection baglanti = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = baglanti.createStatement();) {
            baglanti.setAutoCommit(false);
            statement.execute("CREATE TABLE IF NOT EXISTS KISILER(isim TEXT, email TEXT)"); //Çalıştırılan sql kodu.
            statement.execute("INSERT INTO KISILER (isim, email) values ('Furkan', 'furkan@furkan')");
            statement.execute("INSERT INTO KISILER (isim, email) values ('Sahin', 'sahin@sahin')");
            baglanti.commit();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM KISILER"); //Veritabanından sorgu çekmek için kullanılır.
            while (resultSet.next()){  //-> resultSet.next() => resultSet bitene kadar demek
                System.out.println("Kisi Adi : " + resultSet.getString(1) + "\nKisi Emaili : " + resultSet.getString("EMAIL"));
            }  //NOT: Sütun indeksleri sıfırdan başlamaz.
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
