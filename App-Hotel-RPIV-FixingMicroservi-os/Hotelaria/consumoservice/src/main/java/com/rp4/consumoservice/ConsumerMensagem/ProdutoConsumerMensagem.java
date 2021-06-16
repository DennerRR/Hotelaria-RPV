package com.rp4.consumoservice.ConsumerMensagem;

import com.rp4.consumoservice.model.Produto;
import com.rp4.consumoservice.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumerMensagem {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoConsumerMensagem(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @RabbitListener(queues = {"${crud.rabbitmq.queueProduto}"})
    public void consumer(@Payload Produto produto){
        produtoRepository.save(produto);
    }
}

