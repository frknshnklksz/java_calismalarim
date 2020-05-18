package com.company;

public class Main5 {
    public static void main(String[] args) {
        try {
            hataOlustur();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

    }

    private static void hataOlustur() {
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
            }
        }

        System.out.println("Hata oluştur methodunun sonu");
    }
}
