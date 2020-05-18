package com.EmreAltunbilek.Collection.List_Interface.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
------------------------------------------- ÇALIŞMA MANTIĞI ve ÖZELLİKLERİ -------------------------------------------
**********************************************************************************************************************
1) ArrayListlerdeki gibi ilk oluşturulduğunda default bir boyut değeri atanmaz.
(ArrayListlerde 10 değeri atanırdı.)
2) Index bazlı çalışmaz.
3) List interface'sinden türetildiği için oradaki bütün methodları kullanabilir.
(get gibi, add gibi)
4) İterator ile Linked List'i dolaşmak performans olarak ArrayList'e göre düşüktür.
5) Ekleme ve silme işlemlerinde ArrayList'e göre daha performanslıdır.
Sebebi ArrayListler'de veri silindiği zaman bütün verilerde öteleme işlemi olur.
6) -> LinkedList'teki herhangi bir veri 3 kısımdan oluşur.
   -> Head kısmı adres tutar, Node kısmı veriyi tutar. Son kısım bir sonraki
   elemanın adresini tutar.
   -> Bir veri eklenmek ya da silinmek istediğinde aradaki bağ kopar.
   -> LinkedListlerde bir eleman bir sonraki elemanı tuttuğu gibi
   bir sonraki eleman da ilgili elemanı tutar. (Çift Yönlü Bağ)
Silinecek ya da eklenecek elemanların bağları güncellenir.
7) ArrayList'te eleman bulmak LinkedList'e göre daha hızlıdır.
8) ArrayListleri bir yığın ya da bir Queue olarak tutulamaz.
9) ArrayListlerde sadece veri tutulur. Ama LinkedListlerde ise verinin kendisiyle beraber
bir önceki ve bir sonraki verilerin referansları da tutulduğu için bellekte biraz daha fazla
yer kaplar.
10) Eğer verileri ekleme çıkarma çık yapılıyorsa linkedList veri okuma çok yapılıyorsa
ArrayList kullanımı mantıklıdır.
11) Her ikisinde de elemanlar eklenildiği gibi listelenir. Sıralama yoktur.
12) Her ikiside Cloneable ve Serializable interface'lerini implemente edebilir.
13) Her ikisinde de aynı anda birden fazla thread buradaki elemanlara müdahale edebilir.
 */
public class LinkedListKullanimi {
    public static void main(String[] args) {
        /*
        LinkedList<Integer> sayilar = new LinkedList<>();
        sayilar.add(4);
        sayilar.add(3);
        sayilar.add(6);
        sayilar.add(2,1);
        System.out.println(sayilar);
        System.out.println(sayilar.get(2));

        ListIterator<Integer> iterator = sayilar.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        */

        LinkedList<Integer> sayilar = new LinkedList<>();
        ArrayList<Integer> sayilar2 = new ArrayList<>();

        long baslamaZamani = System.currentTimeMillis();
        System.out.println("Linked List");
        linkedListiHazirla(sayilar);
        long bitisZamani = System.currentTimeMillis();
        System.out.println(sayilar);
        System.out.println("Linked List icin : " + (bitisZamani - baslamaZamani));

        System.out.println();
        System.out.println();
        System.out.println();

        long baslamaZamani2 = System.currentTimeMillis();
        System.out.println("Array List");
        arrayListiHazirla(sayilar2);
        System.out.println(sayilar2);
        long bitisZamani2 = System.currentTimeMillis();
        System.out.println("Array List icin : " + (bitisZamani2 - baslamaZamani2));





    }

    private static void arrayListiHazirla(ArrayList<Integer> sayilar2) {
        for (int i = 0; i <90000 ; i++) {
            int yeniEklenecekEleman = (int)(Math.random() * 500000);
            siraliEkle(sayilar2, yeniEklenecekEleman);
        }
    }

    public static void linkedListiHazirla(LinkedList<Integer> sayilar){
        for (int i = 0; i <90000 ; i++) {
            int yeniEklenecekEleman = (int)(Math.random() * 500000);
            siraliEkle(sayilar, yeniEklenecekEleman);
        }
    }

    public static boolean siraliEkle(List<Integer> liste, int yeniEklenecekEleman){
        ListIterator<Integer> iterator = liste.listIterator();

        while (iterator.hasNext()){
            int karsilastirmaSonucu = iterator.next().compareTo(yeniEklenecekEleman);
            if (karsilastirmaSonucu == 0){
                iterator.add(yeniEklenecekEleman);
                return true;
            }else if (karsilastirmaSonucu > 0){
                iterator.previous();
                iterator.add(yeniEklenecekEleman);
                return true;
            }else {

            }
        }

        iterator.add(yeniEklenecekEleman);
        return true;
    }


}
