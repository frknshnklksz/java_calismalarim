package com.EmreAltunbilek.Generic_Class.GenericClass;


import java.util.ArrayList;

/*
Genellikle aynı işi yapan fakat farklı türdeki parametre alan sınıf ve methodlarda kullanılır.
Mesela aşağıdaki örnekte 3 farklı tipte dizi tanımladık ve her birisi için ayrı bir sınıf oluşturduk.
Genericler bizi bu kod kalabalığından kurtarıyor.
Genericler ile çalışırken primitive tiplerle çalışamıyoruz.
Primitive tiplerin wrapper sınıflarıyla çalışmamız gerekmektedir.

Genellikle <> arasına T harfi gelir. <T> şeklinde

Bu Genericler bize java 5 te gelen bir özellik.

 */
public class Genericler {
    public static void main(String[] args) {
        String[] isimler = {"Furkan", "Sahin", "Kulaksiz"};
        Integer[] sayilar = {1,2,6,5,3,2};
        Character[] karakterler = {'a', 'c', 'f'};

        /*
        StringDiziYazdir.yazdir(isimler);
        IntegerDiziYazdir.yazdir(sayilar);
        CharDiziYazdir.yazdir(karakterler);
         */
        System.out.println("------------------------------------------------------");
        GenericDiziYazdir<String> stringGenericDiziYazdir = new GenericDiziYazdir<>();
        stringGenericDiziYazdir.yazdir(isimler);

        GenericDiziYazdir<Integer> integerGenericDiziYazdir = new GenericDiziYazdir<>();
        integerGenericDiziYazdir.yazdir(sayilar);

        GenericDiziYazdir<Character> characterGenericDiziYazdir = new GenericDiziYazdir<>();
        characterGenericDiziYazdir.yazdir(karakterler);
        System.out.println("------------------------------------------------------");

        ArrayList sehirler = new ArrayList();
        sehirler.add("Ankara");
        sehirler.add("Istanbul");
        sehirler.add("Izmir");

        for (Object i:
             sehirler) {
            System.out.print(i + " ,");
        }

        sehirler.add(2);
        sehirler.add(7.8);
        for (Object i:
                sehirler) {
            System.out.print(i + " ,");
        }

        System.out.println();
        /*
        Yukarıdaki ArrayList'te sadece şehirler tutmama rağmen double, float vs..
        gibi Obje'ler ekleyebiliyorum. Ama generic kullanırsam sadece String ifadeler ekleyebilirim.
         */

        ArrayList<String> programlamaDilleri = new ArrayList<>();
        programlamaDilleri.add("JAVA");
        programlamaDilleri.add("C");
        programlamaDilleri.add("JAVASCRIPT");
        programlamaDilleri.add("PYTHON");

        for (String i:
             programlamaDilleri) {
            System.out.print(i + " ,");
        }

    }
}
