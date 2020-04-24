package br.mack.ps2;

import br.mack.ps2.entidades.Aplicativo;
import br.mack.ps2.entidades.ContaBancaria;
import br.mack.ps2.persistencia.AplicativoDAO;
import br.mack.ps2.persistencia.ContaBancariaDAO;
import br.mack.ps2.persistencia.EmpregadoDAO;

import java.util.List;
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
                    this.updateConta();
                    break;
                case 4:
                    this.deleteConta();
                    break;
                case 5:
                    System.out.println("Saiu!");
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

        public void readConta(){
            List<ContaBancaria> contas= contaBancariaDAO.read();

            System.out.println("\n**********************");
            System.out.println("Lista de contas cadastras no Banco de Dados");
            System.out.println("\n****************");
            for (ContaBancaria contabancaria: contas){
                System.out.println(contabancaria);

            }
        }
        public void updateConta(){
        ContaBancaria conta=new ContaBancaria();

            System.out.println("Atualizar uma Conta");

            System.out.println("Insira o ID da conta bancaria");
            conta.setId(in.nextLong());

            System.out.println("Altere o nome da conta");
            conta.setNome_do_titular(in.nextLine());

            System.out.println("Altere o saldo");
            conta.setSaldo(in.nextLong());

            System.out.println("altere o numero da agencia");
            conta.setNum_da_agencia((in.nextInt()));

            if (contaBancariaDAO.updade(conta)){
                System.out.println("Conta Atualizada no Banco de Dados");
            }else{
                System.out.println("Problema ao atualizar a conta no Banco de Dados");
            }

            }
            public void deleteConta(){
               List<ContaBancaria> contas = contaBancariaDAO.read();

               while(true){
                   System.out.println("Lista das Contas registradas");
               int a=0;
                   for(ContaBancaria contabancaria:contas){
                       System.out.println(a + "-" + contabancaria);
                       a++;
                   }
                   System.out.println(a+ " Cancelar operação");

                   System.out.println("Qual conta deseja remover?");
                   int resposta = in.nextInt();
                   in.nextLine();

                   if (resposta==a){
                       break;
                   } else if(resposta >= contas.size() || resposta < 0){
                       System.out.println("Está opção não é valida");
                   } else if(contaBancariaDAO.delete(contas.get(resposta))){
                       System.out.println("Ops: Falha ao tentar remover");
                   } else{
                       System.out.println("Aplicativo: " + contas.get(resposta).getNome_do_titular() + " removido com sucesso");
                   }

                   break;
               } for (ContaBancaria contabancaria : contas){
                    System.out.println(contabancaria);
                }
               }
            }




