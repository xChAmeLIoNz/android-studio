package com.iseppe.model;

public class Utente {

    //attributi
    private String nome;
    private String cognome;
    private String genere;

    public Utente(String nome, String cognome, String genere) {
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
    }

    //rappresentazione testuale

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
