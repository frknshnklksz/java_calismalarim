package com.EmreAltunbilek.Generic_Class.GenericClass;

public class GenericDiziYazdir<GelenVerituru> {
    public void yazdir(GelenVerituru[] dizi){
        for (GelenVerituru i:
             dizi) {
            System.out.println(i);
        }
    }
}
