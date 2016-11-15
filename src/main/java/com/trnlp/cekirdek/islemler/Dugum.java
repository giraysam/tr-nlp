package com.trnlp.cekirdek.islemler;


import java.util.Arrays;

public class Dugum {

    char harf;
    Dugum[] altDugumler;
    boolean kelimeSonumu;

    Dugum(char harf, boolean kelimeSonumu) {

        this.harf = harf;
        this.altDugumler = new Dugum[1];
        this.kelimeSonumu = kelimeSonumu;
    }

    public void dugumGenislet(int genislik) {
        this.altDugumler = Arrays.copyOf(this.altDugumler, this.altDugumler.length + genislik);
    }
}
