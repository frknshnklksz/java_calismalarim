package com.EmreAltunbilek.UdemyKursPlayerOrnek;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi {

    private ArrayList<Kurs> katildigiKurslar;
    private LinkedList<Ders> izlenecekDersListesi;

    public Ogrenci(String isim, String tanitimYazisi, String kullaniciAdi) {
        super(isim, tanitimYazisi, kullaniciAdi);
        katildigiKurslar = new ArrayList<>();
        izlenecekDersListesi = new LinkedList<>();
    }

    public LinkedList<Ders> getIzlenecekDersListesi() {
        return izlenecekDersListesi;
    }

    public void kursaKatil(Kurs kurs){
        if (kurs.kursYayindaKontrol() == true){
            System.out.println(this.getIsim() + " adli ogrenci" + kurs.getKursAdi() + " adli kursa katildi");
            kurs.getKursunOgrencileri().add(this);
            katildigiKurslar.add(kurs);
        }else if(kurs.kursYayindaKontrol() == false){
            System.out.println(kurs.getKursAdi() + " yayinda degildir.");
        }else{
            if (kurs.kursYayindaKontrol() == true){
                for (Kurs temp:
                     katildigiKurslar) {
                    if (temp.getKursunOgrencileri().contains(this)){
                        System.out.println(this.getIsim() + "ogrenci"+ kurs.getKursAdi() +"kursa zaten kayitli.");
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return  super.toString() +  "Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }

    public void izlenecekDersEkle(Ders izlenecekDers){
        boolean dersBulundu = false;
        if (katildigiKurslar.size() > 0){
            for (Kurs temp:
                 katildigiKurslar) {
                if (temp.getKurstakiDersler().contains(izlenecekDers)){
                    System.out.println("Izlenecek listesine " + temp.getKursAdi() + " kursunda bulunan " + izlenecekDers.getDersBaslik() + " dersi eklendi" );
                    izlenecekDersListesi.add(izlenecekDers);
                    dersBulundu = true;
                    break;
                }
            }
            if (!dersBulundu){
                System.out.println("Girilen ders kurslarda bulunamadi ya da yetkisiz islem.");
            }
        }
    }
}
