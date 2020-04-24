package br.mack.ps2;


import br.mack.ps2.entidades.Empregado;
import br.mack.ps2.persistencia.EmpregadoDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioEmpregado {



    EmpregadoDAO empregadoDAO;
    Scanner in;

    public InterfaceUsuarioEmpregado(EmpregadoDAO empregadoDAO){
        this.empregadoDAO = empregadoDAO;
        this.in = new Scanner(System.in);
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
                    this.createEmpregado();
                    break;
                case 2:
                    this.readEmpregado();
                    break;
                case 3:
                    this.updateEmpregado();
                    break;
                case 4:
                    this.deleteEmpregado();
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

    public void createEmpregado(){
        Empregado empregado = new Empregado();
        System.out.println("\n***************");
        System.out.println("*** Novo Empregado ***");
        System.out.println("***********************");

        System.out.println("Informe o nome do Empregado: ");
        empregado.setNome(in.nextLine());

        System.out.println("Informe o cargo: ");
        empregado.setCargo(in.nextLine());

        System.out.println("Informe o salario: ");
        empregado.setSalario(in.nextLong());

        if(empregadoDAO.creat(empregado)){
            System.out.println("Empregado adicionado ao Banco de Dados");
        }else{
            System.out.println("Problema ao adicionar o Empregado");
        }



    }

    public void readEmpregado(){
        List<Empregado> empregados= empregadoDAO.read();

        System.out.println("\n*************************************************");
        System.out.println("Lista de Empregado cadastrados no Banco de Dados");
        System.out.println("\n***************************************************");

        for (Empregado empregado: empregados){
            System.out.println( "Id do empregado: " + empregado.getId());
            System.out.println("Nome do empregado: " +  empregado.getNome());
            System.out.println("Tipo de cargo: " + empregado.getCargo());
            System.out.println("Quantidade de salario: " + empregado.getSalario() + "\n");


        }
    }
    public void updateEmpregado(){
        Empregado empregado=new Empregado();

        System.out.println("\n************************");
        System.out.println("Atualizar um Empregado");
        System.out.println("\n*************************");

        System.out.println("Insira o ID do Empregado");
        empregado.setId(in.nextLong());
        in.nextLine();


        System.out.println("Altere o nome do Empregado");
        empregado.setNome(in.nextLine());

        System.out.println("Altere o cargo");
        empregado.setCargo(in.nextLine());

        System.out.println("altere o salario");
        empregado.setSalario((in.nextLong()));

        if (empregadoDAO.update(empregado)){
            System.out.println("Empregado atualizado no Banco de Dados");
        }else{
            System.out.println("Problema ao atualizar o Empregado no Banco de Dados");
        }

    }
    public void deleteEmpregado(){
        List<Empregado> empregados = empregadoDAO.read();

        while(true){
            System.out.println("\n********************************");
            System.out.println("Lista dos Empregado registradas");
            System.out.println("\n**********************************");
            int a=0;
            for(Empregado empregado:empregados){
                System.out.println(a + ". Id do empregado: " + empregado.getId());
                System.out.println("  Nome do empregado: " +  empregado.getNome());
                System.out.println("  Tipo de cargo: " + empregado.getCargo());
                System.out.println("  Quantidade de salario: " + empregado.getSalario() + "\n");
                a++;
            }
            System.out.println(a+ " - Cancelar operação");

            System.out.println("Qual Empregado deseja remover?");
            int resposta = in.nextInt();
            in.nextLine();

            if (resposta==a){
                break;
            } else if(resposta > empregados.size() || resposta < 0){
                System.out.println("Está opção não é valida");

            } else if(empregadoDAO.delete(empregados.get(resposta))){
                System.out.println("Conta: " + empregados.get(resposta).getNome() + " removido com sucesso");
            } else{
                System.out.println("Ops: Falha ao tentar remover");
            }

            break;
        }
    }
}