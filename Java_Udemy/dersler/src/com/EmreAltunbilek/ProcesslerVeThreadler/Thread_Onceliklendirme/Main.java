package com.EmreAltunbilek.ProcesslerVeThreadler.Thread_Onceliklendirme;

import com.EmreAltunbilek.ProcesslerVeThreadler.ThreadCesitleri_Isimlendirmeler_IDler.ThreadRenkler;

/*
Thread'ler JVM'ye göre çalışır. Öncelik sıralık ilişkisi JVM'e kalmıştır.
Ama thread'lere öncelik atayabiliyoruz. Fakat bu da çok düzgün çalışmaz.
threadAdi.setPriority(..) diyerekk 1 - 10 arası değerler verebiliriz.
Threadç.currentThread().getPriority diyerek de thread'lerin önceliğini okuyabiliriz.
Thread'e hernagi bir öncelik vermezsek önceliği 5 olur.


 **INTERRUPT**
--------------
Var olan threadi o an çalışan threadi kesmek, durdurmak istiyorsak interrupt methodu kullanilir.
 */

public class Main {
    public static void main(String[] args) {
        TekSayilar t1 = new TekSayilar("1");
        TekSayilar t2 = new TekSayilar("2");
        t1.setPriority(Thread.MAX_PRIORITY);
        //t2.setPriority(7);
        t1.start();
        //t2.start();


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if (i == 10){
                        try {
                            t1.join(3000);                     // Bu thread çift sayıları yazdırıyor. Ve bu thread çalıştığında
                        } catch (InterruptedException e) {           // i 10 olduğunda t1 thread'i join oluyor ve bütün önceliği üzerine alıyor.
                            e.printStackTrace();                     // Bu durumdan sonra t1'in işlemi bitirmesini bekleyeceğiz.
                        }                                           // join içerisine parametre olarak saniye atabiliriz.
                    }
                    if (i % 2 == 0){
                        System.out.println(ThreadRenkler.Magenta+" "+i+" Oncelik : " + Thread.currentThread().getPriority());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            //return; // Burası interrupt kullanıldığı zaman hata fırlatmadan devam eder.
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();


    }
}

class TekSayilar extends Thread{

    String isim;
    String renk;

    public TekSayilar(String name) {
        super(name);
        isim = name;
        if (name.equals("1")){
            renk = ThreadRenkler.Cyan;
        }else renk = ThreadRenkler.Blue;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if (i == 5){
                interrupt(); // i değeri 5 olduğunda ilgili thread çalışmaz.. Bir hata atar. fakat çalışmaya devam eder.
            }
            if (i % 2 != 0){
                System.out.println(renk+" "+i+" Oncelik : " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //return; // Burası interrupt kullanıldığı zaman hata fırlatmadan devam eder.
                    e.printStackTrace();
                }
            }
        }
    }
}
