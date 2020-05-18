package com.EmreAltunbilek.Ic_Ice_Siniflar;
/*
                                        ---Anonymous Classlar---
*****************************************************************************************************************************
Elimizde bir tane sınıf olduğunu düşünün ve bu sınıfta sadece bir tane methodu değiştirmek istiyoruz.
Ama o sınıfı ya da omethodu değiştirdiğimizde başka bir sınıf etkilenmesin istemiyoruz.
Aşağıda bunu şu şekilde yaptık;
Yeni bir sınfıf oluşturduk. Ve extend ettik sonra istediğimiz methodu güncelledik.

Fakat bunun daha kolay yolu anonymous class'lar.

-> hesaplayici2 nesnesine dikkat edelim.
   Nesneyi oluşturduktan sonra sanki yeni bir sınıf oluşturuyormuşum gibi
   parantezleri açıp kapattıktan sonra kullanmak ya da güncellemek istediğim methodu override ediyorum.

-> Abstract class'larda ve interface'lerde de bu kullanım söz konusu.
   interface A olsun ve class B implements A olsun.
   B sınıfı interface'in her methodunu override etmek zorunda.
   Ama biz bu interface'i main de çağırıp methodları orada da güncelleyebiliriz.
   (Interface'lerden nesne üretilmez.)
   Aynı durum Abstract class'lar için de geçerlidir.


 */
public class Anonymous_Inner_classlar {
    public static void main(String[] args) {
        Hesaplayici hesaplayici = new Hesaplayici();
        hesaplayici.topla(4,7);

        YeniHesaplayici yeniHesaplayici = new YeniHesaplayici();
        yeniHesaplayici.topla(6,8);

        Hesaplayici hesaplayici2 = new Hesaplayici(){
            @Override
            public void topla(int s1, int s2) {
                System.out.println("Anonymous class ile olusturulan sinifin adi.");
                super.topla(s1, s2);
            }
        };

        hesaplayici2.topla(7,8);

        Canli canli = new Canli() {
            @Override
            void adiniSoyle() {
                System.out.println("Canli selam veriyor. (abstract anonymous)");
            }

            @Override
            void selamVer() {
                System.out.println("Ben isimsiz siniftaki selam ver methoduyum. (anonymous)");
            }
        };

        canli.adiniSoyle();
        canli.selamVer();

        Gecici gecici = new Gecici();
        gecici.adiniSoyle();
        gecici.selamVer();
        System.out.println("----------------------");
        Araba araba = new Araba() {
            @Override
            public void arabayiCalistir() {
                System.out.println("Araba Calisti.");
            }

            @Override
            public void kilometreBilgisi() {
                System.out.println("50000");
            }

            @Override
            public int topla(int sayi1, int sayi2) {
                System.out.println("Ben anonymous class'ım. Interface'den turedim");
                return sayi1 + sayi2;
            }
        };

        araba.arabayiCalistir();
        araba.kilometreBilgisi();
        System.out.println(araba.topla(9,6));





    }
}

class Hesaplayici{

    public void topla(int s1, int s2){
        System.out.println(s1 + s2);
    }
}

class YeniHesaplayici extends Hesaplayici{
    @Override
    public void topla(int s1, int s2) {
        System.out.println("Iki sayinin toplami");
        super.topla(s1, s2);
    }
}

abstract class Canli{
    abstract void adiniSoyle();
    void selamVer(){
        System.out.println("Merhaba");
    }
}

class Gecici extends Canli{

    @Override
    void adiniSoyle() {
        System.out.println("Gecici sinifi adini soyledi.");
    }

    @Override
    void selamVer() {
        System.out.println("Gecici sinifi selam verdi.");
    }
}

interface Araba{
    void arabayiCalistir();
    void kilometreBilgisi();
    default int topla(int sayi1, int sayi2){
        return sayi1+sayi2;
    }
}

class Otomobil implements Araba{

    @Override
    public void arabayiCalistir() {

    }

    @Override
    public void kilometreBilgisi() {

    }
}

