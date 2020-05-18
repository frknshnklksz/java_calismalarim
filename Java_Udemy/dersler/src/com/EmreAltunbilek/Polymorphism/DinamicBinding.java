package com.EmreAltunbilek.Polymorphism;

public class DinamicBinding {
    public static void main(String[] args) {

        UstSinifim ustSinifim = new UstSinifim();
        ustSinifim.adiniSoyle();

        AltSinifim altSinifim = new AltSinifim();
        altSinifim.adiniSoyle();

        UstSinifim ustSinifim2 = new AltSinifim();
        ustSinifim2.adiniSoyle();
    }
}

class UstSinifim{
    public void adiniSoyle(){
        System.out.println("Ust sinifin adini soyle methodu cagrildi");
    }
}

class AltSinifim extends UstSinifim{
    @Override
    public void adiniSoyle() {
        System.out.println("Alt sinifin adini soyle methodu cagrildi");
    }
}
