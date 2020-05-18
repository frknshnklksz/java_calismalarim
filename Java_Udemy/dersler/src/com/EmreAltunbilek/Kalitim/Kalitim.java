package com.EmreAltunbilek.Kalitim;

public class Kalitim {
    public static void main(String[] args) {
        GeometrikSekil gs = new GeometrikSekil(6,7);
        gs.ozellikleriYazdir();
        System.out.println("----------------------");
        Dikdortgen d1 = new Dikdortgen(10,5);
        d1.ozellikleriYazdir();
        System.out.println("----------------------");
        Kare k1 = new Kare(8);
        k1.ozellikleriYazdir();
    }
}

class  GeometrikSekil{
    private int en;
    private int boy;

    public GeometrikSekil(int en, int boy) {
        this.en = en;
        this.boy = boy;
        System.out.println("Geometrik Sekil Dolu Constructor");
    }

    public GeometrikSekil() {
        System.out.println("Geometrik Sekil Bos constructor");
    }

    public GeometrikSekil(int en) {
        this.en = en;
        System.out.println("Geometrik Sekil Tek parametreli constructor");
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public int alanHesapla(){
        return getEn() * getBoy();
    }

    public int cevreHesapla(){
        return 2 * (getEn() + getBoy());
    }

    public void ozellikleriYazdir(){
        System.out.println("Sinifin Adi    : " + getClass());
        System.out.println("En bilgisi     : " + getEn());
        System.out.println("Boy bilgisi    : " + getBoy());
        System.out.println("Alan bilgisi   : " + alanHesapla());
        System.out.println("Cevre bilgisi  : " + cevreHesapla());
    }
}
class Dikdortgen extends GeometrikSekil{

    public Dikdortgen(){
        System.out.println("Dikdortgen Bos constructor");
    }

    public Dikdortgen(int en) {
        super(en);
        System.out.println("Dikdortgen tek parametreli constructor");
    }

    public Dikdortgen(int en, int boy) {
        setEn(en);
        setBoy(boy);
        System.out.println("Dikdortgen Dolu Constructor");
    }

    @Override
    public void ozellikleriYazdir() {
        super.ozellikleriYazdir();
    }
}
class Kare extends Dikdortgen{

    public Kare(){
        System.out.println("Kare Bos Constructor");
    }

    public Kare(int en) {
        super(en);
        setBoy(en);
        System.out.println("Kare dolu constructor");
    }
}
