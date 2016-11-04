package com.trnlp;

import com.trnlp.cekirdek.heceleme.IHeceleyici;
import com.trnlp.diller.tr.heceleme.Heceleyici;

public class App {

    public static void main(String[] argv) {

        IHeceleyici heceleyici = new Heceleyici();

        System.out.println(heceleyici.hecele("kelimeler"));
    }
}
