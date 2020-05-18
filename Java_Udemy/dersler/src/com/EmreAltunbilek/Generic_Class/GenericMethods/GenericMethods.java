package com.EmreAltunbilek.Generic_Class.GenericMethods;


/*
Sorulması Gereken Soru şu:
Generic Sınıf tanımlamalarında

public ClassName<T>{
...
}

diyip Hangi türün geleceğini belirliyoduk. Ya da gelen türlere göre runtime'da işlem yapıyordu.
Ama sadece ben methodun etkilenmesini istiyorum. Bunu nasıl yaparım.?
 */
public class GenericMethods {
    public static void main(String[] args) {
        String[] isimler = {"Furkan", "Ayse", "Sahin", "Kulaksiz", "Ali", "Zeynep"};
        Integer[] sayilar = {1,2,78,10,12,7,9,18};
        Character[] karakterler = {'a', 'q', 'e', 'f'};

        /*
        Aşağıdaki methodlar gereksiz kod kullanımına giriyor.
        Sonuçta hepsi dizi döndürmek üzere yazılmış methodlar.
         */
        stringDiziYazdir(isimler);
        System.out.println();
        integerDiziYazdir(sayilar);
        System.out.println();
        characterDiziYazdir(karakterler);
        System.out.println();
        System.out.println("------------------------");
        diziYazdir(isimler);
        System.out.println();
        diziYazdir(karakterler);
        System.out.println();
        diziYazdir(sayilar);
        System.out.println();
        System.out.println("------------------------");
        genericDiziYazdir(isimler);
        System.out.println();
        genericDiziYazdir(sayilar);
        System.out.println();
        genericDiziYazdir(karakterler);
    }


    /*
    Aşağıdaki method şunu söylüyor.
    "Buraya muhakkak CharSequence sınıfından extend edilmiş bir sınıf gelmeli." (String gibi)
     */
    public static <T extends CharSequence> void genericStringlerVeKarakterler(T[] dizi){
        for (T gecici:
             dizi) {
            System.out.print(gecici.length());
        }
    }

    /*
    aşağıdaki tanımlamış olduğum method sadece Number sınıfından türetilen sınıflara hizmet eder.
    Double, Float, Integer gibi.
    Bundan dolayı da aşağıdaki methoda String gibi dizileri parametre olarak gönderemeyiz.
     */
    public static <T extends Number> void genericNumaralar(T[] dizi){
        for (T gecici:
             dizi) {
            System.out.print(gecici + " - ");
        }
    }

    public static <T> void genericDiziYazdir(T[] dizi){
        for (T gecici:
             dizi) {
            System.out.print(gecici + " - ");
        }
    }

    /*
    Bir tane method tanımlıyorum ve method Obje türünde parametre alacak.
    Sebebi ise aşağıda aynı işi yapan 3 farklı methodu tek methoda düşürmek.
    Ama bunun sıkıntısı mesela String'e özgü methodları yapamıyoruz. Yani cast etmek gerekiyor.
    Ya da özel ifadelerden bahsedemeyiz. Bunun için generic için methodlar kullanıyoruz.
     */

    public static void diziYazdir(Object[] dizi){
        for (Object o:
             dizi) {
            System.out.print(o + " - ");
        }
    }

    public static void stringDiziYazdir(String[] dizi){
        for (String i:
             dizi) {
            System.out.print(i + " - ");
        }
    }

    public static void integerDiziYazdir(Integer[] dizi){
        for (Integer i:
                dizi) {
            System.out.print(i + " - ");
        }
    }

    public static void characterDiziYazdir(Character[] dizi){
        for (Character i:
                dizi) {
            System.out.print(i + " - ");
        }
    }
}
