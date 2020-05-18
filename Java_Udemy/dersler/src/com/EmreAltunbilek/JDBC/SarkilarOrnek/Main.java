package com.EmreAltunbilek.JDBC.SarkilarOrnek;

import com.EmreAltunbilek.JDBC.SarkilarOrnek.Model.DataSource;
import com.EmreAltunbilek.JDBC.SarkilarOrnek.Model.Sarki;
import com.EmreAltunbilek.JDBC.SarkilarOrnek.Model.Sarkici;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        dataSource.veriTabaniniAc();

        ArrayList<Sarkici> tumSarkicilariGetir = dataSource.tumSarkicilariGoster(DataSource.SIRALA_AZALAN);
        if (tumSarkicilariGetir == null){
            System.err.print("Sarkici Bilgileri bulunamamistir..!");
            return;
        }else{
            for (Sarkici tmp:
                 tumSarkicilariGetir) {
                System.out.print("Sarkici Adi : " + tmp.getSarkiciAdi() + " Sarkici Id : " + tmp.getSarkiciId());
                System.out.println();
            }
        }
        dataSource.veriTabaniniKapat();
    }
}
