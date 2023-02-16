package com.iseppe.app08.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Promemoria {

    //attributi
    private int id;
    private Date data;
    private String oggetto;

    //attributo di collezionamento
    private static List<Promemoria> elenco = new ArrayList<>();

    //costruttore

    public Promemoria(int id, Date data, String oggetto) {
        this.id = id;
        this.data = data;
        this.oggetto = oggetto;
    }

    //costr solo data e oggetto

    public Promemoria(Date data, String oggetto) {
        this.data = data;
        this.oggetto = oggetto;
    }

    //costr vuoto

    public Promemoria() {
    }

    //getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public static List<Promemoria> getElenco() {
        return elenco;
    }

    public static void setElenco(List<Promemoria> elenco) {
        Promemoria.elenco = elenco;
    }
}
