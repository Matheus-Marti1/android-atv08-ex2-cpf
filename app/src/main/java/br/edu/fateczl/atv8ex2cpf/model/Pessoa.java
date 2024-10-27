/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv8ex2cpf.model;

public class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
