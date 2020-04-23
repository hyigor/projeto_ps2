package br.mack.ps2.entidades;

public class Empregado {
    private long id;
    private String nome;
    private String cargo;
    private long salario;

    public Empregado(){
        this.id = -1;
        this.nome = null;
        this.cargo = null;
        this.salario = 2000;
    }
    public Empregado(long id, String nome, String cargo, long salario){
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
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

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + this.id +
                ", Nome='" + this.nome + '\'' +
                ", Cargo='" + this.cargo + '\'' +
                ", Salário:R$" + this.salario +
                '}';
    }
}

