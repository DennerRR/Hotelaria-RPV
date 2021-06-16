package com.rp4.hotelaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;


    public Funcionario(String email, String nome, String senha, String cpf, String telefone, String cargo) {
        super(email, nome, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
