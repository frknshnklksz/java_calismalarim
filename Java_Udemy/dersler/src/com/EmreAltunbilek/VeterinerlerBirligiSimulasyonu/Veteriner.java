package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

import java.util.ArrayList;

public class Veteriner extends Kisi {

    public String mezunOlduguOkul;
    private int calismaSuresi;
    private ArrayList<Musteri> veterinerMusterileri;
    private int musteriSayisi;

    public Veteriner(String isim, String tcKimlik, String mezunOlduguOkul, int calismaSuresi) {
        super(isim, tcKimlik);
        this.mezunOlduguOkul = mezunOlduguOkul;
        this.calismaSuresi = calismaSuresi;
        veterinerMusterileri = new ArrayList<>();
        musteriSayisi = 0;
    }

    public void musteriekle(Musteri musteri){
        veterinerMusterileri.add(musteri);
        musteriSayisi++;
    }

    public void musterileriListele(){
        for (Musteri m:
             veterinerMusterileri) {
            m.kendiniTanit();
        }
    }

    @Override
    void kendiniTanit() {
        System.out.println(toString() + "VETERINER");
    }


    @Override
    public String toString() {
        return "Veteriner{" +
                "mezunOlduguOkul='" + mezunOlduguOkul + '\'' +
                ", calismaSuresi=" + calismaSuresi +
                ", musteriSayisi=" + musteriSayisi +
                '}';
    }
}
