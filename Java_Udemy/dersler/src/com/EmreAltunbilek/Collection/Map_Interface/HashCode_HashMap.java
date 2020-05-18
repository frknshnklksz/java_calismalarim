package com.EmreAltunbilek.Collection.Map_Interface;

import java.util.Objects;

public class HashCode_HashMap {
    public static void main(String[] args) {
        String string1 = "Furkan";
        String string2 = "Sahin";
        String string3 = "Furkan";

        System.out.println(string1.hashCode());
        System.out.println(string2.hashCode());
        System.out.println(string3.hashCode());
        System.out.println();
        System.out.println("-------------------");
        System.out.println();
        Ogrenci ogrenci1 = new Ogrenci(1, "Furkan");
        System.out.println(ogrenci1.hashCode());
        ogrenci1.id = 2;
        ogrenci1.isim = "Furkan Sahin Kulaksiz";
        System.out.println(ogrenci1.hashCode());
        System.out.println();
        Ogrenci ogrenci2 = new Ogrenci(2, "Furkan Sahin Kulaksiz");
        System.out.println(ogrenci2.hashCode());
    }
}

class Ogrenci{
    int id;
    String isim;

    public Ogrenci(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ogrenci)) return false;
        Ogrenci ogrenci = (Ogrenci) o;
        return id == ogrenci.id &&
                Objects.equals(isim, ogrenci.isim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isim);
    }
}
