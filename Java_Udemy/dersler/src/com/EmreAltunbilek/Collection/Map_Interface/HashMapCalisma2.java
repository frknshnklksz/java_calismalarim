package com.EmreAltunbilek.Collection.Map_Interface;

import java.util.HashMap;
import java.util.Iterator;

/*
-> initialCapacity: HashMap'lerde varsayılan olarak 16 değeri atanır.
-> loadFactor: bu değere mesela örnek olarak 0.5 girerseniz Java bunu şu şekilde algılar:
initialCapacity 16, loadFactor 0.5 => 16 * 0.5 = 8
Bu HashMap'e 8 tane değer eklerseniz HashMap'in capacity'si 32 olacaktır.
loadFactor için önerilen değer 0.75'tir. ve Yine önerilen olarak initalCapacity'ye 2'nin katı
bir değer girmek gerekir.
-> HashMap'te verileri eklenen sırayla görmek mümkün değildir. Gördüğümüz sıralama verilerin table'a ekleme sırasıdır.
 */
public class HashMapCalisma2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(16,0.75f);
        map.put("emre", 21);
        map.put("fb", 2);
        map.put(null, 123456);
        map.put("Ea", 3);

        System.out.println(map.get("Ea"));

        Iterator iterator = map.entrySet().iterator(); //Burada entrySet ile gezdik. Value ya da Key ile de gezebilirdik.
        while (iterator.hasNext()){                    // Diikat edilmesi gereken bir kural: iterator ile HashMap'i gezerken
            System.out.print(iterator.next()+",");     // döngü içerisinde silme ya da güncelleme yapılamaz.
        }
    }
}
