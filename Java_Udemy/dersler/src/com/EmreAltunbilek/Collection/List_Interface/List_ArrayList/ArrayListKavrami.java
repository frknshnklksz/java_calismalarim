package com.EmreAltunbilek.Collection.List_Interface.List_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListKavrami {
    public static void main(String[] args) {
        //Bellekte 10 tane eleman tutan bir arrayList oluşturur.
        ArrayList<Integer> sayilar = new ArrayList<>();
        sayilar.add(1);
        sayilar.add(3);
        sayilar.add(8);
        sayilar.add(4);

        //Verdiğiginiz deger kadar eleman tutacak bir ArrayList oluştururç
        ArrayList<String> isimler = new ArrayList<>(3);
        isimler.add("Ayse");
        isimler.add("Furkan");
        isimler.add("Sahin");
        isimler.add("Fatma");
        isimler.add("Turgut");
        isimler.add("Salih");
        isimler.add("Zeynep");
        isimler.ensureCapacity(100); //ArrayList'in boyutunu var olduktan sonra 100 kadar arttırılır.
        isimler.trimToSize(); //ArrayList'in içindeki boş değerleri eleman sayısının boyutuna kadar siler.

        //ArrayList'e parametre olarak başka bir arraylist eklenir.
        ArrayList<String> isimlerYedek = new ArrayList<>(isimler);
        System.out.println(isimlerYedek);

        System.out.println(isimlerYedek.isEmpty()); //ArrayList'in dolu mu boş mu olduğunu döndürür. dolu ise false döndürür.

        isimlerYedek.clear(); //ArrayList'in içindeki elemanları siler.

        System.out.println(isimler.contains("Hasan")); //ArrayList'in içerisindeki değerin var olup olmadığını true ya da false diye döndürür.

        String[] isimlerDizisi = (String[]) isimler.toArray(new String[0]); //ArrayList'i diziye döndürür.

        System.out.println(isimler.get(2)); // 2 numaralı indexteki değeri okur.

        isimler.set(1, "Kulaksiz"); //1 numarali indeksi gunceller.
        isimler.add(3,"Ahmet"); // Belirtilen indekse Belirtilen veriyi ekler.

        isimler.remove("Ahmet"); //Belirtilen veriyi listeden siler.
        isimler.remove(0); //Verilen indeks numarasını listeden siler.

        //Aşağıdaki kod belirlenen indekslerdeki methodu yeni bir listeye aktarır.
        List<String> yeniIsimlerListesi = isimler.subList(2,5); //Sublist içinde verilen değerlerin arasındaki verileri yeni bir ArrayList'e atar. 5. indeks dahil değil
        System.out.println(yeniIsimlerListesi);

        //Aşağıdaki kod iki listeyi birleştirir.
        ArrayList<String> sehirler = new ArrayList<>();
        sehirler.add("Ankara");
        sehirler.add("Istanbul");
        sehirler.add("Izmir");
        sehirler.add("Bursa");

        ArrayList<String> renkler = new ArrayList<>();
        renkler.add("Kirmizi");
        renkler.add("Mavi");
        renkler.add("Yesil");
        renkler.add("Sari");
        renkler.add("Siyah");

        sehirler.addAll(renkler); // Burası iki listeyi birleştirir. (sonuna ekler)
        System.out.println(sehirler);

        sehirler.addAll(0,renkler); //renkler arrayList'ini basina ekler.

        //Array'i listeye donusturmek.
        String[] ulkeler = {"Turkiye", "Almanya", "Amerika", "Gana"};
        List<String> ulkelerListe;
        //1.yol
        Arrays.asList(ulkeler);

        //2.yol
        ArrayList<String> ulkelerListe2 = new ArrayList<>(Arrays.asList(ulkeler));

        //3.yol
        List<String> ulkelerListe3 = new ArrayList<>();
        Collections.addAll(ulkelerListe3, ulkeler);
    }
}
