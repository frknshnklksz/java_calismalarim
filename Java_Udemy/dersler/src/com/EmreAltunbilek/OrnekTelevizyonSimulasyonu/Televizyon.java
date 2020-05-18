package com.EmreAltunbilek.OrnekTelevizyonSimulasyonu;

import javax.swing.*;
import java.util.ArrayList;

public class Televizyon {
    private String marka;
    private String boyut;
    private ArrayList<Kanal> kanallar;
    private boolean acik;
    private int ses;
    private int aktifKanal;

    public Televizyon(String marka, String boyut) {
        this.marka = marka;
        this.boyut = boyut;
        kanallar = new ArrayList<>();
        kanallariOlustur();
        this.acik = false;
        ses = 10;
        aktifKanal = 1;
    }

    public void tvAc(){
        if(acik == false){
            System.out.println("TV Acildi");
            acik = true;
        }else{
            System.out.println("TV zaten acik");
        }
    }

    public void sesArttir(){
        if (ses <= 20 && acik == true){
            ses++;
            System.out.println("Ses Seviyesi : " + ses);
        }else{
            System.out.println("Ses MAXIMUM seviyede daha fazla arttiramazsiniz. Ya da televizyonunuz acik degil");
        }
    }

    public void sesAzalt(){
        if (ses >= 0 && acik){
            ses--;
            System.out.println("Ses Seviyesi : " + ses);
        }else{
            System.out.println("Ses MINIMUM seviyede daha fazla arttiramazsiniz. Ya da televizyonunuz kapali");
        }
    }

    public void tvKapat(){
        if (acik == true){
            acik = false;
            System.out.println("TV Kapandi.");
        }else{
            System.out.println("TV zaten kapali");
        }
    }

    private void kanallariOlustur() {
        HaberKanali haberKanali1 = new HaberKanali("CNN", 1, "Genel Haber");
        kanallar.add(haberKanali1);
        MuzikKanali muzikKanali1 = new MuzikKanali("Dream Turk", 2, "Yerli");
        kanallar.add(muzikKanali1);
        HaberKanali sporKanali1 = new HaberKanali("Bein Sport", 3, "Genel Haber");
        kanallar.add(sporKanali1);
        MuzikKanali muzikKanali2 = new MuzikKanali("Number One", 4, "Yabanci");
        kanallar.add(muzikKanali2);
    }

    public void kanalDegistir(int acilmasiniIstedigiKanal){
        if (acik){
            if(acilmasiniIstedigiKanal != aktifKanal){
                if(acilmasiniIstedigiKanal <= kanallar.size() && acilmasiniIstedigiKanal >= 0){
                    aktifKanal = acilmasiniIstedigiKanal;
                    System.out.println("Kanal : " + acilmasiniIstedigiKanal + " Bilgi : " + kanallar.get(aktifKanal - 1).toString());
                }else{
                    System.out.println("Gecerli bir kanal numarasini giriniz.");
                }
            }else{
                System.out.println("Zaten " + aktifKanal + " . kanaldasiniz. Degistirme yapilamadi");
            }
        }else{
            System.out.println("Once Televizyonu aciniz.");
        }
    }

    public void aktifKanaliGoster(){
        if (acik)
        System.out.println("Aktif kanal : " + kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
        else System.out.println("Once televizyonu aciniz.");
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    @Override
    public String toString() {
        return "Televizyon{" +
                "marka='" + marka + '\'' +
                ", boyut='" + boyut + '\'' +
                '}'+" olan televizyon oluşturuldu.";
    }
}
