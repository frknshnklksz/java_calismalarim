package com.EmreAltunbilek.ProcesslerVeThreadler.Giris;
/*
-------------------------- THREADLER ve PROCESSLER --------------------------
*****************************************************************************

Process: Execute halindeki program parçacığı. Yani JVM üzerinde oluşturulan her program
ya da çalışan her program bir processtir.

Thread: Process'lerin içerisindeki küçük iş parçacıkları.

-> Her process'in bir heap alanı vardır.
   Her thread'in bir thrad stack alanı vardır.

-> Threadler ve process ler bize eşzamanlı olarak birden fazla işi yapmamızı sağlar.

Thread oluşturmanın temelde 2 farklı yöntemi vardır;
1) Bir sınıf oluşturulur ve bu sınıf Thread sınıfından extend edilir.
2) Bir sınıf oluşturulur ve bu sınıf Runnable interface'sini implemente eder.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Program Baslatildi " + Thread.currentThread().getName()); // Bu yapı satırın çalıştırıldığı thread yapısını verir.

        /*try {
            Thread.sleep(50000); // İlgili thread'in 50000 milisaniye durmasını sağlar.
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/

        //Thread oluşturmak için birinci yöntem:
        // Sınıfımız Thread sınıfını extend eder.
        Isci isci1 = new Isci();
        isci1.setName("Isci sinifi threadi"); // Thread adını ayarlar.
        isci1.run();
        isci1.start(); //Start() methodu ilgili sınıf için özel bir thread çalışmasını tetikler.


        // Thread oluşturmak için 2. yöntem;
        // Sınıfımız Runnable sınıfını implemente eder.
        IsciRunnable isciRunnable = new IsciRunnable();
        Thread isci2 = new Thread(isciRunnable);
        isci2.setName("ISCI RUNNABLE THREAD'I");
        isci2.start();

        /*
        Program çalışırken anlık olarak thread'lere ihtiyaç duyabiliriz.
        Bu ihtiyacımızı karşılamak için ise Runnebla interface'sini kullanarak
        anonim inner class'lar ile sorunumuzu çözebiliriz.
         */


        // Thread oluşturmak için 3.yöntem:
        // new Thread(new Runnable() { .... }).start() diyerek anonim inner class ile thread oluşturabiliriz.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable anonim class calismaya basladi. Thhread adi : " + Thread.currentThread().getName());
                    Thread.sleep(10000); // İlgili thread'in 50000 milisaniye durmasını sağlar.
                    System.out.println("Runnable anonim class calismayi bitirdi. Thhread adi : " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();



        // Thread oluşturmak için 4. yöntem;
        // Inner class ile bir sınıf oluşturabiliriz.
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("Thread inner class calismaya basladi. Thhread adi : " + Thread.currentThread().getName());
                    Thread.sleep(10000); // İlgili thread'in 50000 milisaniye durmasını sağlar.
                    System.out.println("Thread inner class class calismayi bitirdi. Thhread adi : " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("Program bitti");

    }
}
