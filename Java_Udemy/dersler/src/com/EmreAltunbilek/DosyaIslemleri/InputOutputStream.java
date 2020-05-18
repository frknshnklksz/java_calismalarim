package com.EmreAltunbilek.DosyaIslemleri;

import java.io.*;

public class InputOutputStream {
    public static void main(String[] args) {
        dosyayaYaz();

        dosyadanOku();
    }

    private static void dosyadanOku() {
        DataInputStream dataInputStream = null;
        boolean dosyaSonu = false;
        try{
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("ogrenciler.txt")));
            Ogrenci okunanOgrenci;

            while (!dosyaSonu){
                try{
                    int id = dataInputStream.readInt();
                    String isim = dataInputStream.readUTF();
                    boolean aktiflik = dataInputStream.readBoolean();
                    okunanOgrenci = new Ogrenci(id, isim, aktiflik);
                    System.out.println(okunanOgrenci);
                }catch (EOFException e){
                    dosyaSonu = true;
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void dosyayaYaz() {
        // Bu şekilde dosyaya byte byte veriler aktarılacak. Bu şekilde atmak performanslı değil.
        // Bu yüzden buffer kullanmalıyız.
        // Buffer ile verileri önce biriktirip sonra tek bir seferde dosyaya aktarıyoruz.
        DataOutputStream dataOutputStream = null;
        Ogrenci ogrenci1 = new Ogrenci(1,"Sahin", false);
        Ogrenci ogrenci2 = new Ogrenci(2,"Furkan", true);
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ogrenciler.txt")));
            try {
                dataOutputStream.write(ogrenci1.id);
                dataOutputStream.writeUTF(ogrenci1.isim);
                dataOutputStream.writeBoolean(ogrenci1.aktif);

                dataOutputStream.write(ogrenci2.id);
                dataOutputStream.writeUTF(ogrenci2.isim);
                dataOutputStream.writeBoolean(ogrenci2.aktif);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Ogrenci{
    int id;
    String isim;
    boolean aktif;

    public Ogrenci(int id, String isim, boolean aktif) {
        this.id = id;
        this.isim = isim;
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", aktif=" + aktif +
                '}';
    }
}


            /*
            Bu kötü bir yöntemdir. Bu şekilde  100 tane veri okuyamayız. Bunun için
            EOF denilen dosya sonuna kadar bir while döngüsü ile okumak gerekir.
                      Ogrenci okunanOgrenci1;
            int id = dataInputStream.readInt();
            String isim = dataInputStream.readUTF();
            boolean aktif = dataInputStream.readBoolean();
            okunanOgrenci1 = new Ogrenci(id, isim, aktif);
            System.out.println(okunanOgrenci1);

            Ogrenci okunanOgrenci2;
            int id2 = dataInputStream.readInt();
            String isim2 = dataInputStream.readUTF();
            boolean aktif2 = dataInputStream.readBoolean();
            okunanOgrenci2 = new Ogrenci(id2, isim2, aktif2);
            System.out.println(okunanOgrenci2);
        } catch (EOFException e){
            dosyaSonu = true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
             */
