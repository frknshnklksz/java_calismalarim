package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

public class Yonetim<T> {
    public void bilgileriGoster(T veri){
        System.out.println(veri);
    }

    public <T extends Musteri> void sahipOlduguHayvanlariGoster(T musteri){
        musteri.musteriHayvanlariniListele();
    }
}
