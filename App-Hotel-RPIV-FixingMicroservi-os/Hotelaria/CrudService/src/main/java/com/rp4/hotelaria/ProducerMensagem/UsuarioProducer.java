package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Quarto;
import com.rp4.hotelaria.model.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {
    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingkeyUsuario}")
    String routingkey;

    public RabbitTemplate rabbitTemplate;


    @Autowired
    public UsuarioProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(Usuario usuario){
        rabbitTemplate.convertAndSend(exchange, routingkey, usuario);

    }
}
