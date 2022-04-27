package com.poo;

import java.util.List;

import javax.swing.JOptionPane;

public class Main 
{
    public static void main( String[] args ){

        Integer opcao;
        List<Reserva> reservas;
        opcao = menu();
        
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