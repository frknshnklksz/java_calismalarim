package com.EmreAltunbilek.UdemyKursPlayerOrnek;

import java.util.ArrayList;

public class Kurs {
    private String kursAdi;
    private ArrayList<Ders> kurstakiDersler;
    private ArrayList<Egitmen> kursEgitmenleri;
    private ArrayList<Ogrenci> kursunOgrencileri;
    //Ders sayisi en az 5 ve toplam icerik en az 60 dakika olmali
    private boolean yayinda;

    public Kurs(String kursAdi, Egitmen basEgitmen) {
        this.kursAdi = kursAdi;
        this.kurstakiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>();
        this.kursunOgrencileri = new ArrayList<>();
        kursEgitmenleri.add(0,basEgitmen);
        this.yayinda = false;
    }

    public ArrayList<Ogrenci> getKursunOgrencileri() {
        return kursunOgrencileri;
    }

    public String getKursAdi() {
        return kursAdi;
    }

    public ArrayList<Ders> getKurstakiDersler() {
        return kurstakiDersler;
    }

    public void setKursunOgrencileri(ArrayList<Ogrenci> kursunOgrencileri) {
        this.kursunOgrencileri = kursunOgrencileri;
    }

    public void kursaEgitmenEkle(Egitmen yeniEgitmen){
        if (kursEgitmenleri.contains(yeniEgitmen)){
            System.out.println(yeniEgitmen.getIsim() + "isimli egitmen kurs egitmenlerine eklenmistir.");
            kursEgitmenleri.add(yeniEgitmen);
        }else{
            System.out.println(yeniEgitmen.getIsim() + "zaten bu kursta tanimlidir.");
        }

    }

    public void kurstanEgitmenSil(Egitmen silinecekEgitmen){
        if (silinecekEgitmen.getIsim().equals(kursEgitmenleri.get(0).getIsim())){
            System.out.println("Kursun ana egitmeni silinemez.");
        }else{
            System.out.println(silinecekEgitmen.getIsim() + "isimli egitmen kurs egitmenliginden kaldirilmistir.");
            kursEgitmenleri.remove(silinecekEgitmen);
        }

    }

    public void kursaDersEkle(Ders eklenecekDers){
        kurstakiDersler.add(eklenecekDers);
    }

    public int kurstakiDersSayisi(){
        return kurstakiDersler.size();
    }

    private int kurstakiToplamDerslerinDakikaSuresi(){

        double toplamSure = 0;
        for (Ders temp:
             kurstakiDersler) {
            toplamSure = toplamSure + temp.getDakika();
        }
        return (int)toplamSure;
    }

    public boolean kursYayindaKontrol(){
        if (kurstakiDersler.size() >= 5 && kurstakiToplamDerslerinDakikaSuresi() > 60){
            yayinda = true;
            return true;
        }else return false;
    }

}
