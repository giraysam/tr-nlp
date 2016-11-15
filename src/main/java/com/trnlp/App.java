package com.trnlp;

import com.trnlp.cekirdek.islemler.Agac;
import com.trnlp.cekirdek.islemler.Dugum;
import com.trnlp.cekirdek.heceleme.IHeceleyici;
import com.trnlp.diller.tr.heceleme.Heceleyici;

import java.util.List;

public class App {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] argv) {

        // IHeceleyici heceleyici = new Heceleyici();

        // System.out.println(heceleyici.hecele("kelimeler"));

        Agac agac = new Agac();
        Dugum kok = agac.agacOlustur();

        String[] kelimeler = {"balon", "balta", "balkon", "bal", "balerin", "balık", "ağ", "ağaç", "baklava", "kaşık"};

        for (String kelime: kelimeler) {
            agac.ekle(kok, kelime);
        }

        List<String> bulunanKelimeler =  agac.ara(kok, "balıkçılar");

        if (bulunanKelimeler.size() > 1) {
            System.out.println("Bulunan Kökler:");
            for (String kelime : bulunanKelimeler) {
                System.out.println(kelime);
            }
        }
        else if (bulunanKelimeler.size() == 1) {
            System.out.println("Kök Bulundu:");
            System.out.println(bulunanKelimeler.get(0));
        }
        else {
            System.out.println("Kök Bulunamadı:");
        }

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));

    }
}
