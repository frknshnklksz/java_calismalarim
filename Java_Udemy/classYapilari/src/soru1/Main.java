package soru1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double number;
        System.out.print("Please enter data for Daire: ");
        Scanner data = new Scanner(System.in);
        number = data.nextDouble();
        Daire d = new Daire(number);


        System.out.println(d.cevreHesapla());
        System.out.println(d.alanHesapla());
    }
}
