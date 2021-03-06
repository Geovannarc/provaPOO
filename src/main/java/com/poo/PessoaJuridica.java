package com.poo;

public class PessoaJuridica extends Cliente {
    
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString()+", pessoa jurídica";
    }

    public String getCNPJ(){
        return cnpj;
    }
    
}
