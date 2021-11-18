package com.mageddo.kafka.spring;

public class Fruit {

    private String nome;

    public String getNome() {
        return nome;
    }

    public Fruit setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
