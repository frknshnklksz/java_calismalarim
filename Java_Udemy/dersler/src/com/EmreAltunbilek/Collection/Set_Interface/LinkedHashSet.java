package com.EmreAltunbilek.Collection.Set_Interface;
/*
------------ LINKEDHASHSET ------------
***************************************

-> Arka tarafta linkedHashMep kullanır.
-> Elemanları ekleme sırasına göre gösterir.
 */
public class LinkedHashSet {
    public static void main(String[] args) {
        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("c");
        linkedHashSet.add("c");
        linkedHashSet.add("w");
        linkedHashSet.add("e");
        linkedHashSet.add("k");

        System.out.println(linkedHashSet);

    }
}
