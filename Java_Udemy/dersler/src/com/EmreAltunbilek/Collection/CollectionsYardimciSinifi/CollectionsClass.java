package com.EmreAltunbilek.Collection.CollectionsYardimciSinifi;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsClass {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Furkan");
        Student student2 = new Student(9,"Sahin");
        Student student3 = new Student(5,"Kulaksiz");
        Student student4 = new Student(8,"Alperen");
        Student student5 = new Student(7,"Ahmet");
        Student student6 = new Student(4,"Irfan");
        Student student7 = new Student(9,"Fatma");

        ArrayList<Student> ogrenciler = new ArrayList<>();
        ogrenciler.add(student1);
        ogrenciler.add(student2);
        ogrenciler.add(student3);
        ogrenciler.add(student4);
        ogrenciler.add(student5);
        ogrenciler.add(student6);
        ogrenciler.add(student7);

        /*
        Asagidaki kod satiri hata vericektir. Çünkü neye göre max değeri getirecek.?
        Burada 2 farklı yöntem var. Burada ya comperator interface'sini anonim inner class şeklinde oluşturacağız.
        Ya da comparable interface'sini sınıfımızda implemente edeceğiz.
         */
        /* -- Bu yapı id lere göre kıyaslama yapar.
        Student enBuyukOgrenci = Collections.max(ogrenciler, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.id > t1.id){
                    return 1;
                }else if (student.id < t1.id){
                    return -1;
                }else return 0;
            }
        });*/

        Student enBuyukOgrenci = Collections.max(ogrenciler, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.isim.compareTo(t1.isim) < 0){
                    return -1;
                }else if (student.isim.compareTo(t1.isim) > 0){
                    return 1;
                }else return 0;
            }
        });

        System.out.println(enBuyukOgrenci);

        /*
        Aşağıdaki method'da ilk tanımlanırken bize kızacaktır. Çünkü yukarıdaki method'da
        compareTo methodu ve comperator interface'si sadece max bulma methoduna özgüydü.
        Burada ya yukarıdaki mantığın aynısını yapacağız ya da Student class'ında comparable
        interface'sini implemente edeceğiz.
         */
        Student enKucukOGrenci = Collections.min(ogrenciler); // Student class'ımızda comparable interface'sini ve
        //compareTo methodunu yazdığımızdan dolayı bize kızmadı. Burada ise id'ye göre karşılaştırma yaptık.
        System.out.println(enKucukOGrenci);

        System.out.println("siralamadan sonra.");
        System.out.println("Ogrencileri spesifik olarak id'lere göre buyukten kucuge siralamak istiyordum ve");
        System.out.println("bunun icin sort methodunda yeni bir anonim inner class olusturdum");
        Collections.sort(ogrenciler, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.id > t1.id){
                    return -1;
                }else if (student.id < t1.id){
                    return 1;
                }else return 0;
            }
        });

        System.out.println(ogrenciler);

        System.out.println("Shuffle methodu : -> Bir deste gibi listeyi karar.");
        Collections.shuffle(ogrenciler);
        System.out.println(ogrenciler);

        System.out.println("Binary Searc -> Bir integer deger dondurur. Aranilan" +
                "\nseyi bulursa pozitif index dondurur. Bulamazsa negatif dondurur.");

        Collections.sort(ogrenciler);
        //int sonuc = Collections.binarySearch(ogrenciler, student7);
        // sonuc pozitifse index değeri verir.
        // binary search'te elemanların sıralı olması gerekiyor.

        Collections.reverse(ogrenciler); //-> Sıralanan elemanlari tersten srialar.

        ArrayList<Student> yedekListe = new ArrayList<>(ogrenciler);  //Var olan bir listeyi baska bir array list'e atar.
        System.out.println(yedekListe);
    }
}

class Student implements Comparable{
    int id;
    String isim;

    public Student(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                '}';
    }

    /*
    Burada şöyle bir soru sorulabilir. Aşağıdaki yapıda parametre olarak
    sadece bir tane Object türünde bir değer var. "Neyi neyle karşılaştıracak"
    dediğimizde "this" keywordu karşılaştıracağı diğer parametre olacaktır.
     */
    @Override
    public int compareTo(Object o) {
        Student gecici = (Student)o;
        if (this.id > gecici.id){
            return 1;
        }else if (this.id < gecici.id){
            return -1;
        }else return 0;
    }
}