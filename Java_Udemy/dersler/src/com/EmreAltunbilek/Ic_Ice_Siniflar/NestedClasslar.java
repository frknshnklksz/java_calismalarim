package com.EmreAltunbilek.Ic_Ice_Siniflar;

/*
------------ İç içe Sınıfların Dışarıda kullanımı ------------

1) İç içe sınıfları dışarıda kullanırken şu adımlar izlenir;
    1. YOL -> Nesne oluştururken
    DistakiSinif.IctekiSinif nesneAdi = new DistakiSinif().new IctekiSinif();

    2.YOL -> DistakiSinif nesneAdi1 = new DistakiSinif();
             DistakiSinif.IcSinifinMethodu nesneAdi2 = nesneAdi1.new IcSinifinMethodu();
    Böyle bir kullanimda icteki sinifin private olmamasi lazim.


2) İçteki sınıftan nesne oluşturup içerideki sınıf methodlarına ve değişkenlerine erişebiliriz.
Ama private olan alanlara erişemeyiz.
 */
public class NestedClasslar {
    public static void main(String[] args) {

        String[] Sehirler = {"Ankara", "Bursa", "Izmir"};

        YaziciSinif.StringDiziYazdir nesne2 = new YaziciSinif().new StringDiziYazdir();
        nesne2.stringDiziYazdir(Sehirler);

    }
}
