package com.EmreAltunbilek.Collection.Map_Interface;
/*
------------------------ MAP INTERFACE ------------------------
***************************************************************
-> List - Set - Queue - Map ( Collection frameworkundeki 4 temel interfaceden birisi)
-> Collection interface'sinden türememiştir. Kendisine özgü bambaşka bir yapıdadır.
-> key - value değerlerinden oluşur. Bu yapının toplam adı da entry'dir.
-> Map yapılarında her key değerinden bir tane olmalıdır ama value değerleri tekrar edebilir.
-> 3 tane somut sınıfı vardır. HashMap, LinkedHashMap, TreeMap

 HASHMAP
---------
* Eğer amacınız sadece key - value ilişkisine göre veri saklamaksa bu yapı kullanılmalıdır.
* Veriler eklenildiği gibi listelenmez. Buradaki değerlerin sıralanması valuelerin key değerlerinin
hashcode'una göre yapılmaktadır.
* Diğer sınıflara göre daha hızlı çalışır.
* Aynı key değerine ait 2 farklı veri olabilir ama key değerine göre get methodunu çağırdığımızda
en sonuncu değeri geri dönderir.
* key değeri null olaiblir.
* Value değerine göre ya da key değerine göre arama yapılabilir ama Büyük küçük harf duyarlıdır.
* Burada da equals ve hashcode methodları var ama bunlar Object sınıfından gelmiyor. İlgili interface'den geliyor.
* Boş bir HashMap oluşturduğumuzda varsayılan değeri 16 olan bir hashmap oluşturuluyor.
 */

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> plakalar = new java.util.HashMap<>();
        plakalar.put(6,"ANKARA"); // Veri ekleme işlemi put methodu ile yapılır.
        plakalar.put(34,"ISTANBUL");
        plakalar.put(42,"KONYA");
        plakalar.put(68,"AKSARAY");
        plakalar.put(35,"IZMIR");
        plakalar.put(16,"BURSA");
        plakalar.put(16,"BURSAIKI");

        System.out.println(plakalar);
        String deger = plakalar.get(6);
        System.out.println(deger);
        System.out.println(plakalar.isEmpty());
        System.out.println(plakalar.size());
        System.out.println(plakalar.get(16));
        System.out.println(plakalar.containsKey(10)); // Plakalar listesi 10 değerli key değerini içerir mi.?
        System.out.println(plakalar.remove(42)); //plakalar listesinden 42 key'ini siler ve ekranda burada gösterir.

        java.util.HashMap<Integer, String> plakalarYedek = new java.util.HashMap<>();
        System.out.println("plakalar yedek size : " + plakalarYedek.size());
        plakalar.putAll(plakalarYedek); // içine verilen map'e verileri birebir kopyalar.
        System.out.println("plakalar yedek size : " + plakalarYedek.size());

        System.out.println("KEY DEGERLERINE GORE DOLASMA");
        for (int i:
             plakalar.keySet()) {
            System.out.print("Keyler : " + i);
        }

        System.out.println();

        System.out.println("VALUE DEGERLERINE GORE DOLASMA");
        for (String i:
             plakalar.values()) {
            System.out.print("Degerler : " + i);
        }

        System.out.println();
        System.out.println("ENTRY DEGERLERINE GORE DOLASMA");
        for (Map.Entry<Integer, String> entry:
             plakalar.entrySet()) {
            System.out.println("KEY : " + entry.getKey() + "VALUE : " + entry.getValue());
        }
    }
}
