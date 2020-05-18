package com.EmreAltunbilek.LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
/*
Bir arraylist'i sıralarken "Colelctions.sort(arrayListIsmi);"
gibi bir kod bloğuyla sıralama işlemini halledebiliyorduk.

Ama bir anonim inner class sayesinde sort methodu içinde bu işlemi
kendi belirlediğimiz bir yapıya göre sıralayabiliyoruz.

Bir lambda expression ifades ile de biz;
arrayList.forEach( () -> {...} ) ifadesiyle de sıralama yapabiliriz.
 */
public class Main3 {
    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci("Furkan", 12);
        Ogrenci ogrenci2 = new Ogrenci("Sahin", 11);
        Ogrenci ogrenci3 = new Ogrenci("Kulaksiz", 13);
        Ogrenci ogrenci4 = new Ogrenci("Alperen", 16);
        Ogrenci ogrenci5 = new Ogrenci("Ahmet", 10);
        Ogrenci ogrenci6 = new Ogrenci("Kayra", 18);

        ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
        ogrenciler.add(ogrenci1);
        ogrenciler.add(ogrenci2);
        ogrenciler.add(ogrenci3);
        ogrenciler.add(ogrenci4);
        ogrenciler.add(ogrenci5);
        ogrenciler.add(ogrenci6);

        Collections.sort(ogrenciler, new Comparator<Ogrenci>() {
            @Override
            public int compare(Ogrenci ogrenci, Ogrenci t1) {
                if (ogrenci.getNumara() > t1.getNumara()){
                    return 1;
                }else if (ogrenci.getNumara() < t1.getNumara()){
                    return -1;
                }else return 0;
            }
        });

        System.out.println(ogrenciler);
        System.out.println("-------------");
        for (Ogrenci temp:
             ogrenciler) {
            System.out.println(temp);
        }

        System.out.println();
        System.out.println("******** LAMDA EXPRESSION ********");
        System.out.println("----------------------------------");
        // Asağıdaki kod bloğunda parametre tiplerini de silebiliriz. Çünkü sort methodunun ilk parametresi
        // zaten öğrenci tipinde.
        Collections.sort(ogrenciler, (ogrenci_Bir, ogrenci_Iki)->
            ogrenci_Bir.getIsim().compareTo(ogrenci_Iki.getIsim())
        );
        for (Ogrenci temp:
                ogrenciler) {
            System.out.println(temp);
        }

        System.out.println();
        System.out.println("******** ANONIM INNER CLASS ile FOREACH ********");
        System.out.println("------------------------------------------------");

        ogrenciler.forEach(new Consumer<Ogrenci>() {
            @Override
            public void accept(Ogrenci ogrenci) {
                System.out.println(ogrenci.getIsim() + " : " + ogrenci.getNumara());
            }
        });

        System.out.println();
        System.out.println("******** LAMBDA EXPRESSION ile FOREACH ********");
        System.out.println("-----------------------------------------------");

        ogrenciler.forEach((temp) -> {
            System.out.println("Isim : " + temp.getIsim() + " Numara : " + temp.getNumara());
        });
    }
}

class Ogrenci{
    private String isim;
    private int numara;

    public Ogrenci(String isim, int numara) {
        this.isim = isim;
        this.numara = numara;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "isim='" + isim + '\'' +
                ", numara=" + numara +
                '}';
    }
}
