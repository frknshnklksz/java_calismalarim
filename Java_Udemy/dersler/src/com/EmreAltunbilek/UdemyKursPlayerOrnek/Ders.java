package com.EmreAltunbilek.UdemyKursPlayerOrnek;

public class Ders {
    private int dersNo;
    private String dersBaslik;
    private double dakika;

    public Ders(int dersNo, String dersBaslik, double dakika) {
        this.dersNo = dersNo;
        this.dersBaslik = dersBaslik;
        this.dakika = dakika;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "dersNo=" + dersNo +
                ", dersBaslik='" + dersBaslik + '\'' +
                ", dakika=" + dakika +
                '}';
    }

    public int getDersNo() {
        return dersNo;
    }

    public void setDersNo(int dersNo) {
        this.dersNo = dersNo;
    }

    public String getDersBaslik() {
        return dersBaslik;
    }

    public void setDersBaslik(String dersBaslik) {
        this.dersBaslik = dersBaslik;
    }

    public double getDakika() {
        return dakika;
    }

    public void setDakika(double dakika) {
        this.dakika = dakika;
    }
}
