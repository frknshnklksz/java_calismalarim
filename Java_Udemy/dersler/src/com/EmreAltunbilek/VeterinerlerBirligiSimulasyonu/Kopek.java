package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

public class Kopek extends Hayvan {

    private int asiSayisi;
    private String tur;
    private String cinsi;


    public Kopek(String dogumTarihi, boolean kayitli, int asiSayisi, String cinsi) {
        super(dogumTarihi, kayitli);
        setAsiSayisi(asiSayisi);
        this.tur = "KOPEK";
        this.cinsi = cinsi;
    }

    @Override
    void bilgileriGoster() {
        System.out.println(toString() +" " +  super.toString());
    }

    public int getAsiSayisi() {
        return asiSayisi;
    }

    public void setAsiSayisi(int asiSayisi) {
        if (asiSayisi < 0){
            System.err.print("Asi sayisi 0'dan kucuk bir deger olamaz.");
            System.err.print("Asi sayisi varsayilan olarak 0 degerine atandi.");
        }else{
            this.asiSayisi = asiSayisi;
        }
    }

    @Override
    public String toString() {
        return "Kopek{" +
                "asiSayisi=" + asiSayisi +
                ", tur='" + tur + '\'' +
                ", cinsi='" + cinsi + '\'' +
                '}';
    }
}
