package com.company;

public class Main2 {
    /*
    Bu örnek "THROWS" anahtar kelimesine yönelik bir uygulamadır.
     */
    public static void main(String[] args) {

        methodCagir();
    }

    public static void elemanYazdir() throws Exception{
        int dizi[] = new int[]{1,2,3,4};
        System.out.println("Burası elemanYazdir Methodu");
        System.out.println(dizi[4]);
    }

    public static void methodCagir(){
        try {
            elemanYazdir();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println("elemanYazdir methodu cagrildi");
    }
}
