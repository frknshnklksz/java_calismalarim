package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

import java.util.ArrayList;

public class SehirVeterinerlikBilgileri {
    private String sehir;
    private ArrayList<Veteriner> sehirdekiVeterinerler;
    private int toplamVeterinerSayisi;

    public SehirVeterinerlikBilgileri(String sehir) {
        this.sehir = sehir;
        sehirdekiVeterinerler = new ArrayList<>();
        toplamVeterinerSayisi = 0;
    }

    public void sehireVeterinerEkle(Veteriner veteriner){
        toplamVeterinerSayisi++;
        sehirdekiVeterinerler.add(veteriner);
    }

    public void sehirdekiToplamVeterinerSayisiniGoster(){
        System.out.println(sehir + " 'deki toplam veteriner sayisi : " + sehirdekiVeterinerler.size());
    }
}
