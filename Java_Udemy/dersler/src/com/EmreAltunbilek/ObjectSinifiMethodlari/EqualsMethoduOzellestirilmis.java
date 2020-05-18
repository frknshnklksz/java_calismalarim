package com.EmreAltunbilek.ObjectSinifiMethodlari;

import java.util.Objects;

public class EqualsMethoduOzellestirilmis {
    public static void main(String[] args) {
        Ogretmen o1 = new Ogretmen(10,"Furkan");
        Ogretmen o2 = new Ogretmen(10, "Furkan");
        System.out.println(o1.equals(o2));
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());


        /*
        Normalde eğer String de bir sınıfs oluşturulan nesneler de
        farklı adreslerde olacağı için equals methodu true döner
        Çünkü String sınıfı özelleştirilmiştir.
         */
        String isim = new String("Furkan");
        String isim2 = new String("Furkan");
        System.out.println(isim.equals(isim2));

        /*
        String sınıfında olan olay Wrapper sınıflarda da
        geçerlidir. Bu sınıf da equals için özelleştirilmiştir.
        Aşağıdaki ifade de adresleri farklı olmasına rağmen true
        dönecektir.
         */
        Integer sayi1 = new Integer(10);
        Integer sayi2 = new Integer(10);
        System.out.println(sayi1.equals(sayi2));
    }
}

class Ogretmen{
    int id;
    String ad;

    public Ogretmen(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //nesne1 = nesne2 mi
        if (!(o instanceof Ogretmen)) return false;
        Ogretmen ogretmen = (Ogretmen) o;
        return id == ogretmen.id &&
                ad.equals(ogretmen.ad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ad);
    }
}
