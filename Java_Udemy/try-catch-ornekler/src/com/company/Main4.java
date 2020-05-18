package com.company;

public class Main4 {
    public static void main(String[] args) {
        /*
        Kodumuzun içinde birden fazla hata çıkabilir.
         */

        String[] dizi = {"abc", null, "1234", "bdc"};
        for (int i = 0; i <dizi.length + 2 ; i++) {
            try{
                int uzunluk = dizi[i].length() + Integer.parseInt(dizi[i]);
            }catch (NumberFormatException nfe){
                System.out.println("Number Format Exception bloğu");
                System.out.println(nfe);
            }catch (NullPointerException npe){
                System.out.println("Null Pointer Exception bloğu");
                System.out.println(npe);
            }catch(ArrayIndexOutOfBoundsException aiobe){
                System.out.println("Array Index Out Of Bounds Exception bloğu");
                System.out.println(aiobe);
            }
        }

        System.out.println("-------------------------------------");
        System.out.println("Yukarıdaki hatalı bloğun aynısı");
        System.out.println("-------------------------------------");

        for (int i = 0; i <dizi.length + 2 ; i++) {
            try{
                int uzunluk = dizi[i].length() + Integer.parseInt(dizi[i]);
            }catch (Exception e){
                //Güzel bir polymorphism örneği aynı zamanda
                System.out.println(e);
            }
        }


        System.out.println("------------------------------------------");
        System.out.println("JAVA 7 ile GELEN GUZEL BIR YAZIM TARZI");
        System.out.println("------------------------------------------");

        for (int i = 0; i <dizi.length + 2 ; i++) {
            try{
                int uzunluk = dizi[i].length() + Integer.parseInt(dizi[i]);
            }catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }
        }


        System.out.println("------------------------------------------");
        System.out.println("SIRALAMA ONEMLI");
        System.out.println("------------------------------------------");


        for (int i = 0; i <dizi.length + 2 ; i++) {
            try{
                int uzunluk = dizi[i].length() + Integer.parseInt(dizi[i]);
            }catch (NullPointerException e){
                System.out.println(e);
            }
            catch (Exception e){
                System.out.println(e);
            }catch (Throwable e){
                System.out.println("Throwable blogu" + e.toString());
                //Çıktıda Throwable'ı göremedik .ünkü exception bütün hataları yakaladı.
            }
        }


        System.out.println("------------------------------------------");
        System.out.println("IC ICE TRY CATCH BLOGU YAPILABILIR");
        System.out.println("------------------------------------------");

        for (int i = 0; i <dizi.length + 2 ; i++) {
            try{
                int uzunluk = dizi[i].length();
                try{
                    uzunluk = Integer.parseInt(dizi[i]);
                }catch (NumberFormatException e){
                    System.out.println(e);
                }catch (Exception e){
                    System.out.println(e);
                }
            }catch (NullPointerException e){
                System.out.println(e);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
