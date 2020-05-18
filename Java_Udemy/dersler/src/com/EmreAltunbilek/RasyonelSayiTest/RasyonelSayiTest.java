package com.EmreAltunbilek.RasyonelSayiTest;

import com.EmreAltunbilek.RasyonelSayi;

public class RasyonelSayiTest {
    public static void main(String[] args) {
        RasyonelSayi rasyonelSayi1 = new RasyonelSayi(4,9);
        RasyonelSayi rasyonelSayi2 = new RasyonelSayi(7,9);

        System.out.println(rasyonelSayi1.topla(rasyonelSayi2));
    }
}
