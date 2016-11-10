package com.trnlp;

import com.trnlp.cekirdek.heceleme.Agac;
import com.trnlp.cekirdek.heceleme.AgacDugumu;
import com.trnlp.cekirdek.heceleme.IHeceleyici;
import com.trnlp.diller.tr.heceleme.Heceleyici;

public class App {

    public static void main(String[] argv) {

        IHeceleyici heceleyici = new Heceleyici();

        System.out.println(heceleyici.hecele("kelimeler"));

        Agac agac = new Agac();
        AgacDugumu dugum = agac.agacOlustur();

        String[] kelimeler = {"ablak", "ablaka", "abone", "abiye"};

        int i = 0;

        for (; i < kelimeler.length; i++)
            agac.ekle(dugum, kelimeler[i]);

        char[] dal = new char[50];
        agac.yazdir(dugum, 0, dal);
    }
}
