package com.EmreAltunbilek.Sansli10NumaraOrnek;

import java.util.*;

/*
Asagıda map yapısını statik tanımladık. Çünkü;
statik olmayan bir yapıya static bir method'dan ulaşmaya çalıştık.
Eğer static tanımlamasaydık main sınıfından bir nesne üretip o şekilde
çağırmamız gerekecekti.
 */
public class Main {
    //static HashMap<Integer, Integer> map = new HashMap<>();
    static final int URETILECEK_SAYI_MAX_SINIR = 60;
    static final int URETILECEK_SAYI_MIKTARI = 1000000;
    public static void main(String[] args) {

        Map<Integer, Integer> olusturulanSayilarMap = new HashMap<>();
        List<Integer> olusturulanSayilarinListesi = new ArrayList<>();
        Set<Integer> sansliOnSayi = new HashSet<>();

        mapiSayilarlaDoldur(olusturulanSayilarMap);
        
        mapiListeyeYazdir(olusturulanSayilarMap, olusturulanSayilarinListesi);

        sansliOnSayiyiBul(sansliOnSayi, olusturulanSayilarinListesi);

        System.out.println("Listenin size : " + olusturulanSayilarinListesi.size());

        System.out.println("Map Size : " + olusturulanSayilarMap.size());
        System.out.println("Set Size : " + sansliOnSayi.size());

        System.out.println("SANSLI 10 SAYI");
        for (int gecici:
             sansliOnSayi) {
            System.out.print(gecici+", ");
        }
    }

    private static void sansliOnSayiyiBul(Set<Integer> sansliOnSayi, List<Integer> olusturulanSayilarinListesi) {
        Collections.shuffle(olusturulanSayilarinListesi);
        while (sansliOnSayi.size() < 10){
            int rastgeleSayi = ((int)(Math.random() * URETILECEK_SAYI_MIKTARI));
            sansliOnSayi.add(olusturulanSayilarinListesi.get(rastgeleSayi));
        }
    }

    private static void mapiListeyeYazdir(Map<Integer, Integer> olusturulanSayilarMap, List<Integer> olusturulanSayilarinListesi) {
        for (Map.Entry<Integer, Integer> gecici:
                olusturulanSayilarMap.entrySet()) {
            int key = gecici.getKey();      //key degeri 15 olsun      -> Bu 9 sayısının
            int value = gecici.getValue();  // value degeri 9 olsun.     15 kere çıktığı anlamına gelir.

            for (int i = 0; i <value ; i++) {
                olusturulanSayilarinListesi.add(key);
            }
        }
    }

    private static void mapiSayilarlaDoldur(Map<Integer, Integer> olusturulanSayilarMap) {
        for (int i = 0; i <URETILECEK_SAYI_MIKTARI ; i++) {
            int randomSayi = sayiOlustur();
            if (olusturulanSayilarMap.containsKey(randomSayi)){
                int value = olusturulanSayilarMap.get(randomSayi);
                olusturulanSayilarMap.put(randomSayi, ++value);
            }else{
                olusturulanSayilarMap.put(randomSayi,1);
            }
        }
    }

    private static int sayiOlustur(){
        return ( (int)(Math.random() * URETILECEK_SAYI_MAX_SINIR) + 1);
    }
}
