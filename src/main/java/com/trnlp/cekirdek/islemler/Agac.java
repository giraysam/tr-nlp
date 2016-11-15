package com.trnlp.cekirdek.islemler;


import java.util.ArrayList;
import java.util.List;

public class Agac implements IAgac {

    private static final char L_c = '\u00e7'; // ç
    private static final char L_g = '\u011f'; // ğ
    private static final char L_i = '\u0131'; // ı
    private static final char L_o = '\u00f6'; // ö
    private static final char L_s = '\u015f'; // ş
    private static final char L_u = '\u00fc'; // ü

    public Dugum agacOlustur() {

        return new Dugum('\0', false);
    }

    public void ekle(Dugum dugum, String kelime) {
        int offset = 97;
        int kelimeUzunlugu = kelime.length();
        char harfler[] = kelime.toLowerCase().toCharArray();
        Dugum mevcutDugum = dugum;
        int i = 0;

        for (; i < kelimeUzunlugu; i++) {

            if (mevcutDugum.altDugumler.length <= (harfler[i] - offset)) {
                mevcutDugum.dugumGenislet((harfler[i] - offset));
            }

            if (mevcutDugum.altDugumler[harfler[i] - offset] == null) {
                mevcutDugum.altDugumler[harfler[i] - offset] = new Dugum(harfler[i], (i == kelimeUzunlugu - 1));
                // System.out.println(i + "-" + harfler[i]);
            }

            mevcutDugum = mevcutDugum.altDugumler[harfler[i] - offset];

            if (!mevcutDugum.kelimeSonumu) {
                mevcutDugum.kelimeSonumu = (i == kelimeUzunlugu - 1);
            }
        }
    }

    public List<String> ara(Dugum dugum, String kelime) {
        kelime = kelime.toLowerCase();
        int offset = 97;
        int kelimeUzunlugu = kelime.length();
        int i = 0;
        Dugum mevcutDugum = dugum;
        StringBuilder harfler = new StringBuilder();
        List<String> bulunanKelimeler = new ArrayList<String>();
        int asciiNum;

        if (dugum == null) {
            return bulunanKelimeler;
        }

        for(; i < kelimeUzunlugu; i++) {

            asciiNum = kelime.codePointAt(i);

            if (mevcutDugum.altDugumler.length <= (asciiNum - offset)) {
                mevcutDugum.dugumGenislet((asciiNum - offset));
            }

            if (mevcutDugum.altDugumler[asciiNum - offset] == null) {
                break;
            }

            if (mevcutDugum.altDugumler[asciiNum - offset].harf == asciiNum) {
                mevcutDugum = mevcutDugum.altDugumler[asciiNum - offset];

                harfler.append(mevcutDugum.harf);

                if (mevcutDugum.kelimeSonumu) {
                    bulunanKelimeler.add(harfler.toString());
                }
            }
        }

        return bulunanKelimeler;
    }
}
