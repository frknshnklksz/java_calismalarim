package com.EmreAltunbilek.Polymorphism;

import javafx.scene.Camera;

public class Ornek {
    public static void main(String[] args) {
        Canli canli = new Canli();
        canli.adiniSoyle();

        /*
        Oyna ve Uc methodları hata veriyor.
        Canli türünden Kartal ve Panda turettigimizde
        Cunku bunlara runtime'da karar verdiği için
        bilemiyor hangisine atacağını
         */
        Canli kartal = new Kartal();
        kartal.adiniSoyle();
        ((Kartal)kartal).uc();

        Canli panda = new Panda();
        panda.adiniSoyle();
        ((Panda)panda).oyna();
    }

    public static Canli rastgeleSec(){
        int sec = (int)(Math.random() * 3);
        Canli canli;
        if(sec == 0){
            canli = new Canli();
        }else if( sec == 1){
            canli = new Kartal();
        }else {
            canli = new Panda();
        }
        return canli;
    }
}

class Canli{
    public void adiniSoyle(){
        System.out.println("Ben bir canli sinifi methoduyum.");
    }
}

class Kartal extends Canli{
    @Override
    public void adiniSoyle() {
        System.out.println("Ben bir kartal sinifi methoduyum");
    }

    public void uc(){
        System.out.println("Ben ucabilirim");
    }
}

class Panda extends Canli{
    @Override
    public void adiniSoyle() {
        System.out.println("Ben bir panda sinifi methoduyum");
    }

    public void oyna(){
        System.out.println("Ben oyun oynamayi severim.");
    }
}