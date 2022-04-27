package com.poo;

public abstract class Cliente {
    
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: "+nome;
    }

}
