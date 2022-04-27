package com.poo;

import java.io.Console;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main 
{
    static List<Reserva> reservas = new ArrayList<>(); 
    static List<Reserva> listaDeEspera= new ArrayList<>();
    public static void main( String[] args ){

        Integer opcao;
        opcao = menu();
        
        while(opcao<=6 && opcao>=1){
            switch(opcao){
            case 1:
            reservarMesa();
            opcao = menu();
            break;
            case 2:
            pesquisarReserva();
            opcao = menu();
            break;
            }
        }
        
    }

    private static void pesquisarReserva() {
        String codigo = JOptionPane.showInputDialog("Informe o CPF ou CNPJ: " );
        String totalReservas = reservas.toString();
        boolean temReserva = totalReservas.contains(codigo);
        if(temReserva){
            JOptionPane.showMessageDialog(null,"Você tem reserva.");
        }else{
            JOptionPane.showMessageDialog(null,"Você não tem reserva.");
        }
    }

    private static void reservarMesa() {

        Integer tipoCliente = tipoCliente();
        boolean pagamentoAVista = pagamentoAVista();
        if(reservas.size()>5){
            JOptionPane.showMessageDialog(null,"Reservas esgotadas. Você entrará na lista de espera.");
        }
        if(tipoCliente == 1){   
            System.out.println(reservas.size());
            String nome = JOptionPane.showInputDialog("Informe o nome: " );
            String cnpj = JOptionPane.showInputDialog("Informe o CNPJ: " );
            Cliente cliente = new PessoaJuridica(nome, cnpj);
            if(reservas.size()<6){
                reservas.add(new Reserva(cliente, pagamentoAVista));
            }else{
                listaDeEspera.add(new Reserva(cliente, pagamentoAVista));
                System.out.println("lista de espera "+listaDeEspera.size());
            }
        }else{
            String nome = JOptionPane.showInputDialog("Informe o nome: " );
            String cpf = JOptionPane.showInputDialog("Informe o CPF: " );
            Cliente cliente = new PessoaFisica(nome, cpf);
            if(reservas.size()<6){
                reservas.add(new Reserva(cliente, pagamentoAVista));
            }else{
                listaDeEspera.add(new Reserva(cliente, pagamentoAVista));
            }
        }
    }

    private static boolean pagamentoAVista() {
        boolean pagamentoAVista = false;
        Integer tipoPagamento = null;
        while(tipoPagamento == null || tipoPagamento < 1 || tipoPagamento > 2){
            try{
                tipoPagamento = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para pagamento a vista e 2 para pagamento parcelado." ));   
                if(tipoPagamento.equals("1")){
                    pagamentoAVista = true;
                }else{
                    pagamentoAVista = false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Por favor, digite um número.");
            } 
        }
        return pagamentoAVista; 
    }

    public static Integer tipoCliente(){
        Integer tipoCliente = null;
        
        while(tipoCliente == null || tipoCliente < 1 || tipoCliente > 2){
           try {
                tipoCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para pessoa jurídica e 2 para pessoa física." ));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Por favor, digite um número.");
            } 
        }
        return tipoCliente;
    }

    public static Integer menu(){
        String menu = "1. Reservar mesa \n 2. Pesquisar reserva \n 3. Imprimir reservas \n 4. Imprimir lista de espera \n 5. Cancelar reserva \n 6. Finalizar";
        Integer opcao = null;
        while(opcao == null || opcao > 6 || opcao < 1){
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Por favor, digite um número.");
            }
        }
        return opcao;
    }
}
