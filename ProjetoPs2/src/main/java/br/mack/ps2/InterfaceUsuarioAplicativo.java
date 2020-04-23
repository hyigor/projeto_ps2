package br.mack.ps2;
import br.mack.ps2.entidades.*;
import br.mack.ps2.persistencia.*;

import java.util.List;
import java.util.Scanner;


public class InterfaceUsuarioAplicativo {

    AplicativoDAO aplicativoDAO;
    ContaBancariaDAO contaBancariaDAO;
    EmpregadoDAO empregadoDAO;
    Scanner in;

    public InterfaceUsuarioAplicativo(AplicativoDAO aplicativoDAO, ContaBancariaDAO contaBancariaDAO, EmpregadoDAO empregadoDAO){
        this.aplicativoDAO = aplicativoDAO;
        this.contaBancariaDAO = contaBancariaDAO;
        this.empregadoDAO = empregadoDAO;
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

            switch (opc){
                case 1:
                        this.createAplicativo();
                    break;
                case 2:
                        this.readAplicativo();
                    break;
                case 3:
                    System.out.println("Não implementado");
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


            public void createAplicativo(){
                Aplicativo aplicativo = new Aplicativo();
            }



        }
    }

}
