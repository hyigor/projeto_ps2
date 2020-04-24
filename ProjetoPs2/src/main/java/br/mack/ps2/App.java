package br.mack.ps2;

import java.util.Scanner;

import br.mack.ps2.persistencia.*;

public class App {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int escolha;
        int escolha2;
        System.out.println("**** Menu ****");
        System.out.println("Deseja modificar algum banco de dados?");
        System.out.println("Digite 1 para sim\nDigite 2 para não");
        escolha = print.nextInt();
        if(escolha == 1){
            System.out.println("Qual banco você deseja alterar?\nLembre-se de sempre digitar o numero que está ao lado da opção desejada.");
            System.out.println("1. Aplicativo\n2. Conta Bancaria\n3. Empregado");
            escolha2 = print.nextInt();
            if(escolha2 == 1){
                AplicativoDAOMySQL dao = new AplicativoDAOMySQL();
                InterfaceUsuarioAplicativo aplicativo = new InterfaceUsuarioAplicativo(dao);
                aplicativo.iniciar();
            } else if(escolha2 == 2){
                ContaBancariaDAOMySQL contaDAO = new ContaBancariaDAOMySQL();
                InterfaceUsuarioConta conta = new InterfaceUsuarioConta(contaDAO);
                conta.iniciar();
            } else if(escolha2 == 3){
                //EmpregadoDAOMySQL empregadoDAO = new EmpregadoDAOMySQL();
                //InterfaceUsuarioEmpregado empregado = new InterfaceUsuarioEmpregado(empregadoDAO);
                //empregado.iniciar();
            } else{
                System.out.println("Você digitou algo errado!");
            }
        } else if(escolha == 2){
            System.out.println("Você saiu do programa!");
            System.out.println("Se quiser retornar ao programa, por favor de start novamente :) ");
            return;
        }





    }

}
