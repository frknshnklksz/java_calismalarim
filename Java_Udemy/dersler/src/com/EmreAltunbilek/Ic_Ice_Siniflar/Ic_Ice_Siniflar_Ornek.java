package com.EmreAltunbilek.Ic_Ice_Siniflar;

public class Ic_Ice_Siniflar_Ornek {
    public static void main(String[] args) {
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
        HesapMakinesi.Topla topla = hesapMakinesi.new Topla();
        int toplam = topla.topla(7,8);
        System.out.println("Toplam : " + toplam);

        HesapMakinesi.Cikar cikar = hesapMakinesi.new Cikar();
        int fark = cikar.cikar(10,12);
        System.out.println("Fark : " + fark);

        int carpim = hesapMakinesi.carpim(7,5);
        System.out.println("Carpim : " + carpim);

    }
}

class HesapMakinesi{
    public class Topla{
        public int topla(int i, int j){
            return i + j;
        }
    }

    public int carpim(int a, int b){
        Carpma carpma = new Carpma();
        int carpim = carpma.carpma(a,b);
        return carpim;
    }


    class Cikar{
        public int cikar(int a, int b){
            return a - b;
        }
    }

    private class Carpma{
        public int carpma(int a, int b){
            return a * b;
        }
    }

    class Bolme{
        public String bolme(int a, int b){
            if (b == 0){
                System.out.println("Bolen sifir olamaz");
                return " ";
            }else{
                int sonuc = a / b;
                return String.valueOf(sonuc);
            }
        }
    }
}
