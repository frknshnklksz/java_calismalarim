package com.EmreAltunbilek.Yigin;

public class Memur {
    private int yasi;
    private String adi;
    private String soyadi;
    private String depertman;
    private int maas;

    public Memur() {
    }

    public Memur(int yasi, String adi, String soyadi, String depertman, int maas) {
        this.yasi = yasi;
        this.adi = adi;
        this.soyadi = soyadi;
        this.depertman = depertman;
        this.maas = maas;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getDepertman() {
        return depertman;
    }

    public void setDepertman(String depertman) {
        this.depertman = depertman;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "Memur{" +
                "yasi=" + yasi +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", depertman='" + depertman + '\'' +
                ", maas=" + maas +
                '}';
    }
}
