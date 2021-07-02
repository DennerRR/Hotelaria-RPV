package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CidadeProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingkeyCidade}")
    String routingkey;

    private RabbitTemplate rabbitTemplate;


    @Autowired
    public CidadeProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(Cidade cidade){
        rabbitTemplate.convertAndSend(exchange, routingkey, cidade);

    }
}
