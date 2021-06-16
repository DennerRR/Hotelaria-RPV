package com.rp4.reservaservice.ConsumerMensagem;

import com.rp4.reservaservice.model.Quarto;
import com.rp4.reservaservice.repository.QuartoRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QuartoConsumerMensagem {

    private QuartoRepository quartoRepository;

    @Autowired
    public QuartoConsumerMensagem(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }



    @RabbitListener(queues = {"${crud.rabbitmq.queueQuarto}"})
    public void consumer(@Payload Quarto quarto) {
        quartoRepository.save(quarto);
        

    }
}
