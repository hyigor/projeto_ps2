package br.mack.ps2;

import br.mack.ps2.entidades.Aplicativo;
import br.mack.ps2.entidades.ContaBancaria;
import br.mack.ps2.persistencia.AplicativoDAO;
import br.mack.ps2.persistencia.ContaBancariaDAO;
import br.mack.ps2.persistencia.EmpregadoDAO;

import java.util.Scanner;

public class InterfaceUsuarioConta {
    ContaBancariaDAO contaBancariaDAO;
    Scanner in;

    public InterfaceUsuarioConta(ContaBancariaDAO contaBancariaDAO){
        this.contaBancariaDAO = contaBancariaDAO;
            }

    public void iniciar () {
        imprimirMenu();
    }

    private void imprimirMenu(){
        int opc = 0;
        while(true) {
            System.out.println("\n============");
            System.out.println("====Menu====");
            System.out.println("============");
            System.out.println("\t1. Criar");
            System.out.println("\t2. Ler");
            System.out.println("\t3. Atualizar");
            System.out.println("\t4. Deletar");
            System.out.println("\t5. Sair");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.createConta();
                    break;
                case 2:
                    this.readConta();
                    break;
                case 3:
                    System.out.println("Não implementado");
                    break;
                case 4:
                    this.deleteConta();
                    break;
                case 5:
                    System.out.println("Tchau!");
                    return;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

            public void createConta(){
                ContaBancaria conta = new ContaBancaria();
                System.out.println("\n***************");
                System.out.println("*** Nova Conta Bancária ***");
                System.out.println("***********************");
                System.out.println("\nInforme o ID da conta: ");
                conta.setId(in.nextLong());
                in.nextLine();

                System.out.println("Informe o nome do títular: ");
                conta.setNome_do_titular(in.nextLine());

                System.out.println("Informe o saldo: ");
                conta.setSaldo(in.nextLong());

                System.out.println("Informe o número da agencia: ");
                conta.setNum_da_agencia(in.nextInt());

                if(contaBancariaDAO.create(conta)){
                    System.out.println("Conta adicionada ao Banco de Dados");
                }else{
                    System.out.println("Problema ao adicionar a conta");
                }



        }
    }


