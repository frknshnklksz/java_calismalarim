package com.EmreAltunbilek.OrnekTelevizyonSimulasyonu;

import java.util.Scanner;

public class TelevizyonSimulasyonu {
    static Scanner veriAl = new Scanner(System.in);
    static Televizyon televizyon;
    public static void main(String[] args) {

        menuGoster();
        boolean cikis = false;

        while (cikis == false){
            System.out.println("\nSeciminiz : (Menuyu gormek icin 8'i tuslayiniz)");
            int secim = veriAl.nextInt();
            switch (secim){
                case 1:
                    tvKurVeKanallariOlustur();
                    break;
                case 2:
                    tvAc();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 4:
                    sesiAzalt();
                    break;
                case 5:
                    kanalDegistir();
                    break;
                case 6:
                    kanalBilgisiniGoster();
                    break;
                case 7:
                    tvKapat();
                    break;
                case 8:
                    menuGoster();
                    break;
                case 0:
                    System.err.print("Sistemden cikiliyor.");
                    cikis = true;
                    break;
                default:
                    System.err.print("Yanlis bir deger girdiniz. Lutfen 0 - 8 arasi bir deger giriniz.");
            }
        }

    }

    private static void kanalBilgisiniGoster() {
        if (televizyon != null){
            televizyon.aktifKanaliGoster();
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void kanalDegistir() {
        if (televizyon != null){
            System.out.println("Acilmasini istediginiz kanali giriniz : ");
            int acilmasiIStenenKanal = veriAl.nextInt();
            televizyon.kanalDegistir(acilmasiIStenenKanal);
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void sesiAzalt() {
        if (televizyon != null){
            televizyon.sesAzalt();
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void sesArttir() {
        if (televizyon != null){
            televizyon.sesArttir();
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void tvKapat() {
        if (televizyon != null){
            televizyon.tvKapat();
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void tvAc() {
        if(televizyon != null){
            televizyon.tvAc();
        }else{
            System.out.println("Once Televizyon'u kurun ve kanallari olusturun.");
        }
    }

    private static void tvKurVeKanallariOlustur() {
        if (televizyon == null){
            veriAl.nextLine();
            System.out.println("Televizyonun Markasini giriniz.");
            String marka = veriAl.nextLine();
            System.out.println("Televizyonun boyutunu giriniz.");
            String boyut = veriAl.nextLine();
            televizyon = new Televizyon(marka, boyut);
            System.out.println(televizyon);
        }else{
            System.err.print("Televizyona sahipsiniz.");
            System.out.println(televizyon);
        }
    }

    private static void menuGoster() {
        System.out.println("************ MENU ************");
        System.out.println("0 -- Cikis" +
                "\n1 -- Televizyonu Kur" +
                "\n2 -- Televizyonu Ac" +
                "\n3 -- Sesi Arttir" +
                "\n4 -- Sesi Azalt" +
                "\n5 -- Kanal Degistir" +
                "\n6 -- Acik Olan Kanal Bilgisi" +
                "\n7 -- Televizyonu Kapat" +
                "\n8 -- Menüyü Göster");
    }
}
