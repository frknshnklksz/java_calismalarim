package com.EmreAltunbilek.ProcesslerVeThreadler.Uretici_Tuketici_Problemi;

import com.EmreAltunbilek.ProcesslerVeThreadler.ThreadCesitleri_Isimlendirmeler_IDler.ThreadRenkler;
/*
Problemimiz bir tüketici ve üretici threadlerinin senkron bir şekilde çalışmaması.
OrtakAlan2 sınıfı içerisinde bulunan veriAl() ve veriYaz() methodlarını "synchronized" ile
imlesek bile sorunumuz çözülmedi.
 */
public class Main2 {
    public static void main(String[] args) {

        OrtakAlan2 ortakAlan = new OrtakAlan2();
        Uretici2 ureticiThread = new Uretici2(ortakAlan);
        Tuketici2 tuketiciThread = new Tuketici2(ortakAlan);

        ureticiThread.start();
        tuketiciThread.start();
    }
}

class OrtakAlan2 {
    private int veri;
    private boolean veriVarmi = false;

    public synchronized int veriAl(){
        while (veriVarmi == false){
            try {
                wait(); // Wait demek bekleme havuzuna atmak demek. Thread'in belirli işlemleri beklemesi.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        veriVarmi = false;
        notifyAll();
        return veri;
    }

    public synchronized void veriYaz(int v){
        while (veriVarmi == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.veri = v;
        veriVarmi = true;
        notifyAll(); // Ben işimi hallettim. Bekleme havuzunda bir veri varsa o çalışsın demek.
    }
}

class Uretici2 extends Thread{
    private OrtakAlan2 ortakAlan;

    public Uretici2(OrtakAlan2 o){
        this.ortakAlan = o;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            ortakAlan.veriYaz(i);
            System.out.println(ThreadRenkler.Magenta+"Uretici thread tarafindan konulan veri : " + i);
            try {
                sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Tuketici2 extends Thread{
    private OrtakAlan2 ortakAlan;

    public Tuketici2(OrtakAlan2 o){
        this.ortakAlan = o;
    }

    @Override
    public void run() {
        int okunanDeger = 0;
        for (int i = 1; i <= 10; i++) {
            okunanDeger = ortakAlan.veriAl();
            System.out.println(ThreadRenkler.Yellow+"Tuketici thread tarafindan alinan veri : " + okunanDeger);
            try {
                sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

