package com.rp4.evolucaodb.ProducerMensagem;

import com.rp4.evolucaodb.model_new.CidadeNew;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CidadeNewProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingkeyCidade}")
    String routingkey;

    private RabbitTemplate rabbitTemplate;


    @Autowired
    public CidadeNewProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(CidadeNew cidadeNew){
        rabbitTemplate.convertAndSend(exchange, routingkey, cidadeNew);

    }
}
