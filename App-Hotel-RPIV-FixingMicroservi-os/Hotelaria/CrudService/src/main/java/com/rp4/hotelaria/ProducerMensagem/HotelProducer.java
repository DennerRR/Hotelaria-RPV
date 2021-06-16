package com.rp4.hotelaria.ProducerMensagem;

import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Quarto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HotelProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingkeyHotel}")
    String routingkey;

    public RabbitTemplate rabbitTemplate;


    @Autowired
    public HotelProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void producerMensagem(Hotel hotel){
        rabbitTemplate.convertAndSend(exchange, routingkey, hotel);

    }
}
