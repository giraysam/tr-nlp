package com.trnlp.cekirdek.islemler;


public class Dugum {

    char harf;
    Dugum[] altDugumler;
    boolean kelimeSonumu;

    Dugum(char harf, boolean kelimeSonumu) {

        this.harf = harf;
        this.altDugumler = new Dugum[26];
        this.kelimeSonumu = kelimeSonumu;
    }
}
