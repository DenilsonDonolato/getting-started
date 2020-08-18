package org.acme.getting.started.model;

public class User {

    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}