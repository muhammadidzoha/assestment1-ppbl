package id.ac.id.telkomuniversity.tass.a1muhammadidzohannaqib;

import com.google.gson.annotations.Expose;

public class Album {
    private int id;
    private String artis;
    private String judul;
    private int tahun;
    private String label;
    private int harga;
    private String cover;

    public Album(int id, String artis, String judul, int tahun, String label, int harga, String cover) {
        this.id = id;
        this.artis = artis;
        this.judul = judul;
        this.tahun = tahun;
        this.label = label;
        this.harga = harga;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public String getArtis() {
        return artis;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahun() {
        return tahun;
    }

    public String getLabel() {
        return label;
    }

    public int getHarga() {
        return harga;
    }

    public String getCover() {
        return cover;
    }
}
