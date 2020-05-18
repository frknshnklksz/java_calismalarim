package com.EmreAltunbilek.Yigin;

public class Ogrenci {
    private int numara;
    private String isim;
    private String soyIsım;

    public Ogrenci() {
    }

    public Ogrenci(int numara, String isim, String soyIsım) {
        this.numara = numara;
        this.isim = isim;
        this.soyIsım = soyIsım;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsım() {
        return soyIsım;
    }

    public void setSoyIsım(String soyIsım) {
        this.soyIsım = soyIsım;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "numara=" + numara +
                ", isim='" + isim + '\'' +
                ", soyIsım='" + soyIsım + '\'' +
                '}';
    }
}
