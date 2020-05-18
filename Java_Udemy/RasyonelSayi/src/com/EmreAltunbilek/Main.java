package com.EmreAltunbilek;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RasyonelSayi rasyonelSayi1 = new RasyonelSayi(3,4);
        System.out.println("Birinci Rasyonel Sayi : " + rasyonelSayi1);

        RasyonelSayi rasyonelSayi2 = new RasyonelSayi(4,5);
        System.out.println("Ikinci Rasyonel Sayi : " + rasyonelSayi2);

        RasyonelSayi rasyonelSayi3 = new RasyonelSayi(-4,7);
        System.out.println("Ucuncu rasyonel Sayi : " + rasyonelSayi3);


        RasyonelSayi toplam = rasyonelSayi1.topla(rasyonelSayi2);
        System.out.println(toplam);

        RasyonelSayi fark = rasyonelSayi1.cikar(rasyonelSayi2);
        System.out.println(fark);

        RasyonelSayi carp = rasyonelSayi1.carp(rasyonelSayi2);
        System.out.println(carp);

        RasyonelSayi bol = rasyonelSayi1.bolum(rasyonelSayi2);
        System.out.println(bol);

        RasyonelSayi[] rasyonelSayilar = {rasyonelSayi1, rasyonelSayi2, rasyonelSayi3};
        Arrays.sort(rasyonelSayilar); //rasyonelSayilardan sonra ", Collection.reverseOrder() dersek tersten sıralar."

        for (RasyonelSayi temp:
             rasyonelSayilar) {
            System.out.print(temp+",");
        }
    }
}
