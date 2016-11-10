package com.trnlp.cekirdek.heceleme;


public class Agac implements IAgac {

    public AgacDugumu agacOlustur() {

        return new AgacDugumu('\0', false);
    }

    public void ekle(AgacDugumu dugum, String kelime) {

        int offset = 97;
        int kelimeUzunlugu = kelime.length();
        char[] harfler = kelime.toCharArray();
        AgacDugumu mevcutDugum = dugum;

        for (int i = 0; i < kelimeUzunlugu; i++)
        {
            if (mevcutDugum.baglantilar[harfler[i]-offset] == null)
                mevcutDugum.baglantilar[harfler[i]-offset] = new AgacDugumu(harfler[i], (i == kelimeUzunlugu-1));
            mevcutDugum = mevcutDugum.baglantilar[harfler[i]-offset];
        }
    }

    public void yazdir(AgacDugumu dugum, int seviye, char[] dal) {

        if (dugum == null)
            return;

        for (int i = 0; i < dugum.baglantilar.length; i++)
        {
            dal[seviye] = dugum.harf;
            yazdir(dugum.baglantilar[i], seviye+1, dal);
        }

        if (dugum.kelimeSonumu)
        {
            for (int j = 1; j <= seviye; j++) {
                System.out.print(dal[j]);
            }

            System.out.println();
        }
    }

    public boolean ara(AgacDugumu dugum, String kelime) {

        char[] harfler = kelime.toCharArray();
        int kelimeUzunlugu = harfler.length;
        int offset = 97;
        AgacDugumu mevcutDugum = dugum;

        int i = 0;

        for (; i < kelimeUzunlugu; i++) {
            if (mevcutDugum == null) {
                return false;
            }

            mevcutDugum = mevcutDugum.baglantilar[harfler[i] - offset];
        }

        if (i == kelimeUzunlugu && mevcutDugum == null) {
            return false;
        }

        if (mevcutDugum != null && !mevcutDugum.kelimeSonumu){
            return false;
        }

        return true;
    }
}
