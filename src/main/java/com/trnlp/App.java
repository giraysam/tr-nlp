package com.trnlp;

import com.trnlp.cekirdek.islemler.Agac;
import com.trnlp.cekirdek.islemler.Dugum;
import com.trnlp.cekirdek.heceleme.IHeceleyici;
import com.trnlp.diller.tr.heceleme.Heceleyici;

import java.util.List;

public class App {

    public static void main(String[] argv) {

        IHeceleyici heceleyici = new Heceleyici();

        System.out.println(heceleyici.hecele("kelimeler"));

        Agac agac = new Agac();
        Dugum kok = agac.agacOlustur();

        String[] kelimeler = {"bal", "balon", "balta", "balkon", "balerin", "ag", "agac"};

        int i = 0;

        for (String kelime: kelimeler) {
            agac.ekle(kok, kelime);
        }

        List<String> bulunanKelimeler =  agac.ara(kok, "agaclik");

        // System.out.println(bulunanKelimeler);

        for (String kelime: bulunanKelimeler) {
            System.out.println(kelime);
        }

    }
}
