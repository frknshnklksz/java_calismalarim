package com.company;

public class Main {

    /*
    Bu Sınıf kendi Exception Mesajımızı oluşturmaya yönelik bir örnektir.
     */
    public static void main(String[] args) {
        try{
            System.out.println(sayiBol(7,0));
            System.out.println(sayiBol(7,1));
        }catch (ArithmeticException ae){
            System.out.println(ae.toString());
        }

    }

    public static int sayiBol(int sayi1, int sayi2){
        if (sayi2 == 0){
            throw new ArithmeticException("Ikinci sayi 0 dan farkli olmalidir.");
        }else {
            int sonuc = sayi1 / sayi2;
            return sonuc;
        }
    }
}
