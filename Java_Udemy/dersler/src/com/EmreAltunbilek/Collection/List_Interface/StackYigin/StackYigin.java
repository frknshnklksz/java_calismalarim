package com.EmreAltunbilek.Collection.List_Interface.StackYigin;

import java.util.Stack;
/*
----------------------------------- STACK KULLANIMI -----------------------------------
***************************************************************************************
-> First in last out (İlk giren son çıkar mantığıu ile çalışır.)
-> Vektor sınıfından extend edilmiştir.
 */
public class StackYigin {
    public static void main(String[] args) {
        Stack<String> yigin = new Stack<>();
        yigin.add("Emre");
        yigin.add("Furkan");
        yigin.add("Kulaksiz");
        yigin.add("Ahmet");
        System.out.println(yigin);

        System.out.println(yigin.pop()); //Stack'teki en son değeri çıkarır. burada sout içine yazdığımız için de gösterir.
        System.out.println(yigin.peek()); //Stack'teki son elemanı gösterir ama çıkarmaz.
        System.out.println(yigin.push("Sahin")); //Yiginin sonuna eleman ekler.
        System.out.println(yigin.search("emre")); //Emre ifadesi varsa index değerini verir. bulamazsa -1 döndürür.



    }
}
