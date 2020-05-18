package com.EmreAltunbilek.VeterinerlerBirligiSimulasyonu;

public class Main {
    public static void main(String[] args) {
       ilkNesneleriGoster();
    }

    private static void ilkNesneleriGoster() {
        Kedi kedi1 = new Kedi("01-02-2016", true, "Van Kedisi");
        Kedi kedi2 = new Kedi("10-04-2016", false, "Siyam");
        Kedi kedi3 = new Kedi("07-03-2017", false, "Ankara Kedisi");
        Kedi kedi4 = new Kedi("04-12-2019", false, "Kara Kedi");
        Kedi kedi5 = new Kedi("10-05-2018", true, "Sokak Kedisi");

        Kopek kopek1 = new Kopek("02-04-2019", true, 7, "GOLDEN");
        Kopek kopek2 = new Kopek("02-05-2016", true, 3, "DOBERMAN");
        Kopek kopek3 = new Kopek("04-11-2019", false, 2, "GOLDEN");
        Kopek kopek4 = new Kopek("02-07-2017", true, 5, "PITBULL");
        Kopek kopek5 = new Kopek("21-11-2018", false, 4, "SIVAS KANGALI");

        Musteri musteri1 = new Musteri("Furkan Sahin Kulaksiz", "12345678910", "Ankara - Sincan");
        musteri1.musteriyeHayvanEkle(kedi1);
        musteri1.musteriyeHayvanEkle(kopek1);

        Musteri musteri2 = new Musteri("Hasan Veliaht", "456782132", "Istanbul - Atasehir");
        musteri2.musteriyeHayvanEkle(kedi2);
        musteri2.musteriyeHayvanEkle(kopek2);

        Musteri musteri3 = new Musteri("Fatma Baci", "873241328", "Izmir - Urla");
        musteri3.musteriyeHayvanEkle(kedi3);
        musteri3.musteriyeHayvanEkle(kopek3);

        Musteri musteri4 = new Musteri("Ayse Kulin", "231465465", "Bursa - Nilufer");
        musteri4.musteriyeHayvanEkle(kedi4);
        musteri4.musteriyeHayvanEkle(kopek4);

        Musteri musteri5 = new Musteri("Halide Edip Adivar", "45545865", "Aksaray - Merkez");
        musteri5.musteriyeHayvanEkle(kedi5);
        musteri5.musteriyeHayvanEkle(kopek5);

        Veteriner veteriner1 = new Veteriner("Oguzhan Aslan", "54687678", "Konya Selcuk Universitesi", 5);
        veteriner1.musteriekle(musteri1);

        Veteriner veteriner2 = new Veteriner("Canberk Pehlivan", "24564354", "Gazi Universitesi", 8);
        veteriner2.musteriekle(musteri2);

        Veteriner veteriner3 = new Veteriner("Ibrahim Yuzer", "5454354867", "Hacettepe Universitesi", 7);
        veteriner3.musteriekle(musteri3);
        veteriner3.musteriekle(musteri1);

        Veteriner veteriner4 = new Veteriner("Irfan Kulaksiz", "98454874", "Ortadogu Teknik Universitesi", 4);
        veteriner4.musteriekle(musteri4);
        veteriner4.musteriekle(musteri1);
        veteriner4.musteriekle(musteri2);

        Veteriner veteriner5 = new Veteriner("Fatih Eroglu", "879534123", "Ankara Universitesi", 3);
        veteriner5.musteriekle(musteri5);

        SehirVeterinerlikBilgileri ankara = new SehirVeterinerlikBilgileri("Ankara");
        ankara.sehireVeterinerEkle(veteriner1);
        ankara.sehireVeterinerEkle(veteriner2);

        SehirVeterinerlikBilgileri istanbul = new SehirVeterinerlikBilgileri("Istanbul");
        istanbul.sehireVeterinerEkle(veteriner3);

        SehirVeterinerlikBilgileri izmir = new SehirVeterinerlikBilgileri("Izmir");
        izmir.sehireVeterinerEkle(veteriner4);
        izmir.sehireVeterinerEkle(veteriner5);

        ankara.sehirdekiToplamVeterinerSayisiniGoster();
        izmir.sehirdekiToplamVeterinerSayisiniGoster();
        istanbul.sehirdekiToplamVeterinerSayisiniGoster();


        System.out.println();
        System.out.println("YONETIM PANELI");
        Yonetim<Hayvan> hayvanYonetimPaneli = new Yonetim<>();
        hayvanYonetimPaneli.bilgileriGoster(kedi3);

        Yonetim<Musteri> musteriYonetimPaneli = new Yonetim<>();
        musteriYonetimPaneli.bilgileriGoster(musteri4);

        musteri1.musteriHayvanlariniListele();
    }
}
