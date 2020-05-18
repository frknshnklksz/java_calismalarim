package com.EmreAltunbilek.ProcesslerVeThreadler.ThreadCesitleri_Isimlendirmeler_IDler;

public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("USER YESIL THREAD", ThreadRenkler.Green, 5);
        myThread1.start();
        System.out.println("USER YESIL THREAD id'si : " + myThread1.getId());

        MyThread daemonThread1 = new MyThread("DAEMON KIRMIZI THREAD", ThreadRenkler.Red, 20);
        daemonThread1.setDaemon(true); //Normalde bu thread bu kod bloğı yokken bir user thread.
        daemonThread1.start();         // Ama daemonThread1.setDaemon(true); bu kod parçacığı sayesinde daemon thread oldu.
        System.out.println("DAEMON KIRMIZI THREAD id'si : " + daemonThread1.getId());

        Thread mainThread = Thread.currentThread();
        System.out.println("Thread adi : " + mainThread.getName() + " id' si : " + mainThread.getId());
    }
}

class MyThread extends Thread{

    private String renk;
    private int uyumaSaniyesi;

    public MyThread(String name, String renk, int uyumaSaniyesi) {
        super(name);
        this.renk = renk;
        this.uyumaSaniyesi = uyumaSaniyesi;
    }

    /*
    Kendi thread'lerimize istediğimiz bir id'yi veremiyoruz ama
    Sistemin bize oluşturduğu id numarası üzerinde bu şekilde oynama yapabiliyoruz.
     */
    @Override
    public long getId() {
        return super.getId() + 85;
    }

    @Override
    public void run() {
        System.out.println(renk + "Ben " + uyumaSaniyesi +  " saniyelik uzun suren islemi baslatiyorum. Thread Adi : " + Thread.currentThread().getName());
        try {
            Thread.sleep(uyumaSaniyesi * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(renk + "Ben "+ uyumaSaniyesi +" saniyelik uzun suren islemi bitiriyorum. Thread Adi : " + currentThread().getName());
    }
}
