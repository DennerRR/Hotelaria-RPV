package com.rp5.authentication;

import com.rp5.authentication.Service.UsuarioService;
import com.rp5.authentication.model.Cargo;
import com.rp5.authentication.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationApplication implements CommandLineRunner {

    @Autowired
    UsuarioService userService;

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        Usuario admin = new Usuario();
        admin.setNomeUsuario("admin");
        admin.setSenha("admin");
        admin.setEmail("admin@email.com");
        admin.setCargos(new ArrayList<Cargo>(Arrays.asList(Cargo.CARGO_ADM)));

        userService.signup(admin);

        Usuario client = new Usuario();
        client.setNomeUsuario("client");
        client.setSenha("client");
        client.setEmail("client@email.com");
        client.setCargos(new ArrayList<Cargo>(Arrays.asList(Cargo.CARGO_CLIENTE)));

        userService.signup(client);
    }

}

