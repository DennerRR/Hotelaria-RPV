package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Servico;
import com.rp4.hotelaria.model.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServicoProducer {
    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingkeyServico}")
    String routingkey;

    public RabbitTemplate rabbitTemplate;


    @Autowired
    public ServicoProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(Servico servico){
        rabbitTemplate.convertAndSend(exchange, routingkey, servico);

    }
}
