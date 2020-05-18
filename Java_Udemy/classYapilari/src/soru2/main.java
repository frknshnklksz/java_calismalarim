package soru2;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Ogrenci tumOgrenciler[] = new Ogrenci[100];
        for (int i = 0; i <100 ; i++) {
            int rastgeleId = (int)Math.random() * 5000;
            int rastgeleNotDegeri = (int)Math.random() * 100;

            Ogrenci yeniOgrenci = new Ogrenci(rastgeleId, rastgeleNotDegeri);
            tumOgrenciler[i] = yeniOgrenci;
        }

        for (int i = 0; i <tumOgrenciler.length ; i++) {
            System.out.println(tumOgrenciler[i].getId());
            System.out.println(tumOgrenciler[i].getNotDegeri());
        }
    }
}
