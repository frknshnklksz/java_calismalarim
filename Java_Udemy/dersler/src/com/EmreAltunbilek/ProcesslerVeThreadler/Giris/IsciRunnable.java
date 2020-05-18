package com.EmreAltunbilek.ProcesslerVeThreadler.Giris;

public class IsciRunnable implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("ISciRunnable sinifi calismaya basladi. Thhread adi : " + Thread.currentThread().getName());
            Thread.sleep(1000); // İlgili thread'in 50000 milisaniye durmasını sağlar.
            System.out.println("ISciRunnable sinifi calismayi bitirdi. Thhread adi : " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
