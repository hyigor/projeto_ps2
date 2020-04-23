package br.mack.ps2.entidades;

public class ContaBancaria {
    private long id;
    private String nome_do_titular;
    private long saldo;
    private int num_da_agencia;

    public ContaBancaria(){
        this.id = -1;
        this.nome_do_titular = null;
        this.saldo = 0;
        this.num_da_agencia = 0;
    }
    public ContaBancaria(long id, String nome_do_titular, long saldo, int num_da_agencia){
        this.id = id;
        this.nome_do_titular = nome_do_titular;
        this.saldo = saldo;
        this.num_da_agencia = num_da_agencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_do_titular() {
        return nome_do_titular;
    }

    public void setNome_do_titular(String nome_do_titular) {
        this.nome_do_titular = nome_do_titular;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public int getNum_da_agencia() {
        return num_da_agencia;
    }

    public void setNum_da_agencia(int num_da_agencia) {
        this.num_da_agencia = num_da_agencia;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "id=" + this.id +
                ", Nome_do_titular='" + this.nome_do_titular + '\'' +
                ", Saldo='" + this.saldo + '\'' +
                ", Num_da_agencia:R$" + this.num_da_agencia +
                '}';
    }

    public void add(ContaBancaria contas) {
    }
}


