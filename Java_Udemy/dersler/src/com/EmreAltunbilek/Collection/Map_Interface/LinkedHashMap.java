package com.EmreAltunbilek.Collection.Map_Interface;

import java.util.Map;

/*
---------------------- LINKEDHASHMAP ----------------------
***********************************************************
-> HashMap'ten en büyük farkı, veriler eklendiği sırayla listelenir.
-> initialCapacity'si vardır. Default olarak 16 verilir.
-> LoadFactor vardır. Tavsiye edilen 0.75f'tir.
-> accessOrder: varsayılan deger false'dır. True olursa veriler sırasız gösterilir.

 ÇALIŞMA MANTIĞI
----------------
Çalışma mantığı olarak HashMap'e oldukça benzer. Ama burada elemanların sırayla listelenmesi
için before ve after kavramları gelir. Bir LinkedHashMap oluşturulduğu zaman Header diye bir
alan oluşturulur. Bu header alanı ilk değerin before'udur. İlk değer de header'in after'ıdır.
 */
public class LinkedHashMap {
    public static void main(String[] args) {
        java.util.LinkedHashMap<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
        linkedHashMap.put("Furkan", 1);
        linkedHashMap.put(null, 2);
        linkedHashMap.put("Sahin", 3);
        linkedHashMap.put("Kulaksiz", 1);
        System.out.println(linkedHashMap);

        System.out.println("FOREACH methodu ile verileri key degerlerine gore gezmek");
        for (String temp:
             linkedHashMap.keySet()) {
            System.out.print(temp+",");
        }

        System.out.println();

        System.out.println("FOREACH methodu ile verileri value degerlerine gore gezmek");
        for (int gecici:
             linkedHashMap.values()) {
            System.out.print(gecici+",");
        }

        System.out.println();

        System.out.println("FOREACH methodu ile verileri entrylere gore gezmek");
        for (Map.Entry<String, Integer> entry:
             linkedHashMap.entrySet()) {
            System.out.print(entry+",");
        }
    }
}
