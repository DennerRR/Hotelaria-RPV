package com.rp4.hotelaria.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;



public class TodoUsuarioDTO {

    @ApiModelProperty(position = 0)
    private String nomeUsuario;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private String senha;
    @ApiModelProperty(position = 3)
    private String cpf;
    @ApiModelProperty(position = 4)
    private String telefone;
    @ApiModelProperty(position = 5)
    private String endereco;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}