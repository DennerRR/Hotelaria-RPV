package com.rp4.hotelaria.consumer;

import com.rp4.hotelaria.dto.TodoUsuarioDTO;
import com.rp4.hotelaria.model.Cliente;
import com.rp4.hotelaria.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConsumer {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioConsumer(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RabbitListener(queues = "${crud.rabbitmq.signupQueue}")
    public void receive(@Payload TodoUsuarioDTO user) {
        Cliente cli = new Cliente();
        cli.setEndereco(user.getEndereco());
        cli.setCpf(user.getCpf());
        cli.setNome(user.getNomeUsuario());
        cli.setEmail(user.getEmail());
        cli.setTelefone(user.getTelefone());
        cli.setSenha(user.getSenha());
        usuarioRepository.save(cli);
    }

}