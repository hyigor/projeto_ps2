package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Aplicativo;

import java.util.List;

public interface AplicativoDAO {
    boolean create(Aplicativo aplicativo);
    List<Aplicativo> read();
    boolean update(Aplicativo aplicativo);
    boolean delete(Aplicativo aplicativo);


}
