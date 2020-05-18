package sample.Model;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class DataSource {



    public static final String DB_NAME = "muzik.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:"+ DB_NAME;

    public static final String TABLO_ALBUM = "ALBUM";
    public static final String SUTUN_ALBUM_ID = "album_id";
    public static final String SUTUN_ALBUM_ADI = "album_adi";
    public static final String SUTUN_SARKICI_ALBUM_ID = "sarkici_id";

    public static final String TABLO_SARKICI = "SARKICI";
    public static final String SUTUN_SARKICI_ID = "sarkici_id";
    public static final String SUTUN_SARKICI_ADI = "sarkici_adi";

    public static final String TABLO_SARKI = "SARKI";
    public static final String SUTUN_SARKI_ID = "sarki_id";
    public static final String SUTUN_SARKI_ADI = "sarki_adi";
    public static final String SUTUN_SARKI_ALBUM_ID = "album_id";

    public static final int SIRALA_ARTAN = 1;
    public static final int SIRALA_AZALAN = 2;

    //SINGLETON: DESIGN PATTERN
    private DataSource(){

    }


    //Bu kod thread safe değil. Yani birden fazla thread çalışırsa problem oluşur.
    /*
    private static DataSource instance;
    public static DataSource getInstance(){
        if (instance == null){
            instance = new DataSource();
        }
        return instance;
    }*/

    private static DataSource instance = new DataSource();
    public static DataSource getInstance(){
        return instance;
    }



    private Connection baglanti;

    public boolean veriTabaniniAc(){
        try{
            baglanti = DriverManager.getConnection(CONNECTION_STRING);

            return true;
        } catch (SQLException e) {
            System.out.println("Baglanti Saglanamadi");
            System.out.println("MESAJ : " + e.getMessage());
            System.out.println("ERROR CODE : " + e.getErrorCode());
            System.out.println("SQL STATE : " + e.getSQLState());
            return false;
        }
    }


    public void veriTabaniniKapat(){
        try {
            if (baglanti != null){
                baglanti.close();
            }
        } catch (SQLException e) {
            System.out.println("Baglanti kapanırken bir hata olustu.");
            e.printStackTrace();
        }
    }


    public ArrayList<Sarkici> tumSarkicilariGoster(int siralama) {
        /*
        StringBuilder sınıfı metinsel nesneleri birleştirmeye yarar. Ve String sınıfından daha performanslı bir yapıdadır.
        Çünkü String sınıfı immutable(Değişmez) bir sınıftır. Ve bundan ötürü her çalışmasında yeni bir String dizisi ortaya çıkar.
        Ama StringBuilder sınıfı her append olduğunda var olan yapının üzerine ekler.

        Aşağıdaki ifade ise;
        select * from SARKICI order by SARKICI_ADI asc / desc
         */
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLO_SARKICI);

        if (siralama == SIRALA_ARTAN){
            sb.append(" ORDER BY ");
            sb.append(SUTUN_SARKICI_ADI);
            sb.append(" ASC");
        }else {
            sb.append(" ORDER BY ");
            sb.append(SUTUN_SARKICI_ADI);
            sb.append(" DESC");
        }

        try
                (
                    Statement statement = baglanti.createStatement();
                    ResultSet resultSet = statement.executeQuery(sb.toString());
                ) {

            ArrayList<Sarkici> tumSarkicilar = new ArrayList<>();
            while (resultSet.next()){
                Sarkici sarkici = new Sarkici();
                sarkici.setSarkiciId(resultSet.getInt(SUTUN_SARKICI_ID));
                sarkici.setSarkiciAdi(resultSet.getString(SUTUN_SARKICI_ADI));
                tumSarkicilar.add(sarkici);
            }

            return tumSarkicilar;

        } catch (SQLException e) {
            System.err.print("Sorgu Basarisiz...!!!");
            e.printStackTrace();
        }

        return null;
    }
}
