package com.EmreAltunbilek.LambdaExpressions;

import java.util.function.Function;

/*
Function interface'nin apply ifadesinin apply methodunu gerçekleştiren ve
method içerisine girilen ifadenin çift sayılı pozisyonlarında bulunan elemanları geriye
dönecek şekilde yazılan lambda ifade
 */
public class LambdaOrnek2 {
    public static void main(String[] args) {

        String ifade = "Ankara Sincan Elvankent Etimesgut";

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i <s.length() ; i++) {
                    if (i % 2 == 0){
                        builder.append(s.charAt(i));
                    }
                }
                return builder.toString();
            }
        };

        Function<String, String> function2 = (String s) -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i <s.length() ; i++) {
                if (i % 2 == 0){
                    builder.append(s.charAt(i));
                }
            }
            return builder.toString();
        };

        System.out.println(function.apply("Furkan"));
        System.out.println(function2.apply("Java Egitim Seti"));

    }
}
