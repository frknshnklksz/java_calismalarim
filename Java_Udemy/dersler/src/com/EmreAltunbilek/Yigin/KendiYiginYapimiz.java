package com.EmreAltunbilek.Yigin;

//import com.EmreAltunbilek.Kalitim.GeometrikSekil;

import java.util.ArrayList;

//Yığın çalışma mantığı ilk giren son çıkar
//Elemanları çıkarmak için pop()
//eleman eklemek için push()
public class KendiYiginYapimiz {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Ogrenci ogrenci1 = new Ogrenci(12, "Furkan", "Kulaksiz");
        Ogrenci ogrenci2 = new Ogrenci(13, "Alperen", "Kulaksiz");
        Ogrenci ogrenci3 = new Ogrenci(14, "Ahmet", "Kulaksiz");
        Araba araba1 = new Araba(400, "Kirmizi", "BMW", 2018, 15000);
        Araba araba2 = new Araba(300, "Siyah", "PORSCHE", 2018, 15000);
        Araba araba3 = new Araba(200, "Gri", "HONDA", 2018, 15000);
        Memur memur1 = new Memur(30, "Irfan", "Kulaksiz", "Hukuk", 4500);
        myStack.push("Sahin");
        myStack.push(4);
        myStack.push(ogrenci1);
        myStack.push(araba1);
        myStack.push(araba2);
        myStack.push(ogrenci2);
        myStack.push(memur1);
        myStack.push(4.4);
        myStack.push(araba3);
        myStack.push(ogrenci3);
        myStack.goster();

    }
}

class MyStack{
    private ArrayList<Object> liste;

    public MyStack(){
        liste = new ArrayList<>();
    }

    public int kacElemanVar(){
        return liste.size();
    }
    public boolean bosMu(){
        //return liste.isEmpty(); bu fonksiyonun alternatifi
        if (liste.size() > 0){
            return false;
        }else return true;
    }
    public Object elemanGoster(){
        return liste.get(kacElemanVar() - 1);
    }
    public Object pop(){
        if (kacElemanVar() > 0){
            Object cikarilacakEleman = liste.get(kacElemanVar() - 1);
            liste.remove(kacElemanVar() - 1);
            return cikarilacakEleman;
        }else {
            System.err.println("Yigin bos. Cikarma yapilamaz");
            return null;
        }


    }
    public void push(Object eklenecekEleman){
        liste.add(eklenecekEleman);
    }
    public void goster(){
        System.out.println("Yigin Icerigi");
        for (int i = 0; i <liste.size() ; i++) {
            System.out.println(i+" indkeste : " + liste.get(i));
        }
    }
}
