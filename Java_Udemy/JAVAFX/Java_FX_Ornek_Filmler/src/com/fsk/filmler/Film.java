package com.fsk.filmler;

import java.time.LocalDate;

public class Film {
    private String adi;
    private String detay;
    private String tur;
    private LocalDate cikisTarihi;
    private String yonetmen;

    public Film(String adi, String detay, String tur, LocalDate cikisTarihi, String yonetmen) {
        this.adi = adi;
        this.detay = detay;
        this.tur = tur;
        this.cikisTarihi = cikisTarihi;
        this.yonetmen = yonetmen;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public LocalDate getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(LocalDate cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    @Override
    public String toString() {
        return getAdi();
    }
}
