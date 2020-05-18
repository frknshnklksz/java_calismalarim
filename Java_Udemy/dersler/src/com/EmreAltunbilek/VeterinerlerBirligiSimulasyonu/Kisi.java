package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

public abstract class Kisi {
    private String isim;
    private String tcKimlik;

    public Kisi(String isim, String tcKimlik) {
        this.isim = isim;
        this.tcKimlik = tcKimlik;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    abstract void kendiniTanit();

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tcKimlik='" + tcKimlik + '\'' +
                '}';
    }
}
