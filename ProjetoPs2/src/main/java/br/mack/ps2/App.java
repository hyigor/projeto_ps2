package br.mack.ps2;

import br.mack.ps2.persistencia.AplicativoDAO;
import br.mack.ps2.persistencia.AplicativoDAOMySQL;

public class App {
    public static void main(String[] args) {
        AplicativoDAOMySQL dao = new AplicativoDAOMySQL();
        InterfaceUsuarioAplicativo aplicativo = new InterfaceUsuarioAplicativo(dao);
        aplicativo.iniciar();

    }

}
