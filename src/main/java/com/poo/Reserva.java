package com.poo;

public class Reserva implements Pagamento{
    
    private Cliente cliente;
    private boolean pagamentoAVista;

    public Reserva(Cliente cliente, boolean pagamentoAVista){
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    @Override
    public String toString() {
        return "{cliente: "+this.cliente+", pagamentoAVista: "+this.pagamentoAVista+"}";
    }

    @Override
    public Double calcularPagamento() {
        return pagamentoAVista ? 0.9*3200.00 : 3200.00;
    }

    public String getCliente() {
        return cliente.getClass().getName().compareTo("PessoaFisica") == 0 ? "Pessoa Física" : "Pessoa Jurídica";
    }
}
