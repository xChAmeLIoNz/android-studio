package it.corso.model;

import java.util.ArrayList;
import java.util.List;

public class Contatto {
    private int id;
     private String nome;
     private String cognome;
     private String telefono;

     private static List<Contatto> contatti;

    static{
         contatti = new ArrayList<>();
         contatti.add(new Contatto(1,"Mario","Rossi","333.1112225"));
         contatti.add(new Contatto(2,"Gianni","Verdi","389.5546789"));
         contatti.add(new Contatto(3,"Laura","Gialli","345.7896541"));
         contatti.add(new Contatto(4,"Sara","Bianchi","342.5431278"));
         contatti.add(new Contatto(5,"Paolo","Paolini","321.7864532"));
    }

    public Contatto(int id, String nome, String cognome, String telefono) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static List<Contatto> getContatti() {
        return contatti;
    }

    public static void setContatti(List<Contatto> contatti) {
        Contatto.contatti = contatti;
    }
}
