package com.EmreAltunbilek.UdemyKursPlayerOrnek;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci("Ali", "Alinin Tanitim Yazisi", "Ali_Udemy");
        Egitmen egitmenEmre = new Egitmen("Emre", "Emrenin Tanitim Yazisi", "emr");
        Egitmen egitmenFurkan = new Egitmen("Furkan", "Furkanin tanitim yazisi", "fsk");
        System.out.println(ogrenci1);
        System.out.println(egitmenEmre);

        Ders ders1 = new Ders(1,"Giris Dersi", 3.8);
        Ders ders2 = new Ders(2,"Javaya Dersi", 12);
        Ders ders3 = new Ders(3,"ArrayListler Dersi", 25);
        Ders ders4 = new Ders(4,"Veri Yapilari Dersi", 20.3);
        Ders ders5 = new Ders(5,"Algoritmalar", 20.3);


        Ders ders6 = new Ders(6, "Interfaceler", 18.6);
        Ders ders7 = new Ders(7, "Try Catch", 21.6);
        Ders ders8 = new Ders(8, "Firebase", 17.9);
        Ders ders9 = new Ders(9, "Emulator", 15.6);
        Ders ders10 = new Ders(10, "Methodlar", 14.6);

        Kurs javaKursu = new Kurs("Java", egitmenEmre);
        javaKursu.kursaDersEkle(ders1);
        javaKursu.kursaDersEkle(ders2);
        javaKursu.kursaDersEkle(ders3);
        javaKursu.kursaDersEkle(ders4);
        javaKursu.kursaDersEkle(ders5);

        javaKursu.kursaEgitmenEkle(egitmenFurkan);
        javaKursu.kurstanEgitmenSil(egitmenEmre);
        javaKursu.kurstanEgitmenSil(egitmenFurkan);

        ogrenci1.kursaKatil(javaKursu);


        ogrenci1.izlenecekDersEkle(ders2);

        Kurs androidKursu = new Kurs("Android", egitmenFurkan);
        androidKursu.kursaDersEkle(ders6);
        androidKursu.kursaDersEkle(ders7);
        androidKursu.kursaDersEkle(ders8);
        androidKursu.kursaDersEkle(ders9);
        androidKursu.kursaDersEkle(ders10);

        ogrenci1.izlenecekDersEkle(ders5);
        ogrenci1.kursaKatil(androidKursu);
        ogrenci1.izlenecekDersEkle(ders6);

        listeyiOynat(ogrenci1.getIzlenecekDersListesi());

    }

    public static void listeyiOynat(LinkedList<Ders> izlenecekDersler){
        Scanner veriAl = new Scanner(System.in);
        boolean cikis = false;
        boolean ileriyeDogruHareket = true;
        ListIterator<Ders> iterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0){
            System.out.println("Henuz izlenecekler listeniz bos. ");
        }else{
            Ders ilkDers = iterator.next();
            System.out.println("Su an izlenen ders : " + ilkDers.getDersBaslik() + " sure : " + ilkDers.getDakika());
        }

        menuGoster();
        while (!cikis){
            System.out.println("Seciminiz : ");
            int kullaniciSecimi = veriAl.nextInt();
            switch (kullaniciSecimi){
                case 0:
                    System.out.println("Uygulamadan cikiliyor..");
                    cikis = true;
                    break;
                case 1:
                    if (ileriyeDogruHareket == false){
                        ileriyeDogruHareket = true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()){
                        Ders ilkDers = iterator.next();
                        System.out.println("*****************************************************************");
                        System.out.println("Su an oynatilan ders : " + ilkDers.getDersNo() + " baslik : " + ilkDers.getDersBaslik() + " sure : " + ilkDers.getDakika());
                        System.out.println("*****************************************************************");
                    }else {
                        System.out.println("Listenin sonuna geldiniz.");
                    }
                    break;
                case 2:
                    if (ileriyeDogruHareket == true){
                        ileriyeDogruHareket = false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()){
                        Ders ilkDers = iterator.previous();
                        System.out.println("*****************************************************************");
                        System.out.println("Su an oynatilan ders : " + ilkDers.getDersNo() + " baslik : " + ilkDers.getDersBaslik() + " sure : " + ilkDers.getDakika());
                        System.out.println("*****************************************************************");
                    }else{
                        System.out.println("Listenin basina geldiniz.");
                    }
                    break;
                case 3:
                    izlenecekDersleriListele(izlenecekDersler);
                    break;
                case 9:
                    menuGoster();
                    break;
            }
        }
    }

    private static void izlenecekDersleriListele(LinkedList<Ders> izlenecekDersler) {
        ListIterator<Ders> iterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0){
            System.out.println("Listeniz bostur.");
            return;
        }else{
            while (iterator.hasNext()){
                Ders ilkDers = iterator.next();
                System.out.println("Ders No : " + ilkDers.getDersNo() + " baslik : " + ilkDers.getDersBaslik() + " sure : " + ilkDers.getDakika());
            }
        }
    }

    private static void menuGoster(){
        System.out.println("******************* MENU *******************");
        System.out.println("0 -> CIKIS");
        System.out.println("9 -> MENU");
        System.out.println("1 -> BIR SONRAKI DERSE GIT");
        System.out.println("2 -> BIR ONCEKI DERSE GIT");
        System.out.println("3 -> BUTUN LISTEYI GOSTER");
    }
}
