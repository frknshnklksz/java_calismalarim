package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

import java.util.ArrayList;

public class Musteri extends Kisi {

    private String adres;
    private ArrayList<Hayvan> museriHayvanlari;

    public Musteri(String isim, String tcKimlik, String adres) {
        super(isim, tcKimlik);
        this.adres = adres;
        museriHayvanlari = new ArrayList<>();
    }

    public void musteriyeHayvanEkle(Hayvan hayvan){
        museriHayvanlari.add(hayvan);
        System.out.println(hayvan + " " + getIsim() + getIsim() + "Musterisine eklendi");
    }

    public void musteriHayvanlariniListele(){
        for (Hayvan h:
             museriHayvanlari) {
            System.out.println(h);
        }
    }

    @Override
    void kendiniTanit() {
        System.out.println(this.toString() + "MUSTERI");
    }

    @Override
    public String toString() {
        return super.toString() + "Musteri{" +
                "adres='" + adres + '\'' +
                '}' + " -> " + "MUSTERI";
    }
}
