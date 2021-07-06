package com.rp4.turismo.ConsumerMensagem;

import com.rp4.turismo.model.Turismo;
import com.rp4.turismo.repository.TurismoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TurismoConsumer {
    private TurismoRepository turismoRepository;

    @Autowired

    public TurismoConsumer(TurismoRepository turismoRepository) {
        this.turismoRepository = turismoRepository;
    }

    @RabbitListener(queues = {"${crud.rabbitmq.queueTurismo}"})
    public void consumer(@Payload Turismo turismo) {
        turismoRepository.save(turismo);
    }
}
