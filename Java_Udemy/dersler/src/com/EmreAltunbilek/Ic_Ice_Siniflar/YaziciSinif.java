/*
--------------- IC ICE SINIFLAR ---------------
1) Bu örnekteki gibi bir kullanım yapılabilir. Dıştaki sınıf public veya default olabilir.
Ama alt sınıfların erişim belirleyicisi her şey olabilir.
2) İçteki sınıfın erişim belirleyicisi ne olursa olsun dış sınıfların bütün alanlarına
ve methodlarına ulaşabilir.
3) Aynı şekilde üst sınıflar da içteki sınıfların erişim belirleyicisi ne olursa olsun
bütün methodlarına ve alanlarına ulaşabilir.
4) Dıstaki sınıftan icteki sınıfın özelliklerine erişebilmek için nesne üretmek lazım.
5) İçteki sınıflarda sadece statik ile imlenen bir değişken olamaz. Ama statik final (her ikisi ile de imlenen)
değişkenler olabilr.
6) İçteki sınıflarda statik method olamaz.
static{
.....
}
7) İçteki sınıflar abstract olabilir.
8) İçteki sınıflar direk sade yazılabilir.
{
...
}
 */

package com.EmreAltunbilek.Ic_Ice_Siniflar;

import javax.crypto.spec.PSource;

public class YaziciSinif {
    private int privateDegisken = 1;
    int defaultDegisken = 2;
    protected int protectedDegisken = 3;
    public int publicDegisken = 4;

    StringDiziYazdir nesne = new StringDiziYazdir();
    private void privateMethod(){
        System.out.println("Private Method");
        System.out.println(nesne.privateInnerDegisken);
    }


    void defaultMethod(){
        System.out.println("Default Method");
        System.out.println(nesne.defaultInnerDegisken);

    }

    protected void protectedMethod(){
        System.out.println("Protected Method");
        System.out.println(nesne.protectedInnerDegisken);
    }

    public void publicMethod(){
        System.out.println("Public Method");
        System.out.println(nesne.publicInnerDegisken);
    }

    public StringDiziYazdir getNesne() {
        return nesne;
    }

      class StringDiziYazdir{

        static final int sayi = 100;

        private int privateInnerDegisken = 1;
        int defaultInnerDegisken = 2;
        protected int protectedInnerDegisken = 3;
        public int publicInnerDegisken = 4;


         void stringDiziYazdir(String[] dizi){

            System.out.println(privateDegisken);
            System.out.println(defaultDegisken);
            System.out.println(protectedDegisken);
            System.out.println(publicDegisken);

            privateMethod();
            defaultMethod();
            protectedMethod();
            publicMethod();


            for (String i:
                 dizi) {
                System.out.println(i);
            }
        }
    }

}
