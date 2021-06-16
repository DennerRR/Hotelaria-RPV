package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Produto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Value("${crud.rabbitmq.exchange}")
     String exchange;

    @Value("${crud.rabbitmq.routingkeyProduto}")
     String routingkey;

    public RabbitTemplate rabbitTemplate;

    @Autowired
    public ProdutoProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(Produto produto){
        rabbitTemplate.convertAndSend(exchange, routingkey, produto);
    }
}
