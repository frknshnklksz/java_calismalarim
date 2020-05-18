package com.EmreAltunbilek.Polymorphism;

public class InstanceOf_PolymorphismOlmasaydi {
    public static void main(String[] args) {

        System.out.println("############# Nesneler Üzerinden Bilgileri Yazdirma #############");
        GeometrikSekil gs = new GeometrikSekil(4,5);
        gs.bilgileriYazdir();
        System.out.println("------------------------------------");
        Dikdortgen d = new Dikdortgen(6,7);
        d.bilgileriYazdir();
        System.out.println("------------------------------------");
        Kare k = new Kare(5);
        k.bilgileriYazdir();
        System.out.println("------------------------------------");
        System.out.println("############# Methodlar Üzerinden Bilgileri Yazdirma #############");
        bilgileriEkranaGetir(gs);
        System.out.println("------------------------------------");
        bilgileriEkranaGetir(d);
        System.out.println("------------------------------------");
        bilgileriEkranaGetir(k);
        System.out.println("------------------------------------");
        Daire daire = new Daire(5);
        daire.bilgileriYazdir();

        GeometrikSekil gs2 = new Kare(9); //implict
        GeometrikSekil gs3 = new Dikdortgen(9,4);
        Dikdortgen d3 = new Kare(4);

        System.out.println("********************");
        d3 = (Dikdortgen)gs3; //explict , down casting
        d3.bilgileriYazdir();
        System.out.println("********************");
        // büyük olan şeyi küçük olana çevirme

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("En asagiya in");
        System.out.println("+++++++++++++++++++++++++++++++++");
        bilgileriEkranaGetir(gs2);
        bilgileriEkranaGetir(d3);

    }

    public static void bilgileriEkranaGetir(GeometrikSekil sekil){
        //Polymorphism olmasaydı
        /*
        Görüldüğü gibi sürekli if bloğu çalıştı
        Mantıklı bir yapı kurmamıza rağmen polymorphism i iptal edemedik.
         */
        /*if(sekil instanceof GeometrikSekil){
            sekil.bilgileriYazdir();
            System.out.println("Geometrik Sekil icindeki bilgileri yazdir methodu cagrildi.");
        }else if(sekil instanceof Dikdortgen){
            Dikdortgen gecici = (Dikdortgen) sekil;
            gecici.bilgileriYazdir();
            System.out.println("Dikdortgen icindeki bilgileri yazdir cagrildi");
        }else {
            Kare gecici = (Kare)sekil;
            gecici.bilgileriYazdir();
            System.out.println("Kare icindeki bilgileri yazdir cagrildi");
        }*/

        /*
        Yukarıdaki olayı tamamen ezmek için
        if bloğuna en alt sınıftan yazmaya başlamak lazım.
         */

        if(sekil instanceof Kare){
            Kare gecici = (Kare)sekil;
            gecici.bilgileriYazdir();
        }else if (sekil instanceof Dikdortgen){
            Dikdortgen gecici = (Dikdortgen) sekil;
            gecici.bilgileriYazdir();
        }else{
            sekil.bilgileriYazdir();
        }

        //sekil.bilgileriYazdir(); -> Bu method polymorphism varken
    }
}

class GeometrikSekil{
    private int en;
    private int boy;

    public GeometrikSekil(){
        System.out.println("Geometrik Sekil Sinifinin bos constructor'u");
    }

    public GeometrikSekil(int en) {
        System.out.println("Geometrik Sekil Sinifinin tek parametre alan constror'u");
        this.en = en;
    }

    public GeometrikSekil(int en, int boy) {
        System.out.println("Geometrik Sekil Sinifinin dolu constructor'u");
        this.en = en;
        this.boy = boy;
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
        return getBoy() * getEn();
    }

    public int cevreHesapla(){
        return 2 * (getBoy() + getEn());
    }

    public void bilgileriYazdir(){
        System.out.println("Sinif Bilgisi  : " + getClass());
        System.out.println("En bilgisi     : " + getEn());
        System.out.println("Boy bilgisi    : " + getBoy());
        System.out.println("Alan Bilgisi   : " + alanHesapla());
        System.out.println("Cevre Bilgisi  : " + cevreHesapla());
    }
}
class Dikdortgen extends GeometrikSekil{

    public Dikdortgen(){
        System.out.println("Dikdortgen sinifi bos constructor");
    }

    public Dikdortgen(int en) {
        super(en);
        System.out.println("Dikdortgen sinifi tek parametre alan constructor");
    }

    public Dikdortgen(int en, int boy) {
        setBoy(boy);
        setEn(en);
        System.out.println("Dikdortgen sinifi dolu constructor");
    }

    @Override
    public void bilgileriYazdir() {
        super.bilgileriYazdir();
    }
}
class Kare extends Dikdortgen{

    public Kare(){
        System.out.println("Kare Sinifi Bos constructor");
    }

    public Kare(int en) {
        super(en);
        setBoy(en);
        System.out.println("Kare Sinifi Dolu constructor");
    }

    @Override
    public void bilgileriYazdir() {
        super.bilgileriYazdir();
    }
}
class Daire extends GeometrikSekil{
    public Daire(){
        System.out.println("Daire Sinifi Bos constructor");
    }
    public Daire(int en) {
        super(en);
        setBoy(en);
        System.out.println("Daire sinifi bos constructor");
    }

    @Override
    public int cevreHesapla() {
        return 2*3*getEn();
    }

    @Override
    public int alanHesapla() {
        return getEn()*getEn()*3;
    }
}