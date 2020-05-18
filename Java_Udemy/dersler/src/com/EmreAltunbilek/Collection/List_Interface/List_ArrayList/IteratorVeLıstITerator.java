package com.EmreAltunbilek.Collection.List_Interface.List_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorVeLıstITerator {
    public static void main(String[] args) {
        ArrayList<Integer> sayilar1 = new ArrayList<>();
        sayilar1.add(1);
        sayilar1.add(2);
        sayilar1.add(3);
        sayilar1.add(4);
        sayilar1.add(5);

        ArrayList<Integer> sayilar2 = new ArrayList<>();
        sayilar2.add(4);
        sayilar2.add(5);
        sayilar2.add(6);
        sayilar2.add(7);
        sayilar2.add(8);

        System.out.println(sayilar1);
        System.out.println(sayilar2);
        System.out.println("For Dongusu ile Gezmek");
        for (int i = 0; i<sayilar1.size(); i++){
            System.out.print(sayilar1.get(i)+",");
        }

        System.out.println();

        System.out.println("ForEach ile Gezmek");
        for (int i:
             sayilar1) {
            System.out.print(i+",");
        }
        System.out.println();

        /*
        Aşağıdaki gibi bir durumda kod gayet mantıklı ama yanlış çalıştı.
        Sebebi;
        for döngüsünde i yi her seferinde arttırdığı için kontrol işlemi gerçekleşmiyor.
        Silme veya ekleme işlemleri için for döngüsü kullanılmaz.
         */
        /*System.out.println("Sayilar1 ve Sayilar2 listelerinde ortak olan elemanlar sayilar1 dizisinden cikarilsin.");
        for (int i = 0; i < sayilar1.size(); i++) {
            if (sayilar2.contains(sayilar1.get(i))){
                sayilar1.remove(i);
            }
        }
        System.out.println("Cikarilma isleminden sonra sayilar1 listesi");
        System.out.println(sayilar1);*/

        /*
        Yukarıdaki mantığın doğru çalışması için Iterator interface'sini kullanmak gerekir.
        */
        System.out.println("Iterator ile Listenin gezilmesi");
        Iterator<Integer> iterator = sayilar1.iterator(); //Bu method listeyi baştan sona teker teker "baştan->sona gezmemizi sağlar.
        while (iterator.hasNext()){ //hasNext() listenin sonuna gelip gelmediğimize bakar.
            //System.out.print(iterator.next()+","); // next() listenin başından başlayarak indeksin ilerlemesini sağlar.
            if (sayilar2.contains(iterator.next())){
                iterator.remove();
            }
        }
        System.out.println(sayilar1);
        System.out.println();
        /*
        iterator'u listlerde olduğu gibi kuyruklarda , setlerde v.s. kullanabiliyoruz.
        Ama listIterator daha da özelleştirilmiş. Sadece listlerde (ArrayList, LinkedList ...) kullanıyoruz.
        ListIterator Iterator interface'sinden türetilmiştir.
        iterator kullanırsak listeyi ya da dolaşmak isteyeceğimiz yapıyı baştan sona doğru dolaşabiliriz.
        Ama ListIterator ile listeyi sondan başa dolaşmamız da mümkündür.
         */
        System.out.println("List Iterator ile listeyi gezmek");
        ListIterator<Integer> listIterator = sayilar2.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println("Listeyi Sondan başa doğru gezmek");
        ListIterator<Integer> listIteratorSondanBasa = sayilar2.listIterator(sayilar2.size());
        while (listIteratorSondanBasa.hasPrevious()){
            //System.out.print(listIteratorSondanBasa.previous()+",");
            System.out.println("Index -> " + listIteratorSondanBasa.previousIndex() + " " + "Eleman - > " + listIteratorSondanBasa.previous());
        }
    }
}
