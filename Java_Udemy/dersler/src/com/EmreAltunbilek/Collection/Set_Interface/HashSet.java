package com.EmreAltunbilek.Collection.Set_Interface;
/*
------------------- SET INTERFACE -------------------
*****************************************************
-> Sadece birbirinden farklı verilerin tutulmasına izin verir.
-> Tekrar eden değerler bulunmaz.
-> Random bir veriye erişemeyiz. Verileri tek tek gezmemiz gerekir.,
-> Arka planda HashMap çalıştırır.
-> Sadece key değerleri tutulur. Value değerlerine ise boş bir Object nesnesi koyar.
-> Null değere izin verilmez.
-> Performans olarak en güçlüsü HASHSET'tir. Sonra LinkedHashset Sonra TreeSet.


 HASHSET
---------
-> Initial capacity ve load factory vardır
-> Arka planda hashmap kullanır.
 */
public class HashSet {
    public static void main(String[] args) {
        java.util.HashSet<String> harfler = new java.util.HashSet<>();
        harfler.add("a");
        harfler.add("a");
        harfler.add("a");
        harfler.add("c");
        harfler.add("c");
        harfler.add("w");
        harfler.add("e");
        harfler.add("k");
        System.out.println(harfler);
        // Birbiriyle aynı verileri eklememe rağmen her birisinden bir defa gösterdi.
    }
}
