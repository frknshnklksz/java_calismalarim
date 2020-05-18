package com.EmreAltunbilek.LambdaExpressions;
/*
******** Boşluklu bir string ifadenin thread ve lambda expression kullanarak ayrılması ********
-----------------------------------------------------------------------------------------------

NOT: Burada lambda şuna bakar.
Thread sınıfının bir tane methodu olan interface'i var mı.?
Cevap "evet var" ise lambda direk o interface'i ve ilgili methodu bulur.
Çünkü lambda olması için bir interface içinde tek bir method olmalı.
 */
public class LambdaOrnek1 {
    public static void main(String[] args) {
        String kelime = "Furkan Sahin Kulaksiz Konya Selcuk Universitesi Bilgisayar Muhendisligi Bolumu";

        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] kelimeler = kelime.split(" ");
                for (String temp:
                     kelimeler) {
                    System.out.println(temp);
                }
            }
        }).start();

        new Thread(() -> {
           String[] kelimelerDizisi = kelime.split(" ");
            for (String gecici:
                 kelimelerDizisi) {
                System.out.println(gecici);
            }
        }).start();
    }
}
