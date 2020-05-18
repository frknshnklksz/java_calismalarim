package com.EmreAltunbilek.Polymorphism;

import java.net.URLStreamHandler;

public class ErkenStaticEarlyBinding {
    public static void main(String[] args) {

        /*
        Statikı methodlar override edilmezler. Sınıfa özgüdürler.
        Ama bu şekilde copy past ile kullanabiliriz.
        Sınıf adlarıyla da çağrılır. Nesnelerle de çağrılır.
         */
        System.out.println("Sınıf Adları ile methodların çağrılması");
        UstSinif.adiniSoyleStatic();
        AltSinif.adiniSoyleStatic();
        System.out.println("----------------------------------------");
        System.out.println("Nesneler ile methodların çağrılması");
        UstSinif ustSinif1 = new UstSinif();
        ustSinif1.adiniSoyleStatic();
        AltSinif altSinif1 = new AltSinif();
        altSinif1.adiniSoyleStatic();
        System.out.println("----------------------------------------");
        System.out.println("Peki polymorphism kullanırsak hangi method çağrılır.");
        /*
        Aşaüıdaki olay Erken / Static / Early Binding (Bağlama)
        Static ve final methodlar override edilmez.
        Bundan dolayı sınıf türü neyse gider oradaki methodu çalıştırır.
        Daha performanslıdır. Daha hızlıdır.
        Compiler Time'da çalışır. Çünkü daha compile anında hangi methodun çalıştırılacağı bellidir.
         */
        UstSinif ustSinif2 = new AltSinif();
        ustSinif2.adiniSoyleStatic();
    }
}

class UstSinif{
    public static void adiniSoyleStatic(){
        System.out.println("Ust sinifin statik adini soyle methodu cagrildi");
    }
}

class AltSinif extends UstSinif{
    public static void adiniSoyleStatic(){
        System.out.println("Ust sinifin statik adini soyle methodu cagrildi");
    }

}
