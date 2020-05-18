package com.EmreAltunbilek.ProcesslerVeThreadler.Uretici_Tuketici_Problemi;

import com.EmreAltunbilek.ProcesslerVeThreadler.ThreadCesitleri_Isimlendirmeler_IDler.ThreadRenkler;
/*

Burada ele alınan problem şu.
Elimizde bir kaynak olsun. (Üretici)
Sonra bu kaynağa ulaşıp kaynakları kullanmak isetyen başka bir yapı olsun. (Tüketici)

Şunu hedefliyoruz;
Kaynak, bir veri oluşturduğunda o veri tüketilsin. Sonra yeni bir kaynak oluşsun.
Yani sırasıyla çalışsın.

Process, aslında çalıştırdığımız bütün java dosyaları. Biz bir java projesine run
dediğimiz anda arka tarafta bir heap alanı ayrılıyor ve main thread burada çalışıyor.

Sorun şu ki;
Daha üretici kaynağı üretmeden tüketici o kaynağı kullanıyor.

Bu kod parçası çalıştığında bunu görüyoruz.
Çözüm ise bu package'de bulunan Main2 sınıfında.

 */
public class Main {
    public static void main(String[] args) {
        OrtakAlan2 ortakAlan = new OrtakAlan2();
        Uretici2 ureticiThread = new Uretici2(ortakAlan);
        Tuketici2 tuketiciThread = new Tuketici2(ortakAlan);

        ureticiThread.start();
        tuketiciThread.start();
    }
}

class OrtakAlan{
    private int veri;

    public int veriAl(){
        return veri;
    }

    public void veriYaz(int v){
        this.veri = v;
    }
}

class Uretici extends Thread{
    private OrtakAlan2 ortakAlan;

    public Uretici(OrtakAlan2 o){
        this.ortakAlan = o;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            ortakAlan.veriYaz(i);
            System.out.println(ThreadRenkler.Magenta+"Uretici thread tarafindan konulan veri : " + i);
            try {
                sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Tuketici extends Thread{
    private OrtakAlan2 ortakAlan;

    public Tuketici(OrtakAlan2 o){
        this.ortakAlan = o;
    }

    @Override
    public void run() {
        int okunanDeger = 0;
        for (int i = 1; i <= 10; i++) {
            okunanDeger = ortakAlan.veriAl();
            System.out.println(ThreadRenkler.Yellow+"Tuketici thread tarafindan alinan veri : " + okunanDeger);
            try {
                sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
