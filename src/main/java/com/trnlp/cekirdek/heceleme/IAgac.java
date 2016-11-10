package com.trnlp.cekirdek.heceleme;

public interface IAgac {

    public AgacDugumu agacOlustur();
    public void ekle(AgacDugumu dugum, String kelime);
    public boolean ara(AgacDugumu dugum, String kelime);
}