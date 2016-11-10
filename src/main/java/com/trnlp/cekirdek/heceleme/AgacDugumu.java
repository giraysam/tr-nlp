package com.trnlp.cekirdek.heceleme;


public class AgacDugumu {

    char harf;
    AgacDugumu[] baglantilar;
    boolean kelimeSonumu;

    AgacDugumu(char harf, boolean kelimeSonumu) {

        this.harf = harf;
        baglantilar = new AgacDugumu[26];
        this.kelimeSonumu = kelimeSonumu;
    }
}
