package com.iseppe.app_07.model;

public class Indirizzo {

    //attributi di istanza
    private String via;
    private String provincia;

    //costruttore

    public Indirizzo(String via, String provincia) {
        this.via = via;
        this.provincia = provincia;
    }

    //getter e setter
    public String getVia() {
        return via;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    //rappresentazione testuale

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
