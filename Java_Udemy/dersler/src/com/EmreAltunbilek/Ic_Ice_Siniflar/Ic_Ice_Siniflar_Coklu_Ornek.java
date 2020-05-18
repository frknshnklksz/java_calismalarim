package com.EmreAltunbilek.Ic_Ice_Siniflar;

public class Ic_Ice_Siniflar_Coklu_Ornek {
    public static void main(String[] args) {
        A.B.C.D dNesnesi = new A().new B().new C().new D();
        dNesnesi.MethodD();

        A.B bNesnesi = new A().new B();
        bNesnesi.new C().new D().MethodD();
    }
}


class A{
    class B{
        void methodB(){
            System.out.println("B Sinifi");
        }
        class C{
            class D{
                void MethodD(){
                    System.out.println("D Sinifi (En icteki Sinifin methodu)");
                }
            }
        }
    }
}