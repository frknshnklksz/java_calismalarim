package com.EmreAltunbilek.LambdaExpressions;
/*
İçerisinde tek bir method bulunan interface'lere functional interface denir.
 */
public class Main2 {
    public static void main(String[] args) {
        new Thread(new ThreadSinifi()).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonim run sinifi calisti.");
            }
        }).start();*/

        new Thread(() -> System.out.println("Lambda Expression ile run calisti.")).start();
        // * () : Parametre Listesi
        // * -> : lambda ifadesi
        // * interface'in içindeki tek methodun yapacağı işlem.
        // Eğer interface'in içindeki tek methodun yapacağı işlem tek satırdan fazla olursa
        // aşağıdaki gibi ilgili kod bloğunu süslü parantezler içerisine almam yeterli olacaktır.
        //new Thread(() -> { System.out.println("Lambda Expression ile run calisti.") }).start() ;

    }
}

class ThreadSinifi implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread sinifi calisti.");
    }
}
