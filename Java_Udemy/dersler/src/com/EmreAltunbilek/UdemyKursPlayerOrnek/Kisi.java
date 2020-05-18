package com.EmreAltunbilek.UdemyKursPlayerOrnek;

public abstract class Kisi {
    private String isim;
    private String tanitimYazisi;
    private String kullaniciAdi;

    public Kisi(){

    }

    public Kisi(String isim, String tanitimYazisi, String kullaniciAdi) {
        this.isim = isim;
        this.tanitimYazisi = tanitimYazisi;
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getIsim() {
        return isim;
    }

    public String getTanitimYazisi() {
        return tanitimYazisi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tanitimYazisi='" + tanitimYazisi + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                '}';
    }
}
