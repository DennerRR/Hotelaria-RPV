package com.rp4.turismo.ConsumerMensagem;


import com.rp4.turismo.model.Usuario;
import com.rp4.turismo.repository.UsuarioRepository;
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


    @RabbitListener(queues = {"${crud.rabbitmq.queueUsuario}"})
    public void consumer(@Payload Usuario usuario) {
        usuarioRepository.save(usuario);


    }
}
