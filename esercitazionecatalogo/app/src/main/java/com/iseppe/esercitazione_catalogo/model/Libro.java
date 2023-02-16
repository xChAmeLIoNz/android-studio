package com.iseppe.esercitazione_catalogo.model;

import com.iseppe.esercitazione_catalogo.R;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    //attributi

    private int immagine;
    private String genere;
    private String titolo;
    private String autore;
    private String anno;
    private String prezzo;

    private static List<Libro> libri;

    static {

        libri = new ArrayList<>();
        libri.add(new Libro(R.drawable.libro_1, "Narrativa Straniera", "La città di vapore", "Carlos Zafon", "2019", "17,57"));
        libri.add(new Libro(R.drawable.libro_2, "Thriller", "Per niente al mondo", "Ken Follet", "2021", "25,65"));
        libri.add(new Libro(R.drawable.libro_3, "Thriller", "Later", "Stephen King", "2020", "18,90"));
        libri.add(new Libro(R.drawable.libro_4, "Thriller", "Una sirena a settembre", "Maurizio De Giovanni", "2021", "17,57"));
        libri.add(new Libro(R.drawable.libro_5, "Narrativa Italiana", "Alabama", "Alessandro Barbero", "2020", "14,25"));
    }

    //constructor
    public Libro(int immagine, String genere, String titolo, String autore, String anno, String prezzo) {
        this.immagine = immagine;
        this.genere = genere;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    //getter
    public int getImmagine() {
        return immagine;
    }

    public String getGenere() {
        return genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getAnno() {
        return anno;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public static List<Libro> getLibri() {
        return libri;
    }

    //setter

    public void setImmagine(int immagine) {
        this.immagine = immagine;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public static void setLibri(List<Libro> libri) {
        Libro.libri = libri;
    }
}
