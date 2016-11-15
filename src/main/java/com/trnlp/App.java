package com.trnlp;

import com.trnlp.cekirdek.islemler.Agac;
import com.trnlp.cekirdek.islemler.Dugum;
import com.trnlp.cekirdek.heceleme.IHeceleyici;
import com.trnlp.diller.tr.heceleme.Heceleyici;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class App {

    private static final long MEGABYTE = 1024L * 1024L;
    private static final long KILOBYTE = 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
    public static long bytesToKilobytes(long bytes) {
        return bytes / KILOBYTE;
    }

    public static void main(String[] argv) {

        long startTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();

        // IHeceleyici heceleyici = new Heceleyici();

        // System.out.println(heceleyici.hecele("kelimeler"));

        Agac agac = new Agac();
        Dugum kok = agac.agacOlustur();

        String[] kelimeler = {"balon", "balta", "balkon", "bal", "balerin", "balık", "ağ", "ağaç", "baklava", "kaşık",
        "el", "elma", "elmas"};

        for (String kelime: kelimeler) {
            agac.ekle(kok, kelime);
        }

        List<String> bulunanKelimeler =  agac.ara(kok, "elmaslar");

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

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        runtime.gc();

        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is kilobytes: " + bytesToKilobytes(memory));
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));

        NumberFormat formatter = new DecimalFormat("#0.000");
        System.out.print("Execution time is " + formatter.format(totalTime / 1000d) + " seconds");

    }
}
