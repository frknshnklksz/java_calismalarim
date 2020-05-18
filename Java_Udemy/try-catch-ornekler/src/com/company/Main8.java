package com.company;

import java.util.Scanner;

//Keni Istisna Sınıfımızı Oluşturmak
public class Main8 {
    public static void main(String[] args) {
        Scanner veriAl = new Scanner(System.in);
        System.out.println("Yasinizi giriniz.");
        int yas = veriAl.nextInt();

        try{
            if(yas < 0){
                throw new NegatifYasHatasi("Yas negatif olamaz");
            }
        }catch (Exception e){
            System.out.println("Hata: " + e);
        }

    }
}


class NegatifYasHatasi extends Exception{
    String hataMesaji;

    public NegatifYasHatasi(String hataMesaji) {
        this.hataMesaji = hataMesaji;
    }

    @Override
    public String toString() {
        return hataMesaji;
    }
}

