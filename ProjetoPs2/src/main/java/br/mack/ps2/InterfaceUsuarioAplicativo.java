package br.mack.ps2;
import br.mack.ps2.entidades.*;
import br.mack.ps2.persistencia.*;

import java.util.List;
import java.util.Scanner;


public class InterfaceUsuarioAplicativo {

    AplicativoDAO aplicativoDAO;
    Scanner in;

    public InterfaceUsuarioAplicativo(AplicativoDAO aplicativoDAO){
        this.aplicativoDAO = aplicativoDAO;
        this.in = new Scanner(System.in);
    }

    public void iniciar () {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        while (true) {
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
                    this.createAplicativo();
                    break;
                case 2:
                    this.readAplicativo();
                    break;
                case 3:
                    this.updateAplicativo();
                    break;
                case 4:
                    this.deleteAplicativo();
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

            private void createAplicativo (){
                Aplicativo aplicativo = new Aplicativo();

                System.out.println("\n***********************");
                System.out.println("*** Novo Aplicativo ***");
                System.out.println("***********************");
                System.out.println("\nInforme o nome do aplicativo: ");
                aplicativo.setNome(in.nextLine());

                System.out.println("Informe o nick do desenvolvedor: ");
                aplicativo.setDesenvolvedor(in.nextLine());

                System.out.println("Informe o numero de downloads: ");
                aplicativo.setNumero_de_downloads(in.nextLong());

                if(aplicativoDAO.create(aplicativo)){
                    System.out.println("Aplicativo adicionado ao banco de Dados");
                } else {
                    System.out.println("Ops: problema ao adicionar aplicativo");
                }
            }

            private void readAplicativo(){
                List <Aplicativo> aplicativos = aplicativoDAO.read();

                System.out.println("\n*******************************************");
                System.out.println("**** Lista dos Aplicativos Cadastrados ****");
                System.out.println("********************************************");
                for(Aplicativo aplicativo : aplicativos) {
                    System.out.println("Id do aplicativo: " + aplicativo.getId());
                    System.out.println("Nome do aplicativo: " +  aplicativo.getNome());
                    System.out.println("Nome do desenvolvedor: " + aplicativo.getDesenvolvedor());
                    System.out.println("Numero de downloads: " + aplicativo.getNumero_de_downloads() + "\n");
                }
        }

            private void updateAplicativo(){
                Aplicativo aplicativo = new Aplicativo();

                System.out.println("*** Atualizar um Aplicativo ***");
                System.out.println("Insira o ID do aplicativo que deseja modificar: ");
                aplicativo.setId(in.nextLong());
                in.nextLine();

                System.out.println("Altere o nome do aplicativo: ");
                aplicativo.setNome(in.nextLine());

                System.out.println("Altere do nome do desenvolvedor: ");
                aplicativo.setDesenvolvedor(in.nextLine());

                System.out.println("Altere o numero de downloads: ");
                aplicativo.setNumero_de_downloads(in.nextLong());

                if(aplicativoDAO.update(aplicativo)){
                    System.out.println("Aplicativo atualizado no Banco de Dados");
                } else{
                    System.out.println("Ops: problema ao adicionar aplicativo");
                }
    }
            private void deleteAplicativo(){
                List <Aplicativo> aplicativos = aplicativoDAO.read();


                while(true){
                    System.out.println("\n******************************************");
                    System.out.println("*** Lista dos aplicativos cadastrados ***");
                    System.out.println("******************************************");

                    System.out.println(aplicativos);

                    int a = 0;
                    for(Aplicativo aplicativo : aplicativos){
                        System.out.println(a + ". Id do aplicativo: " + aplicativo.getId());
                        System.out.println("  Nome do aplicativo: " +  aplicativo.getNome());
                        System.out.println("  Nome do desenvolvedor: " + aplicativo.getDesenvolvedor());
                        System.out.println("  Numero de downloads: " + aplicativo.getNumero_de_downloads() + "\n");
                        a++;

                    }
                    System.out.println(a + ". Cancelar a operação");

                    System.out.println("Qual Aplicativo deseja remover?\n");
                    int resposta = in.nextInt();
                    in.nextLine();

                    if(resposta == a){
                        break;
                    } else if(resposta > aplicativos.size() || resposta < 0){
                        System.out.println("Está opção não é valida");

                    } else if(aplicativoDAO.delete(aplicativos.get(resposta))){
                        System.out.println("Aplicativo: "+ aplicativos.get(resposta).getNome() + " removido com sucesso");
                    }
                else{
                        System.out.println("Ops: Falha ao tentar remover");
                }
                    break;
                }

            }

}


