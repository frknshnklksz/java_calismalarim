package com.EmreAltunbilek.Collection.Map_Interface;

import java.util.Comparator;

/*
----------------------- TREE MAP -----------------------
********************************************************
-> Verileri kendi belirlediğimiz yönteme göre sıralamak istiyorsak kullanmamız gereken yapı.
->
 */
public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();

        treeMap.put("furkan", 1);
        treeMap.put("sahin", 2);
        treeMap.put("kulaksiz", 3);
        treeMap.put("ayse", 4);
        treeMap.put("veli", 5);
        System.out.println(treeMap);


        java.util.TreeMap<Kare, String> kareStringTreeMap = new java.util.TreeMap<>(new Comparator<Kare>() {
            @Override
            public int compare(Kare kare, Kare t1) {
                if (kare.kenar > t1.kenar){
                    return 1;
                }else if(kare.kenar < t1.kenar){
                    return -1;
                }else return 0;
            }
        });
        Kare kare1 = new Kare(4,"Kirmizi");
        Kare kare2 = new Kare(2,"Yesil");
        Kare kare3 = new Kare(6,"Mavi");

        kareStringTreeMap.put(kare1, "kirmizi kare");
        kareStringTreeMap.put(kare2, "yesil kare");
        kareStringTreeMap.put(kare3, "mavi kare");

        System.out.println(kareStringTreeMap);

        System.out.println();
        System.out.println(kareStringTreeMap.lowerKey(kare1)); // kare1 nesnesinin değerinden daha düşük olan nesneleri gösterir.
        System.out.println(kareStringTreeMap.higherKey(kare1)); // kare1 nesnesinin değerinden daha büyük olan nesneleri gösterir.
        /*
        Yukarıdaki kareStringTreeMap yapısını sout ile yazdırırken hata alırız. Çünkü bu yapıda
        kendi oluşturduğumuz bir yapı var ve bu yapı Comparable interfacesinden compareTo methodunu override
        etmiyor.
        String sınıfı ve diğer wrapper sınıflar bu yapıyı impelemente edip override ettikleri için
        hata almadan çalışır. Ama burada çalışmaz.
        Çalışması için ya sınıfımızı comparable interface'si ile implemente etmeliyiz. Ya da yapımızın constructor'unda
        anonim inner class ile Comparator interface'sini çağırmalıyız.
         */
    }
}

class Kare implements Comparable{
    int kenar;
    String renk;

    public Kare(int kenar, String renk) {
        this.kenar = kenar;
        this.renk = renk;
    }

    @Override
    public String toString() {
        return "Kare{" +
                "kenar=" + kenar +
                ", renk='" + renk + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Kare gecici = (Kare)o;
        if (gecici.kenar < this.kenar){
            return -1;
        }else if(gecici.kenar > this.kenar){
            return 1;
        }else return 0;
    }
}
