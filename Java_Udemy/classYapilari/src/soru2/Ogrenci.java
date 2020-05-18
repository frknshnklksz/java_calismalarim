package soru2;

public class Ogrenci {
    private int id;
    private int notDegeri;

    public Ogrenci(int id, int notDegeri) {
        this.id = id;
        this.notDegeri = notDegeri;
    }

    public int getId() {
        return id;
    }

    public int getNotDegeri() {
        return notDegeri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNotDegeri(int notDegeri) {
        this.notDegeri = notDegeri;
    }

    public void ogrenciBilgileriniYazdir(){
        System.out.println("id: " + id + "not bilgisi: " + notDegeri);
    }
}
