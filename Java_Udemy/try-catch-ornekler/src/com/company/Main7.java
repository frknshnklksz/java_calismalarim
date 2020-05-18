package com.company;


//THROWS Kullanımı
public class Main7 {
    public static void main(String[] args) {
        try {
            metot3();
        }catch (NumberFormatException e){
            System.out.println("Hata Yakalandı : " + e);
        }

    }

    //Throws diyerek şunu söylüyoruz.
    //Dikkat et burada Number format Exception türünde hata yakalanabilir.
    //Kontrollü istisnalar - kontrolsüz istisnalar ile alakalı bir durum.
    //Buradaki kontrolsüz istisna
    private static void metot() throws NumberFormatException {
        Integer sayi = Integer.parseInt("abc");
    }

    private static void metot2() throws NumberFormatException, NullPointerException {
        metot();
    }

    private static void metot3() throws NumberFormatException {
        metot2();
    }
}

class A{
    void aMethodu(){
        System.out.println("A sınıfındaki method.");
    }
}

class B extends A{
    @Override
    void aMethodu() throws ArrayIndexOutOfBoundsException {
        System.out.println("B sınıfındaki metot");
    }
}


/*
C sınfındaki throws ifadesini kaldırabiliriz.
Ya da oraya başka exceptionlar ekleyebiliriz.
Hata çıkmayacaktır.
Ama kontrollü exception tanımı koyarsak hata verir.
Üst sınıflara da kontrollü exceptionsları almalıyız. (throws yerine)
Ama tam tersi geçerli değildir. Yani üst sınıfta throws "kontrollüException" varsa
alt sınıfta throws içinde olmak zorunda değil.
Ama alt sınıfta üst sınıftaki methodun aynısını kullanıyorsak (super)
o kontrollü istisnayı da alt sınıfta belirtmemiz gerekir.
 */
class C extends B{
    @Override
    void aMethodu() throws ArrayIndexOutOfBoundsException {
        System.out.println("C sınıfındaki metot");
    }
}