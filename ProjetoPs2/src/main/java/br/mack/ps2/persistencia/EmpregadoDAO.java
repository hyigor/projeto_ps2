package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Empregado;

import java.util.List;

public interface EmpregadoDAO {
    boolean creat (Empregado empregado);
    List <Empregado> read ();
    boolean update (Empregado empregado);
    boolean delete (Empregado empregado);

}
