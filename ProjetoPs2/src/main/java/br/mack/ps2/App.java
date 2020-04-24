package br.mack.ps2;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();
            try {
                menu.menu();
            } catch (InputMismatchException e) {
                System.out.println("Você digitou algo errado...");
                System.out.println("Por favor digite apenas os numeros indicados!\n");
                System.out.println("Reinicie o programa para tentar novamente :) ");
            }


    }

    }

