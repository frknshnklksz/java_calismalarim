package com.EmreAltunbilek.ProcesslerVeThreadler.Synchronized_Kavrami;

import com.EmreAltunbilek.ProcesslerVeThreadler.ThreadCesitleri_Isimlendirmeler_IDler.ThreadRenkler;
/*
Thread'lerin eş zamanlı çalışması güzel bir olay ama bazen de aynı kaynağa birden fazla threain
aynı anda erişmesi istenilen bir durum değildir.

Mesela;
A kişisi ile B kişisi aynı anda yazıcıya istek attığında çıktılar karışacaktır.
Bu durumun önüne geçmek için Synchorizde kavramı vardır.

Bu kavram iki farklı thread aynı kaynağa eriştiğinde birbirini bekleme, senkron bir
şekilde çalışmasını sağlar.

 */
public class Main {
    public static void main(String[] args) {
        Yazici yazici = new Yazici(12);
        Thread ayse = new Ayse(yazici);
        Thread fatma = new Fatma(yazici);

        ayse.setName("Ayse");
        ayse.start();
        fatma.setName("Fatma");
        fatma.start();
    }
}

class Yazici {
    private int dokumanSayisi;
    private int i;

    public Yazici(int dokumanSayisi) {
        this.dokumanSayisi = dokumanSayisi;
    }

    /*
    Bu method ile aslında her iki isim de aynı kaynağa erişmiştir. Fakat Her ikisi de aynı kaynağı
    tükettikleri için ekranda her ikisi için de azalan bir yapı görmeiliyim
    Yani;
    Ayse 10
    Fatma 9
    Fatma 8                                             Yanda emsal bir çıktı verilmiştir. Ama sonuçta her
    Ayse 7                                              iki thread'de aynı kaynağı kullanığı için azalma aşağıdaki
    gibi;                                               şekilde olmalıdır.

    Ama benim gördüğüm çıktı ise                        Bunun önüne geçmek için for'da tanımlanan i değerini field olarak
    Ayse 10                                             yazıcı sınıfının içerisinde belirtmek gerekir.
    Fatma 10
    Ayse 9
    Fatma 9
    Ayse 8
    Fatma 8
     */
    /*public void yazdir(){
        for (i = dokumanSayisi; i > 0 ; i--) {
            if (Thread.currentThread().getName().equals("Ayse")){
                System.out.println(ThreadRenkler.Yellow + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
            }else if(Thread.currentThread().getName().equals("Fatma")){
                System.out.println(ThreadRenkler.Red + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
            }

        }
    }*/

    // Bu synchronized keyword'u bu methoda herhangi bir thread eriştiğinde o
    // thread işlemini bitirine kadar methoda kilit koyar ve başka thread'in gelmesine izin vermez.
    // Bu şekilde bütün methodu synchronized yaptık.
    /*public synchronized void yazdir() {
        for (i = dokumanSayisi; i > 0; i--) {
            if (Thread.currentThread().getName().equals("Ayse")) {
                System.out.println(ThreadRenkler.Yellow + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
            } else if (Thread.currentThread().getName().equals("Fatma")) {
                System.out.println(ThreadRenkler.Red + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
            }

        }
    }*/

    // Bu şekilde ise sadece thread safe olmasını istediğimiz kod bloğunu da kilitleyebiliriz.
    public  void yazdir() {
        synchronized (this){
            for (i = dokumanSayisi; i > 0; i--) {
                if (Thread.currentThread().getName().equals("Ayse")) {
                    System.out.println(ThreadRenkler.Yellow + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
                } else if (Thread.currentThread().getName().equals("Fatma")) {
                    System.out.println(ThreadRenkler.Red + "Dokuman no : " + i + " Thread adi : " + Thread.currentThread().getName());
                }

            }
        }
    }


}

class Ayse extends Thread{
    private Yazici yazici;

    public Ayse(Yazici yazici){
        this.yazici = yazici;
    }

    @Override
    public void run() {
        yazici.yazdir();
    }
}

class Fatma extends Thread{
    private Yazici yazici;

    public Fatma(Yazici yazici){
        this.yazici = yazici;
    }

    @Override
    public void run() {
        yazici.yazdir();
    }
}

