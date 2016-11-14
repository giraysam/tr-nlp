package com.trnlp.cekirdek.islemler;


import java.util.ArrayList;
import java.util.List;

public class Agac implements IAgac {

    public Dugum agacOlustur() {

        return new Dugum('\0', false);
    }

    public void ekle(Dugum dugum, String kelime) {
        int offset = 97;
        int kelimeUzunlugu = kelime.length();
        char harfler[] = kelime.toCharArray();
        Dugum mevcutDugum = dugum;
        int i = 0;

        for (; i < kelimeUzunlugu; i++) {
            if (mevcutDugum.altDugumler[harfler[i] - offset] == null) {
                mevcutDugum.altDugumler[harfler[i] - offset] = new Dugum(harfler[i], (i == kelimeUzunlugu - 1));
                // System.out.println(i + "-" + harfler[i]);

            }
            mevcutDugum = mevcutDugum.altDugumler[harfler[i] - offset];
        }
    }

    public List<String> ara(Dugum dugum, String kelime) {
        int offset = 97;
        int kelimeUzunlugu = kelime.length();
        int i = 0;
        Dugum mevcutDugum = dugum;
        char[] harfler = new char[kelimeUzunlugu];
        List<String> bulunanKelimeler = new ArrayList<String>();

        for(; i < kelimeUzunlugu; i++) {

            if (mevcutDugum.altDugumler[kelime.charAt(i) - offset] != null) {
                mevcutDugum = mevcutDugum.altDugumler[kelime.charAt(i) - offset];

                harfler[i] = mevcutDugum.harf;

                if (mevcutDugum.kelimeSonumu) {
                    System.out.println();
                    bulunanKelimeler.add(String.valueOf(harfler));
                }
            }
        }

        return bulunanKelimeler;
    }
}
