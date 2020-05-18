package com.EmreAltunbilek.Collection.Queue_Interface;

import java.util.*;

/*
-------------------------------------- QUEUE INTERFACE -------------------------------------------
**************************************************************************************************
-> Collection interface'sinden türetilmiştir.
-> İlk giren ilk çıkar. First in firs out
-> Priority kuyruk olmazsa listenin ortasına eleman eklememiz mümkün değil.
-> null değer alamaz.
-> Tekrar eden eleman tutulabilir.
-> Kendisine özgü methodların kullanılması tavsite edilir.
-> Yapıyı oluştururken Anonim inner class'lar kullanılabilir ama LinkedList türünde de veri tanımı yapılabilir.
Yani Queue kuyruk = new Queue)={
....
}

PRIROTY KUYRUKLAR
****************
-> Initial capasity verebiliriz.
-> Öncelikli kuyruk.
-> List iteratoru kullanamayız çünkü bu bir kuyruk.
Ama iterator'u kullanabiliriz.
-> Listeden eleman çıkarmadan listedeki elemanları sıralı bir şekilde görmek mümkün değildir.
Çünkü bu yapı bu amaca hizmet eden bir yapı değildir.
-> Offer methodu ile kuyruğun souna eleman eklenir.
-> Poll ile kuyruğun başından eleman okunur.
 */
public class QueueInterface {
    public static void main(String[] args) {
        Queue<Integer> sayilar =  new LinkedList<>();
        sayilar.offer(1); // Offer methodu Queue için ekleme methotudur. Add'de kullanılabilir ama tavsiye edilmez.
        sayilar.offer(2);
        sayilar.offer(2);
        sayilar.offer(4);
        sayilar.offer(5);
        sayilar.add(5);
        System.out.println(sayilar);
        System.out.println(sayilar.peek()); // ilk elemanı gösterir ama çıkarmaz.
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll()); // eğer liste boşsa ve boş listeden eleman çıkarmaya çalışırsak hata vermez. Null değerini dönderir.
        // Ama remove() methodunu kullanırsak kod hata verir.


        PriorityQueue<String> isimler = new PriorityQueue<>();
        isimler.offer("Furkan");
        isimler.offer("Ayse");
        isimler.offer("Kulaksiz");
        isimler.offer("Sahin");
        isimler.offer("Alperen");
        System.out.println(isimler); // Burada çıktı sırasız bir şekilde geldi.

        //Bu şekilde de sıralı bir liste göremiyoruz.
        Iterator<String> isimlerKuyrugu = isimler.iterator();
        while (isimlerKuyrugu.hasNext()){
            System.out.print(isimlerKuyrugu.next()+",");
        }

        System.out.println("POLL methodu ile kuyruğu sıralı bir şekilde görme.");
        //Sıralı bir şekilde çıkarmak için;
        while (!isimler.isEmpty()){
            System.out.println(isimler.poll());
        }

        System.out.println("REMOVE methodu ile kuyruğu sıralı bir şekilde görme");
        while (!isimler.isEmpty()){
            System.out.println(isimler.remove());
        }

        PriorityQueue<Ogrenci> ogrenciKuyruk = new PriorityQueue<>(new Comparator<Ogrenci>() {
            @Override
            public int compare(Ogrenci ogrenci, Ogrenci t1) {
                if (ogrenci.id > t1.id){
                    return 1;
                }else if (ogrenci.id < t1.id){
                    return -1;
                }else return 0;
            }
        });
        ogrenciKuyruk.offer(new Ogrenci(1,82));
        ogrenciKuyruk.offer(new Ogrenci(7,70));
        ogrenciKuyruk.offer(new Ogrenci(9,65));
        ogrenciKuyruk.offer(new Ogrenci(8,90));
        ogrenciKuyruk.offer(new Ogrenci(2,100));
        ogrenciKuyruk.offer(new Ogrenci(4,85));
        ogrenciKuyruk.offer(new Ogrenci(3,75));
        System.out.println(ogrenciKuyruk);

        while (!ogrenciKuyruk.isEmpty()){
            System.out.println(ogrenciKuyruk.poll());
        }
        /*
        Kodu yukarıdaki gibi çalıştırırsak hata alırız. Çünkü Stringler vs Comparable interface'sini
        implement ettikleri için bir karşılaştırma söz konusu.
        Ama ogrenci veri tipinde priority queue bir neye göre karşılaştırma yapacağını bilemediği için kod hata verdi.

        Bu hatayı çözmek için Ogrenci sınıfında compareTo() methodunu override ettik ve methodu kendimize göre güncelledik.
        (not değerlerine göre sıraladık.)
        Ama sout içine yazmak da not değerlerine göre sıralı bir şekilde sonucu vermedi.
        Çünkü priority kuyruk bu amaca hizmet etmez.
        Bunun için bir while döngüsü ile kuyruktaki elemanları silerek çıkardık ve o şekilde gösterdik.

        Veya başka bu sefer de başka bir şekilde id'ye göre sıralamak istediğimizde ise;
        PriorityQueue<Ogrenci> ogrenciKuyruk = new PriorityQueue<>(); bu yapının en sonundaki parantezin içine kodda gördüğümüz
        işlem uygulanır. Comparator dedik ve şunu söylemiş olduk;
        Sınıftaki comparable'ye bakma direk comparator ile sırala.
        Eğer sınıfta anlık olarak o an herhangi bir değere göre sıralama yapılacaksa comparator kullanılır.
        Gerçekten sıralama ihtiyaçsa ve her yerde kullanılacaksa Comparable -> compareTo methodu kullanılır.

        Collections.sort da başka bir sıralama yöntemi olabilir.
         */

    }
}

class Ogrenci implements Comparable{
    int id;
    int not;

    public Ogrenci(int id, int not) {
        this.id = id;
        this.not = not;
    }

    @Override
    public int compareTo(Object o) {
        Ogrenci yeniDeger = (Ogrenci) o;
        if (this.not > yeniDeger.not){
            return 1;
        }else if(this.not < yeniDeger.not){
            return -1;
        }else return 0;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", not=" + not +
                '}';
    }
}