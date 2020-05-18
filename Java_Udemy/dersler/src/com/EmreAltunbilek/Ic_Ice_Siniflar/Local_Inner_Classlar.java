package com.EmreAltunbilek.Ic_Ice_Siniflar;

public class Local_Inner_Classlar {
    public static void main(String[] args) {
        String bolme = new Calculator().bolmeYap(9,8);
        System.out.println(bolme);
    }
}

class Calculator{

    public String bolmeYap(int a, int b){
        class Bolme{
            public String bolme(int j, int i){
                if (i == 0){
                    System.out.println("Bolen sifir olamaz.");
                    return " ";
                }else {
                    int sonuc = j / i;
                    return String.valueOf(sonuc);
                }
            }
        }

        Bolme bolum = new Bolme();
        String sonuc = bolum.bolme(932,54);
        return sonuc;
    }

}
