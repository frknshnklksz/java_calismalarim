package com.EmreAltunbilek.Collection.Sorted_Navigable_Interfaceleri;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


public class SortedNavigableInterfaceMEthodlari {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");
        treeSet.add("5");


        //Sadece tree'ler icin gecerli
        //Sort Interface'i Setler icin -> SortedSet Mapler icin -> SortedMap

        System.out.println(treeSet.comparator());

        TreeSet<String> yedekSet = (TreeSet<String>) treeSet.subSet("2","5"); //subSet bir alt set ooluşturur. İlk verdiğimiz değer dahil
        System.out.println(yedekSet);                                         // son verdiğimiz değer dahil değil.

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        System.out.println(treeMap.comparator());
        treeMap.put("1",1);
        treeMap.put("2",2);
        treeMap.put("3",3);
        treeMap.put("4",4);
        treeMap.put("5",5);

        System.out.println(treeMap.subMap("2","4"));

        System.out.println(treeMap.headMap("5"));      // Baştan başlayarak verdiğimiz indexe kadar olan bütün elemanlari yazdirir.
        System.out.println(treeSet.headSet("3"));  // Olmayan bir indeks verirsek bütün listeyi yazdıırır.

        System.out.println(treeMap.tailMap("3"));     //3.degerden basla listenin sonuna kadar git.
        System.out.println(treeSet.tailSet("4")); //4. degerden basla ve listenin sonuna kadar git.

        System.out.println(treeMap.lastEntry());  // Son entry'yi elde ettik., Bunu First dieyerek key ve value için de yapabiliriz.
        System.out.println(treeSet.last()); // Son index. Aynı şekilde first değerlerine de ulaşabiliriz.


        //----------------- NAVIGABLESET ve NAVIGABLEMAP METHODLARI -----------------
        //***************************************************************************

        System.out.println(treeSet.lower("3")); //3 ten daha düsük olan en büyük degeri yazdirir.
        System.out.println(treeMap.lowerKey("4")); //4 ten daha düsük olan en büyük degeri yazdirir.

        System.out.println(treeSet.lower("7")); // Verilen key değerine eşit veya ondan bir küçük değeri döndürür.
        System.out.println(treeMap.lowerKey("7")); // Verilen key değerine eşit veya ondan bir küçük değeri döndürür.

        System.out.println(treeSet.ceiling("4")); //Verilen key değerine eşit veya ondan bir bütük elemani getirir.
        System.out.println(treeMap.ceilingKey("4")); //Verilen key değerine eşit veya ondan bir bütük elemani getirir.

        System.out.println(treeSet.higher("2")); //Bir büyük değeri verir.
        System.out.println(treeMap.higherKey("2")); //Bir büyük değeri verir.


        System.out.println(treeSet.pollFirst()); // Veri yapısındaki ilk degeri gösterir ve yapıdan kaldırır.

        System.out.println(treeSet.pollLast()); // Veri yapısındaki son elemanı gösterir ve yapıdan kaldırır.

        Iterator<String> iterator = treeSet.descendingIterator(); // Veri yapısını tersten listeler.
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }
}
