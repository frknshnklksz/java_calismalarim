package com.company;

public class Main6 {
    public static void main(String[] args) {
        System.out.println(stringDegerDondurenMethod());
        System.out.println(stringDegerDondurenMethod2());
        System.out.println(stringDegerDondurenMethod3());
        try {
            System.out.println(stringDegerDondurenMethod4());
        }catch (Exception e){
            System.out.println("Main methodtaki catch");
        }

    }

    private static String stringDegerDondurenMethod4() {
        /*
        Burada olan şey şu.
        Throwdan sonra return çalıştıramayız.
        Return'ü throwdan önce çalıştıramayız.
        Throwdan dolayı methodun çağırıldığı yerde try - catch arar.
        çağırıldığı yerde catch'i dönderir ve o catch çalıştırır.
         */
        String selam = "Merhaba";
        ArithmeticException ae = new ArithmeticException();
        throw ae;
    }

    private static String stringDegerDondurenMethod3() {
        String selam = "Merhaba";
        try {
            selam = selam + "try";
            ArithmeticException ae = new ArithmeticException();
            throw ae;
        }catch (Exception e){
            selam = selam + "catch";
            System.out.println("Try - Catch bloğunda hata yakalandı");
            return selam;
        }finally {
            selam = selam + "finally";
            return selam; // Buradaki return tetiklenir. Çünkü en son çalışan yer burası.
        }
    }


    private static String stringDegerDondurenMethod2() {

        /*
        Aşağıdaki methodta try-catch çalışsa da çalışmasa da
        her türlü finally bloğuna gireceği için ve orada da
        return işlemi olduğu için methot kızmadı.
         */
        String selam = "Merhaba";
        try {
            selam = selam + "try";
        }catch (Exception e){
            selam = selam + "catch";
        }finally {
            selam = selam + "finally";
            return selam;
        }
    }


    private static String stringDegerDondurenMethod() {
        String selam = "Merhaba";

        /*
        Aşağıdaki blokta en son return edilen yapı finally olduğu için
        ve aşağıdaki kodda herhangi bir hata olmadığı için
        Ve string kullanıldığı için Merhaba Try finally çıktısını gördüm.
         */

        try {
            selam = selam + "try";
            return selam;
        }catch (Exception e){
            selam = selam + "catch";
            return selam;
        }finally {
            selam = selam + "finally";
            return selam;
        }
    }
}
