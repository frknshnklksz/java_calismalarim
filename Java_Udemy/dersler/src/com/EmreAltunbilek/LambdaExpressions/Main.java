package com.EmreAltunbilek.LambdaExpressions;

import java.util.ArrayList;

/*
-------------------------------- LAMBDA EXPRESSIONS --------------------------------
************************************************************************************
-> Bir interface düşünün ve içerisinde yalnızca bir method olsun.
Bu gibi ifadeleri daha hızlı bir şekilde daha az kod yazarak ifade edebilmemizi sağlar.

-> Lamda 3 yapıdan oluşur.
* () : parametreleri içerir.
* -> : lambda ifadesinin oku
* son olarak da interface'deki tek methodun içerisinde yapılacak methodun birebir aynısı

 */
public class Main {
    public static void main(String[] args) {
        Calisan calisan1 = new Calisan("Emre", 29);
        Calisan calisan2 = new Calisan("Furkan", 24);
        Calisan calisan3 = new Calisan("Sahin", 26);
        Calisan calisan4 = new Calisan("Kulaksiz", 30);

        ArrayList<Calisan> calisanlar = new ArrayList<>();
        calisanlar.add(calisan1);
        calisanlar.add(calisan2);
        calisanlar.add(calisan3);
        calisanlar.add(calisan4);

        /*for (Calisan temp:
             calisanlar) {
            bilgileriYazidr(new YazdiranInterface() { // Burası gri olarak renklenmiştir. Üzerine geldiğimizde bu ifade yerine "lamda expression
                @Override                             // kullanabilirsiniz." der.
                public void yazdir() {
                    System.out.println(temp.getIsim() + " " + temp.getYas());
                }
            });
        }*/

        for (Calisan temp:
             calisanlar) {
            bilgileriYazidr(() -> System.out.println(temp.getIsim() + " " + temp.getYas()));
        }

    }

    public static void bilgileriYazidr(YazdiranInterface yazdiranInterface){
        yazdiranInterface.yazdir();
    }
}

class Calisan{
    private String isim;
    private int yas;

    public Calisan(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public int getYas() {
        return yas;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
