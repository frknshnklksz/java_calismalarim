package com.EmreAltunbilek.ProcesslerVeThreadler.Giris;

public class Isci extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("ISci sinifi calismaya basladi. Thhread adi : " + Thread.currentThread().getName());
            Thread.sleep(1000); // İlgili thread'in 50000 milisaniye durmasını sağlar.
            System.out.println("ISci sinifi calismayi bitirdi. Thhread adi : " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
