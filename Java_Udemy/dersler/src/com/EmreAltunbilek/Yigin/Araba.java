package com.EmreAltunbilek.Yigin;

public class Araba {
    private int MotorGucu;
    private String rengi;
    private String marka;
    private String model;
    private int fiyat;

    public Araba(int motorGucu, String kirmizi, String bmw, int i, int fiyat) {
    }

    public Araba(int motorGucu, String rengi, String marka, String model, int fiyat) {
        MotorGucu = motorGucu;
        this.rengi = rengi;
        this.marka = marka;
        this.model = model;
        this.fiyat = fiyat;
    }

    public int getMotorGucu() {
        return MotorGucu;
    }

    public void setMotorGucu(int motorGucu) {
        MotorGucu = motorGucu;
    }

    public String getRengi() {
        return rengi;
    }

    public void setRengi(String rengi) {
        this.rengi = rengi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "MotorGucu=" + MotorGucu +
                ", rengi='" + rengi + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
