package com.EmreAltunbilek.ObjectSinifiMethodlari;


/*
AÇIKLAMALAR
Finalize() methodu java 9 ile beraber tedahülden kalktı.
Çünkü Garbage collector'ün ne zaman çalışacağına JVM karar veriyodu.
Çoğu zaman ise ihiyac durumunda ya da çalışması gereken durumda çalışmıyordu.

Ama eğer garbage collector çalışırsa finalize diye bir methodu tetikler.
 */
public class FinalizeVeGarbageCollector {
    public static void main(String[] args) {
        A parametre1 = new A(10);
        A parametre2 = new A(20);

        parametre1 = parametre2;
        System.out.println(parametre1.toString());
        System.out.println(parametre2.toString());

        /*
        aşağıda biz 499 tane boş, çöp ramden nesne oluşturduk.
        Bu nesneleri silmemiz lazım. Burada System.gc() diyerek
        finalize methodunu çalışmaya zorladıki. Biz tetikledik.
         */
        for (int i = 0; i <= 500 ; i++) {
            parametre1 = new A(i);

            if(i == 10){
                System.gc();
            }
        }
    }
}

class A{
    int parametre;

    public A(int parametre) {
        this.parametre = parametre;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize methodu tetiklendi.");
    }
}
