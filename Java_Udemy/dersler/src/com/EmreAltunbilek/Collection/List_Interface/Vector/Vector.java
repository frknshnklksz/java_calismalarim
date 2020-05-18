package com.EmreAltunbilek.Collection.List_Interface.Vector;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/*
---------------------------------------- VECTOR SINIFI ----------------------------------------
***********************************************************************************************
-> ArrayList gibi dinamik olarak büyüyen ve küçülen bir yapı söz konusu.
-> ArrayList'ten en büyük farkı Vector methodları "synchronized" olarak tanımlanmıştır. Yani;
bir thread Vector listesinden bir veride işlem yaparken bir kilit koyar ve başka bir thread'in
ilgili Vector listesinde işlem yapmasına engel olur.
-> Eğer synchron bir Vector lazımsa "Collections.synchronizedList()" kullanabiliriz.
-> Başlangıç kapasitesi verileiblir.
 *****
 * ! *  ÖNEMLİ NOT: Initial capasity olarak bahsedilen değer şudur: Eğer bir listeye inital capasity
 *****              Verilmişse ve Liste o değeri aşmışsa capasity 2 kat arttırılır.
-> Tekrar eden verileri ve null değerlerini Vector listesinde tutabiliriz.
-> Bir "iterator" yardımıyla Vector sınıflarını dolaşabileceğimiz gibi
"ENUMERATION" kavramıyla da Vector listesi dolaşılabilir ve bu kavram Vector sınfına özgüdür.

 */
public class Vector {
    public static void main(String[] args) {
        java.util.Vector<String> sehirler = new java.util.Vector<>();
        sehirler.add("Ankara");
        sehirler.add("Istanbul");
        sehirler.add("Bursa");
        sehirler.add("Izmir");
        sehirler.add("Konya");

        System.out.println(sehirler.firstElement()); //ArrayListten farklı bir method
        System.out.println(sehirler.lastElement()); //ArrayListten farklı bir method

        //sehirler.setSize(20); // ArrayListten farklı olarak bu şekilde listenin size'ı arttırılabilir.

        System.out.println();
        System.out.println("\nIterator ile Vector Listesini dolaşmak");
        Iterator<String> listIterator = sehirler.iterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+",");
        }

        System.out.println("ENUMERATION ile Vector Listesini Dolaşma");

        Enumeration<String> enumeration = sehirler.elements();
        while (enumeration.hasMoreElements()){ //hasMoreElement() -> Daha gezilecek eleman varsa
            System.out.print(enumeration.nextElement()+",");
        }


    }
}
