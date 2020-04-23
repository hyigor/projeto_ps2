package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.ContaBancaria;

import java.util.List;

public interface ContaBancariaDAO {
    boolean create(ContaBancaria contabancaria );
    List<ContaBancaria> read();
    boolean updade (ContaBancaria contabancaria);
    boolean delete (ContaBancaria contabancaria);
}
