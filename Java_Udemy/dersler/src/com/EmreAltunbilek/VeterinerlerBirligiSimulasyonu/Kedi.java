package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

public class Kedi extends Hayvan {

    private String tur;
    private String cinsi;

    public Kedi(String dogumTarihi, boolean kayitli, String cinsi) {
        super(dogumTarihi, kayitli);
        this.tur = "KEDI";
        this.cinsi = cinsi;
    }

    @Override
    void bilgileriGoster() {
        System.out.println(toString() +
                "Kayitli mi? : " + isKayitli() + "Dogum Tarihi : " + getDogumTarihi());
    }

    @Override
    public String toString() {
        return "Kedi{" +
                "tur='" + tur + '\'' +
                ", cinsi='" + cinsi + '\'' +
                '}';
    }
}
