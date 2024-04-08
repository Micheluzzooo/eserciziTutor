package com.example.demo;

import java.time.OffsetDateTime;

public class User {

    private String nome;
    private String provincia;
    private String saluto;
    private OffsetDateTime date;

    public User(String nome, String provincia, String saluto, OffsetDateTime date) {
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = saluto;
        this.date = date;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(String saluto) {
        this.saluto = saluto;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                ", saluto='" + saluto + '\'' +
                ", date=" + date +
                '}';
    }
}
