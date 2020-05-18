package com.EmreAltunbilek.Stringler;

public class StringSinifi {
    public static void main(String[] args) {
        String isim = new String("Furkan");
        String ad = new String("Furkan");
        System.out.println(isim == ad); // false. çünkü == adresleri kontrol eder
        System.out.println(isim.equals(ad)); //true çünkü equals degerleri kontrol eder.
        System.out.println(isim.hashCode());
        System.out.println(isim.hashCode());

        String abc = "abc";
        String def = "abc";

        System.out.println(abc == def); // <- bu kullanımda true değeri döner.
        // sebebi String pool

        String soyAd = "Kulaksiz";
        String soyIsim = "Kulaksiz";

        System.out.println(soyAd.hashCode());
        System.out.println(soyIsim.hashCode());


        //Aşağıdaki ifade sehir isimli degiskeni
        //hem heap'te tutar. Hem de String pool'a taşır
        String sehir = new String("Ankara").intern();


        //STRING ONEMLI METHOTLARI
        String stringIfade = "Furkan";
        System.out.println(stringIfade.length()); // Stringin uzunluğunu döner.
        System.out.println(stringIfade.charAt(3));// Integer olarak verilen index değerini döndürür.
        System.out.println(stringIfade.concat(" Sahin Kulaksiz"));// Verilen ifade ile var olan ifadeyi birleştirir.
        // Ama yukarıdaki ifade anlık olarak gösterir. Bunları Yeni String'de tutmak gerekir
        // toLowerCase() toUpperCas() -> büyük - küçük
        // trim() -> Yeni bir String ifade oluşturur. başındaki ve solundaki boşlukları değiştirir.
        // equals -> eşit mi değil mi kontrolünü yapar. Ama equals String için özelleştirilmiştir.
        String ay = "Mart";
        String ay2 = "mart";
        System.out.println(ay.equalsIgnoreCase(ay2)); // Harflerin büyüklük küçüklük durumuna bakmaksızın karşılaştırır.

        String mevsim = "Yaz";
        String mevsim2 = "Kis";

        System.out.println(mevsim.compareTo(mevsim2));
        // Bu değer alfabetik sıraya göre öncelik sonralık kıyaslaması yapar.

        //startsWith("A") -> ifadenin A ile başlayıp başlamadığını döndürür.
        //endWith("A") -> ifadenin A ile bitip bitmediğini döndürür.

        System.out.println(stringIfade.contains("fur")); // verilen ifade String'de var mı yok mu

        String boslukluIfade = "       Sahin Kulaksiz          ";
        System.out.println(boslukluIfade.trim().substring(4));// Verilen int degere göre size o indexten sonraki
        //degeri yeni bir kelime olarak verir.
        System.out.println(boslukluIfade.trim().substring(0,5)); //baslangic ve bitis indeksleri arasindaki ifadeyi dondurur.
        System.out.println(boslukluIfade.trim().indexOf("a")); //a ifadesinin stringdeki geçtiği ilk yeri verir.
        System.out.println(boslukluIfade.trim().lastIndexOf("e")); //e nin geçtiği son indeksi verir.


    }
}
