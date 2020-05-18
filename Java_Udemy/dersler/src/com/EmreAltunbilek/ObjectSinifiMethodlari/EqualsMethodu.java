package com.EmreAltunbilek.ObjectSinifiMethodlari;

import java.util.Objects;

public class EqualsMethodu {
    public static void main(String[] args) {
        Kisi k1 = new Kisi(1,"Furkan");
        System.out.println(k1.toString());

        Kisi k2 = new Kisi(1,"Furkan");
        System.out.println(k2.toString());

        System.out.println("K1 ve K2 eşit mi : " + k1.equals(k2));

        k1 = k2;
        System.out.println("K1 ve K2 eşit mi : " + k1.equals(k2));

    }
}

class Kisi{
    int id;
    String isim;

    public Kisi(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "id : " + id + "isim : " + isim;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
