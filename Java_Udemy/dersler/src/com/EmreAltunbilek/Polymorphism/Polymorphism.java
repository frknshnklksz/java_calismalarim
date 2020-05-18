package com.EmreAltunbilek.Polymorphism;
public class Polymorphism {
    public static void main(String[] args) {

        Hayvan h1 = new Hayvan();
        Kopek kopek1 = new Kopek("GOLDEN");
        Kedi kedi1 = new Kedi("VAN KEDISI");

        siniflardakiMethodlar(h1);
        siniflardakiMethodlar(kopek1);
        siniflardakiMethodlar(kedi1);

    }

    /*
    Biz buraya adiniSoyle diye bir methot tanımlayıp hepsi içn farklı farklı
    methodlar yazabiliriz. (Method Overloading)
    Ama polymorphism ile Gelen parametresi en üst sınıftan olacak şekilde
    bir method yazarsak tek bir methodla işi çözeriz.
     */
    public static void siniflardakiMethodlar(Hayvan hayvan){
        hayvan.adiniSoyle();
    }
}

class Hayvan{
    private int ayakSayisi;

    public int getAyakSayisi() {
        return ayakSayisi;
    }

    public void setAyakSayisi(int ayakSayisi) {
        this.ayakSayisi = ayakSayisi;
    }

    public void adiniSoyle(){
        System.out.println("Ben hayvan sınıfı methoduyum.");
    }
}

class Kopek extends Hayvan{
    private String tur;

    public Kopek(String tur){
        setAyakSayisi(4);
        setTur(tur);
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public void adiniSoyle() {
        System.out.println("Ben kopek sınıfı methoduyum");
    }
}

class Kedi extends Hayvan{
    private String cinsi;

    public Kedi(String cinsi){
        setAyakSayisi(4);
        setCinsi(cinsi);
    }

    public String getCinsi() {
        return cinsi;
    }

    public void setCinsi(String cinsi) {
        this.cinsi = cinsi;
    }

    @Override
    public void adiniSoyle() {
        System.out.println("Ben Kedi sınıfı methoduyum.");
    }
}
