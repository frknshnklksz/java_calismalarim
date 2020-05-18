package com.EmreAltunbilek;

import java.util.Objects;

public class RasyonelSayi implements Comparable<RasyonelSayi>{
    private int pay;
    private int payda;

    public RasyonelSayi(){
        pay = 0;
        payda = 1;
    }

    public RasyonelSayi(int pay, int payda) {
        int ebob = ebobBul(pay, payda);
        this.pay = ((payda > 0) ? 1 : -1) * (pay / ebob);
        this.payda = Math.abs(payda) / ebob;
    }

    private int ebobBul(int pay, int payda) {
        int payMutlakDeger = Math.abs(pay);
        int paydaMutlakDeger = Math.abs(payda);
        int ebob = 1;
        for (int i = 1; i <= payMutlakDeger && i <= paydaMutlakDeger; i++){
            if (payMutlakDeger % i == 0 && paydaMutlakDeger % i == 0){
                ebob = i;
            }
        }
        return ebob;
    }

    public RasyonelSayi topla(RasyonelSayi toplanacakSayi){
        int yeniPay = (this.pay * toplanacakSayi.payda) + (toplanacakSayi.pay * this.payda);
        int yeniPayda = this.payda * toplanacakSayi.payda;
        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    public RasyonelSayi cikar(RasyonelSayi cikarilacakSayi){
        int yeniPay = (this.pay * cikarilacakSayi.payda) - (cikarilacakSayi.pay * this.payda);
        int yeniPayda = (this.payda * cikarilacakSayi.payda);

        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    public RasyonelSayi carp(RasyonelSayi carpilacakSayi){
        int yeniPay = carpilacakSayi.pay * this.pay;
        int yeniPayda = carpilacakSayi.payda * this.payda;
        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    public RasyonelSayi bolum(RasyonelSayi bolunecekSayi){
        int yeniPay = (this.pay * bolunecekSayi.payda);
        int yeniPayda = (this.payda * bolunecekSayi.pay);
        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    @Override
    public String toString() {
        if (payda == 1){
            return pay + "";
        }else return pay + "/" + payda;
    }

    @Override
    public int compareTo(RasyonelSayi rasyonelSayi) {
        if (this.cikar(rasyonelSayi).pay > 0){
            return 1;
        }else if (this.cikar(rasyonelSayi).pay < 0){
            return -1;
        }else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RasyonelSayi)) return false;
        RasyonelSayi that = (RasyonelSayi) o;
        return pay == that.pay &&
                payda == that.payda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pay, payda);
    }
}
