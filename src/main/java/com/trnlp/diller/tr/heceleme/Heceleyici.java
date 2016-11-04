package com.trnlp.diller.tr.heceleme;


import com.trnlp.cekirdek.heceleme.IHeceleyici;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heceleyici implements IHeceleyici {

    private static final String sesliHarfler[] = new String[] {"a", "e", "ı", "i", "o", "ö", "u", "ü"};

    public List<String> hecele(String kelime) {

        List<String> heceler = new ArrayList<String>();

        kelime = temizle(kelime);

        heceler.add(kelimeParcala(kelime));

        return heceler;
    }

    public String temizle(String kelime) {
        return kelime.replaceAll("[^A-Za-z0-9şığçüö\\s]", "");
    }

    public String kelimeParcala(String kelime) {
        int i;

        for(i = 0; i < kelime.length(); i++) {

            if (Arrays.asList(sesliHarfler).contains(String.valueOf(kelime.charAt(i)))) {

                try {
                    if (Arrays.asList(sesliHarfler).contains(String.valueOf(kelime.charAt(i+1)))) {
                        return kelime.substring(0, i+1) + "-" + kelimeParcala(kelime.substring(i+1, kelime.length()));
                    }
                    else if (Arrays.asList(sesliHarfler).contains(String.valueOf(kelime.charAt(i+2)))) {
                        return kelime.substring(0, i+1) + "-" + kelimeParcala(kelime.substring(i+1, kelime.length()));
                    }
                    else if (Arrays.asList(sesliHarfler).contains(String.valueOf(kelime.charAt(i+3)))) {
                        return kelime.substring(0, i+2) + "-" + kelimeParcala(kelime.substring(i+2, kelime.length()));
                    }
                    else if (kelime.substring(i+1, i+4).equalsIgnoreCase("str") ||
                            kelime.substring(i+1, i+4).equalsIgnoreCase("ktr") ||
                            kelime.substring(i+1, i+4).equalsIgnoreCase("ntr")) {

                        return kelime.substring(0, i+2) + "-" + kelimeParcala(kelime.substring(i+2, kelime.length()));
                    }
                    else {
                        return kelime.substring(0, i+3) + "-" + kelimeParcala(kelime.substring(i+3, kelime.length()));
                    }

                } catch (StringIndexOutOfBoundsException e) {
                    return kelime;
                }
            }
        }

        return kelime;
    }
}
