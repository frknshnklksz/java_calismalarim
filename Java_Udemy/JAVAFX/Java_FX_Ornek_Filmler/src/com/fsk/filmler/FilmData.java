package com.fsk.filmler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/*
Bu projede "singleton design pattern" kullanılacaktır.
Singleton: Var olan bir nesneyi, oluşturulan bir nesneyi
tekrar tekrar kullanmaktansa bir sefer için kullanmaya yarar.
Program her çalıştığında sadece bir tane instance üretecek.

Singleton Design pattern'da genelde sınıf içerisinde private ve static
olarak bir instance nesnesi üretilir. Ve bu instance nesnesi de yine
static olan bir method'la dışarıya açılır.

Consturctor'u private yaptık. Çünkü;
herhangi başka bir sınıfta
FilmData f1 = new FilmData();
FilmData f2 = new FilmData();
...
FilmData fn = new FilmData();
diyerek birden fazla nesne üretip singleton'a aykırı iş yapılabilir.
 */
public class FilmData {
    private static FilmData instance = new FilmData();
    private DateTimeFormatter formatter; // DateTimeFormatter bize girilen tarihin belirli bir değere göre girilmesini sağlayacak.
    private ObservableList<Film> filmListesi;

    private FilmData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 21-11-1994 tarzı bir tarih çıkartacak.
        /*
        Aşağıdaki blok bir arraylist olsaydı new arraylist diyerek sınıfı oluşturabilirdik. Ama
        observablelist bir interface. Bundan dolayı direk new diyerek oluşturamuıyoruz.
        Bundan dolayı observable interface'sini implemente etmiş bir sınıf kullandık.
         */
        filmListesi = FXCollections.observableArrayList(); // bu yapı filmlistesi = new Observable() demekle aynı şeydir diyebiliriz.
    }
    public static FilmData getInstance(){
        return instance;
    }

    // Uygulumada açışdığında dosyadan tüm filmleri getirip observable listeye atanır.
    public void dosyadanFilmleriGetir(){
        //Dosya içeriği şu şekilde olacak.
        //Filmin Adi \t Filmin Detayi \t Filmin Turu \t Filmin Cikis Tarihi \t Filmin Yonetmeni

        try(BufferedReader okuyucu = new BufferedReader(new FileReader("filmler.txt"))){
            String tekFilmSatir;
            while ((tekFilmSatir = okuyucu.readLine()) != null){
                String[] filmParcalari = tekFilmSatir.split("\t");
                String filmAdi = filmParcalari[0];
                String filmDetayi = filmParcalari[1];
                String filmTuru = filmParcalari[2];
                String filmCikisTarihi = filmParcalari[3];
                String filmYonetmeni = filmParcalari[4];

                LocalDate cikisTarihi = LocalDate.parse(filmCikisTarihi, formatter);

                Film okunanFilm = new Film(filmAdi, filmDetayi, filmTuru, cikisTarihi, filmYonetmeni);
                filmListesi.add(okunanFilm);
            }
            System.out.println(filmListesi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Uygulama kapatıldığında observable listedeki filmler dosyaya yazılır.
    public void dosyayaFilmleriYaz(){
        try(BufferedWriter yazici = new BufferedWriter(new FileWriter("filmler.txt"))){
            Iterator<Film> iterator = filmListesi.iterator();
            while (iterator.hasNext()){
                Film okunanFilm = iterator.next();
                yazici.write(String.format("%s\t%s\t%s\t%s\t%s\t", okunanFilm.getAdi(), okunanFilm.getDetay(), okunanFilm.getTur(), okunanFilm.getCikisTarihi().format(formatter), okunanFilm.getYonetmen()));
                yazici.newLine(); // Bir filmi okuduğu zaman aşağı geçer.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filmEkle(Film eklenecekFilm){
        filmListesi.add(eklenecekFilm);
    }

    public void filmSil(Film silinecekFilm){
        filmListesi.remove(silinecekFilm);
    }


    public ObservableList<Film> getFilmListesi() {
        return filmListesi;
    }
}
