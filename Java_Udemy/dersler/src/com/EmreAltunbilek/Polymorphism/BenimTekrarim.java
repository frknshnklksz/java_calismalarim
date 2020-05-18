package com.EmreAltunbilek.Polymorphism;
/*
Ust sinif tipinde bir alt sinif nesnesi ürettigimizde
->     UstSinif altSinif = new AltSinif();
altSinif nesnesi UstSinif'in methodlarina ulaşabilir ama
AltSinif'in methodlarina ulaşamaz.
 */
public class BenimTekrarim {
    public static void main(String[] args) {
        Arac araba2 = new Araba();
        methodCagirma(araba2);

        Otobus minibus2 = new Minibus();
        methodCagirma(minibus2);

        minibus2.koltukSayisiKacTane();

        Minibus minibus = new Minibus();
        minibus.MinibusRengi();
    }

    public static void methodCagirma(Arac arac){
        arac.sinifAdi();
    }
}

class Arac{
    private int tekerlekSayisi;

    public int getTekerlekSayisi() {
        return tekerlekSayisi;
    }

    public void setTekerlekSayisi(int tekerlekSayisi) {
        this.tekerlekSayisi = tekerlekSayisi;
    }

    public void sinifAdi(){
        System.out.println("Arac Sinifi");
    }
}
class Araba extends Arac{
    private String renk;

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public void sinifAdi() {
        System.out.println("Araba sinifi (Arac sinifindan extend edildi)");
    }
}
class Otobus extends Arac{
    private int muavinSayisi;

    public int getMuavinSayisi() {
        return muavinSayisi;
    }

    public void setMuavinSayisi(int muavinSayisi) {
        this.muavinSayisi = muavinSayisi;
    }

    @Override
    public void sinifAdi() {
        System.out.println("Otobüs sınıfı (Arac sinifindan extend edildi)");
    }

    public void koltukSayisiKacTane(){
        System.out.println("-OTOBUS SINIFI- nın koltuk sayisi 50");
    }
}
class Minibus extends Otobus {
    private int koltukSayisi;

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

    @Override
    public void sinifAdi() {
        System.out.println("Minibus Sinifi (Otobus sinifindan extend edildi)");
    }

    public void MinibusRengi(){
        System.out.println("-MINIBUS SINIFI- nın rengi kırmızı");
    }
}