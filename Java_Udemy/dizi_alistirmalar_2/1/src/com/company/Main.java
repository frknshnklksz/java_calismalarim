package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number;
        float average;
        float resultArray = 0;
        System.out.print("How many entry number : ");
        Scanner entryData = new Scanner(System.in);
        number = entryData.nextInt();
        int numbers[] = new int[number];
        for (int i = 0; i <numbers.length ; i++) {
            System.out.print("Please enter number "+(i+1)+" : ");
            numbers[i] = entryData.nextInt();
        }
        for (int i = 0; i <numbers.length ; i++) {
            System.out.println("Number" + (i+1) + ": "+numbers[i]);
        }
        for (int i = 0; i <numbers.length ; i++) {
            resultArray = resultArray + numbers[i];
        }
        average = resultArray / number;
        System.out.print("Average : " + average);
    }
}
