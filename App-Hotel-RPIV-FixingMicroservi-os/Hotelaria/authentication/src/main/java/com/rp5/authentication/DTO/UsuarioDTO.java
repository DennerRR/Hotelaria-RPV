package com.rp5.authentication.DTO;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.rp5.authentication.model.Cargo;

public class UsuarioDTO {

    @ApiModelProperty(position = 0)
    private String nomeUsuario;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private String senha;
    @ApiModelProperty(position = 3)
    List<Cargo> cargos;

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

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
