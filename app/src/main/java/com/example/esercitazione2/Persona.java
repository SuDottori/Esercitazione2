package com.example.esercitazione2;

import java.io.Serializable;

public class Persona implements Serializable {




    public String nome, cognome, dataNascita, indirizzo;

    public Persona (){

        this.nome="";
        this.cognome="";
        this.dataNascita="";
        this.indirizzo="";

    }

    public Persona(String nome, String cognome, String dataNascita, String indirizzo){
        this.nome=nome;
        this.cognome=cognome;
        this.dataNascita=dataNascita;
        this.indirizzo=indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

}
