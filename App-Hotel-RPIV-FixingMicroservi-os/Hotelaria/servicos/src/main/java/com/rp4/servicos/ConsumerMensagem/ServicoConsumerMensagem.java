package com.rp4.servicos.ConsumerMensagem;

import com.rp4.servicos.model.Servico;
import com.rp4.servicos.repository.ServicoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ServicoConsumerMensagem {
    private ServicoRepository servicoRepository;
    @Autowired
    public ServicoConsumerMensagem(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    @RabbitListener(queues = {"${crud.rabbitmq.queueServico}"})
    public void consumer(@Payload Servico servico){
        servicoRepository.save(servico);
    }
}
