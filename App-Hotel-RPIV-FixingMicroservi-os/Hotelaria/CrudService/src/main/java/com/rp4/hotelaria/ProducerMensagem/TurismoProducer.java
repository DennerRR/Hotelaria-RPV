package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Turismo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TurismoProducer {


        @Value("${crud.rabbitmq.exchange}")
        String exchange;

        @Value("${crud.rabbitmq.routingkeyTurismo}")
        String routingkey;

        private RabbitTemplate rabbitTemplate;


        @Autowired
        public TurismoProducer(RabbitTemplate rabbitTemplate){
            this.rabbitTemplate = rabbitTemplate;
        }

        public void producerMensagem(Turismo turismo){
            rabbitTemplate.convertAndSend(exchange, routingkey, turismo);

        }


    }

