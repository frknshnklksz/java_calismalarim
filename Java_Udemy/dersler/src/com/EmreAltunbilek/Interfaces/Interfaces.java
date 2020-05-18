/*
---- INTERFACE'LER ----
1) Farklı yapıdaki class'ları bir arada tutar.
2) Methotların sadece tanımları olur. İçleri boş olmalıdır.
3) Bir interface'i implement eden methotlar interface'in bütün methodlarını override etmelidir.
4) Bir interface ile bir sınıf arasında kalıtım ilişkisi olmasa bile interface türünde bir nesne oluşturulabilir.
Hayvan diye bir interface olsun ve Araba sınıfı Hayvan interface'sini implements etsin.
Hayvan nesne = new Hayvan(); diyebiliriz.
5) Interface'in içindeki methodlar varsayılan olarak public'tir.
6) Interface'lerden nesne üretilmez.
7) Interface'lerin icinde degisken tanımı yapılabilir ama muhakkak ilk değeri verilmelidir.
8) Interface'lerin içindeki tanımlanan değişkenler default olarak static ve finaldir.
9) Herhangi bir constructor'a sahip değillerdir.
10) Degişkenler static olduğu için alt sınıflarda direk interface adıyla ulaşabiliriz.
11) Interface'i implements eden abstract class'lar interface'in methodlarını almak zorunda değillerdir.
Ama abstract class'ı extend eden alt sınıflar interface'in tüm methodlarını override etmek zorundadır.
12) Bir interface baska bir interface'i extend edebilir. Ama bir alt sınıf her iki interface'in de methotlarını kullanmak zorunda.
13) Bir interface birden fazla interface'i extend edebilir.
14) Bir interface'de "default" anahtar kelimesini kullanarak içi dolu bir method tanımı yapabiliyoruz.
Ve bu içi dolu methodu alt sınıflar override etmek zorunda değiller.
Ama override edilirse de gayet güzel override edilip kullanılabilir. ( JAVA 8 ile beraber gelen br,ir özellik )
15) Interface'ler 100% abstract yapılardır.
16) Normalde interface'lerin içinde statik methotlar tanımlanmaz. Ama JAVA 8 ile beraber bu durum ortadan kalktı.
Ama statik olarak tanımlanmış method override edilmez.
17) interface'lerin içinde statik bloklar olamaz.
static {
...
} seklinde
18) Sadece tek bir fonksiyonu bulunan interface'e functional interface denir.
19) Bir interface içinde hiç bir metot tanımı yapılmamışsa bunlara Marker Interface denir. (Clonable ve Serializable)
 */

package com.EmreAltunbilek.Interfaces;

import com.EmreAltunbilek.Yigin.Ogrenci;

import java.util.ArrayList;

public class Interfaces {
    public static void main(String[] args) {
        MuslumBaba muslum = new MuslumBaba();
        muslum.dansEt();

        PopSarkicilarinOzellikleri popSarkici1 = new Tarkan();
        PopSarkicilarinOzellikleri popSarkici2 = new Hadise();

        PopSarkicilarinOzellikleri dizi[] = new PopSarkicilarinOzellikleri[5];
        dizi[0] = popSarkici1;
        dizi[1] = popSarkici2;

        ArrayList<PopSarkicilarinOzellikleri> sarkicilar = new ArrayList<>();
        sarkicilar.add(popSarkici1);
        sarkicilar.add(popSarkici2);

        popSarkici1.adiniSoyle();

    }
}

interface Kisi{
    void yemekYe();
    void sporYap();
    default void adiniSoyle(){
        System.out.println("Ben kisi interface'siyim.");
    }
}

interface Arac{
    static void staticMethod(){
        System.out.println("Ben Arac interface'indeki static methodum.");
    }
}

class Araba implements Arac{

}

interface OgrenciOzellikleri extends Kisi, UniversiteOgrencisi{
    void dersCalis();
    void okulaGit();
}

interface UniversiteOgrencisi{
    void finallereCalis();
}

class Student implements OgrenciOzellikleri{

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }

    @Override
    public void dersCalis() {

    }

    @Override
    public void okulaGit() {

    }

    @Override
    public void finallereCalis() {

    }
}

abstract class Sarkici implements Kisi{
    abstract void sarkiSoyle();
}

interface ArabeskSarkicilarinOzellikleri {
    void sahnedeSigaraIc();
}

interface PopSarkicilarinOzellikleri extends Kisi {
    void dansEt();
}

class ArabeskSarkici extends Sarkici{

    @Override
    void sarkiSoyle() {
        System.out.println("Arabesk Sarkici sarki soyluyor.");
    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}

class PopSarkici extends Sarkici{

    @Override
    void sarkiSoyle() {
        System.out.println("Pop Sarkici sarki soyluyor.");
    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}

class Hadise implements PopSarkicilarinOzellikleri{

    @Override
    public void dansEt() {

    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}

class Tarkan implements PopSarkicilarinOzellikleri{

    @Override
    public void dansEt() {

    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}

class MuslumBaba implements ArabeskSarkicilarinOzellikleri, PopSarkicilarinOzellikleri {

    @Override
    public void sahnedeSigaraIc() {

    }

    @Override
    public void dansEt() {

    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }

    @Override
    public void adiniSoyle() {

    }
}
