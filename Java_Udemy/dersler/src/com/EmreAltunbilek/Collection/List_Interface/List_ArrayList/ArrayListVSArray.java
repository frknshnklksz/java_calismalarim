package com.EmreAltunbilek.Collection.List_Interface.List_ArrayList;

import java.util.ArrayList;

public class ArrayListVSArray {
    public static void main(String[] args) {
        ArrayList<String> isimlerListesi = new ArrayList<>();
        String[] isimlerDizisi = new String[900000];

        long baslamaZamani = System.currentTimeMillis();
        //Dizi elemanlari atanir.
        for (int i = 0; i <900000 ; i++) {
            isimlerDizisi[i] = "deneme" + i;
        }
        long bitisZamani = System.currentTimeMillis();

        System.out.println("Dizi calisma suresi : " + (bitisZamani - baslamaZamani));


        baslamaZamani = System.currentTimeMillis();
        //Listeye elemanlari atanir.
        for (int i = 0; i <900000 ; i++) {
            isimlerListesi.add("deneme" + i);
        }
        bitisZamani = System.currentTimeMillis();

        System.out.println("ArrayList calisma suresi : " + (bitisZamani - baslamaZamani));

        System.out.println("----------------------");

        baslamaZamani = System.currentTimeMillis();
        isimlerDizisi[85482] = "yeniDeger";
        bitisZamani = System.currentTimeMillis();
        System.out.println("Dizi test : " + (bitisZamani - baslamaZamani));
        baslamaZamani = System.currentTimeMillis();
        isimlerListesi.add(85482,"yeniDeger");
        bitisZamani = System.currentTimeMillis();
        System.out.println("ArrayList test : " + (bitisZamani - baslamaZamani));
     }
}
