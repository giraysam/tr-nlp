package com.trnlp.cekirdek.islemler;


import java.util.List;

public interface IAgac {

    public Dugum agacOlustur();
    public void ekle(Dugum dugum, String kelime);
    public List<String> ara(Dugum dugum, String kelime);
}
