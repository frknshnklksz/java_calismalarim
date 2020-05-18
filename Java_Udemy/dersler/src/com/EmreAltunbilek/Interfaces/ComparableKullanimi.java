package com.EmreAltunbilek.Interfaces;


import java.util.Arrays;

//Comparable bir interfacedir ve sıralamada kullanılır. Arraylistlerde ve sınıflarda
public class ComparableKullanimi {
    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci(5, "Furan");
        Ogrenci ogrenci2 = new Ogrenci(3, "Sahin");
        Ogrenci ogrenci3 = new Ogrenci(8, "Kulaksiz");

        Ogrenci[] ogrenciler = {ogrenci1, ogrenci2, ogrenci3};

        String[] isimler = {"Ayse", "Fatma", "Hayriye", "Aliye"};

        System.out.println("Dizi siralanmadan onceki hali");

        for (Ogrenci o:
             ogrenciler) {
            System.out.println(o);
        }
        Arrays.sort(ogrenciler);

        System.out.println("Dizi siralandiktan sonraki hali");
        for (Ogrenci o:
                ogrenciler) {
            System.out.println(o);
        }

        Arrays.sort(isimler);
        for (String i:
             isimler) {
            System.out.println(i);
        }
    }
}

class Ogrenci implements Comparable<Ogrenci>{
    int id;
    String adi;

    public Ogrenci(int id, String adi) {
        this.id = id;
        this.adi = adi;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ogrenci ogrenci) {
        if(this.id < ogrenci.id){
            return -1;
        }else if(this.id > ogrenci.id){
            return 1;
        }else return 0;
    }
}
