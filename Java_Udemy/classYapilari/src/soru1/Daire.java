package soru1;

public class Daire {
    public static final double PI = 3.14;

    private double r;

    public Daire(double r) {
        this.r = r;
    }

    public double alanHesapla(){
        return 2*PI*this.r;
    }

    public double cevreHesapla(){
        return PI*Math.pow(r,2);
    }
}
