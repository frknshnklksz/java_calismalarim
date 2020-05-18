package com.company;

public class Main3 {
    //Kendi Exception Türünü oluşturma
    public static void main(String[] args) {

        Hata hata = new Hata();
        try {
            hata.fonksiyon();
        }catch (MyException me){
            System.out.println("Catch icine girdi");
            System.out.println(me.toString());
        }

    }
}

class MyException extends Exception{
    String hataMetni = "My String of Exception";
    String hataTipi = "Hata Tipi";

    public MyException() {
    }

    @Override
    public String toString() {
        hataMetni = hataMetni + String.format(" : " + hataTipi);
        return hataMetni;
    }
}


class Hata{
    public void fonksiyon() throws MyException{
        System.out.println("Bu fonksiyon calıstı");
        throw new MyException();
    }
}