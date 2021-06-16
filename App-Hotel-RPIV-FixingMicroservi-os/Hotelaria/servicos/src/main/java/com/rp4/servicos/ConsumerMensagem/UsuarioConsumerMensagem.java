package com.rp4.servicos.ConsumerMensagem;

import com.rp4.servicos.model.Usuario;
import com.rp4.servicos.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConsumerMensagem {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioConsumerMensagem(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @RabbitListener(queues = {"${crud.rabbitmq.queueUsuario}"})
    public void consumer(@Payload Usuario usuario) {
        usuarioRepository.save(usuario);


    }
}
