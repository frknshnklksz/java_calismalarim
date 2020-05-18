/*
----- ABSTRACT CLASS'LAR -----
1) Ortak özelliği fazlaca olan alt sınıfları tek bir çatı altında toplamaya yarar.
2) Abstract sınıflardan nesne üretilmezler.
3) Herhangi bir sınıf abstract sınıfı extend ettiğinde somutlaşır.
4) Abstract sınıflarda herhangi bir method abstract olursa o sınıf abstract olur.
5) Hiç bir method olmayabileceği gibi birden fazla ve abstract olmayan methodlar da olabilir.
6) Abstract classlar ve methodlar static ve final olamazlar.
7) Üst sınıf abstract değilken alt sınıf abstrac olabilir.
8) Alt sınıflar abstract sınıfın abstract olan bütün methodlarını override etmek zorundadırlar.
9) Abstract methodların içi boş olur.
10) Kendi constructor'ları vardır.
 */
package com.EmreAltunbilek.Abstracts;
public class Abstracts {
    public static void main(String[] args) {
        GeometrikSekil kare = new Kare(5);
        kare.alanHesapla();
        kare.cevreHesapla();
        ((Kare)kare).kareyeOzguMethod();
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();
        GeometrikSekil dikdortgen = new Dikdortgen(7,8);
        dikdortgen.alanHesapla();
        dikdortgen.cevreHesapla();
        ((Dikdortgen)dikdortgen).dikdortgeneOzguMethod();
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();
        GeometrikSekil daire = new Daire(6);
        daire.alanHesapla();
        daire.cevreHesapla();
        ((Daire)daire).daireyeOzguMethod();
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();
        alanlariKarsilastir(dikdortgen,kare);
    }

    public static void alanlariKarsilastir(GeometrikSekil sekil1, GeometrikSekil sekil2){
        System.out.println(sekil1.getClass() + " sinifinin Alani : " + sekil1.getHesaplananAlan());
        System.out.println(sekil2.getClass() + " sinifinin Alani : " + sekil2.getHesaplananAlan());
        if (sekil1.getHesaplananAlan() < sekil2.getHesaplananAlan()){
            System.out.println("Birinci parametredeki nesnenin alani ikinci parametredeki nesne alanindan kucuktur.");
        }else if(sekil1.getHesaplananAlan() > sekil2.getHesaplananAlan()){
            System.out.println("Birinci parametredeki nesnenin alani ikinci parametredeki nesne alanindan buyuktur.");
        }else{
            System.out.println("Alanlar birbirine esittir.");
        }
    }
}

abstract class GeometrikSekil{
    private int birinciKenar;
    private int hesaplananAlan;

    public int getHesaplananAlan() {
        return hesaplananAlan;
    }

    public void setHesaplananAlan(int hesaplananAlan) {
        this.hesaplananAlan = hesaplananAlan;
    }

    public void setBirinciKenar(int birinciKenar) {
        this.birinciKenar = birinciKenar;
    }

    public int getBirinciKenar() {
        return birinciKenar;
    }

    abstract public void cevreHesapla();

    abstract public void alanHesapla();
}

class Kare extends GeometrikSekil{

    public Kare(int kenar) {
        this.setBirinciKenar(kenar);
    }

    @Override
    public void cevreHesapla() {
        System.out.println("Karenin cevresi : " + (getBirinciKenar() * 4));
    }

    @Override
    public void alanHesapla() {
        setHesaplananAlan((getBirinciKenar() * getBirinciKenar()));
        System.out.println("Karenin alani : " + getHesaplananAlan());
    }

    public void kareyeOzguMethod(){
        System.out.println("Kare sinifina ozgu method");
    }
}

class Dikdortgen extends GeometrikSekil{

    private int ikinciKenar;

    public Dikdortgen(int birinciKenar, int ikinciKenar) {
        setBirinciKenar(birinciKenar);
        this.ikinciKenar = ikinciKenar;
    }

    public int getIkinciKenar() {
        return ikinciKenar;
    }

    public void setIkinciKenar(int ikinciKenar) {
        this.ikinciKenar = ikinciKenar;
    }

    @Override
    public void cevreHesapla() {
        System.out.println("Dikdortgenin cevresi : " + 2 * (getBirinciKenar() + ikinciKenar));
    }

    @Override
    public void alanHesapla() {
        setHesaplananAlan((getIkinciKenar() * ikinciKenar));
        System.out.println("Dikdortgenin alani : " + getHesaplananAlan());
    }

    public void dikdortgeneOzguMethod(){
        System.out.println("Dikdortgen sinifina ozgu method");
    }
}

class Daire extends GeometrikSekil{

    public Daire(int yariCap) {
        setBirinciKenar(yariCap);
    }

    @Override
    public void cevreHesapla() {
        System.out.println("Dairenin cevresi : " + (2 * 3.14 * getBirinciKenar()));
    }

    @Override
    public void alanHesapla() {
        setHesaplananAlan((int)(3.14 * getBirinciKenar() * getBirinciKenar()));
        System.out.println("Dairenin Alani : " + getHesaplananAlan());
    }

    public void daireyeOzguMethod(){
        System.out.println("Daire sinifina ozgu method");
    }
}