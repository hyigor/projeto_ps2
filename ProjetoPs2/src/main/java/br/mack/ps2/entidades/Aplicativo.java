package br.mack.ps2.entidades;

public class Aplicativo {

    private long id;
    private String nome;
    private String desenvolvedor;
    private long numero_de_downloads;

    public Aplicativo(){
        this.id = -1;
        this.nome = null;
        this.desenvolvedor = null;
        this.numero_de_downloads = 0;
    }
    public Aplicativo(long id , String nome, String desenvolvedor, long numero_de_downloads){
        this.id = id;
        this.nome = nome;
        this.desenvolvedor = desenvolvedor;
        this.numero_de_downloads = numero_de_downloads;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumero_de_downloads() {
        return numero_de_downloads;
    }

    public void setNumero_de_downloads(long numero_de_downloads) {
        this.numero_de_downloads = numero_de_downloads;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    @Override
    public String toString() {
        return "Aplicativo{" +
                "id=" + this.id +
                ", nome='" + this.nome + '\'' +
                ", desenvolvedor='" + this.desenvolvedor + '\'' +
                ", numero_de_downloads=" + this.numero_de_downloads +
                '}';
    }
}
