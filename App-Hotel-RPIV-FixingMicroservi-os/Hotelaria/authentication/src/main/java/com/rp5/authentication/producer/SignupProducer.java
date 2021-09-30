package com.rp5.authentication.producer;
import com.rp5.authentication.DTO.TodoUsuarioDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SignupProducer {

    @Value("${auth.rabbitmq.exchange}")
    String exchange;

    @Value("${auth.rabbitmq.routingKeySignup}")
    String routingKey;

    public RabbitTemplate rabbitTemplate;

    @Autowired
    public SignupProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(TodoUsuarioDTO user) {
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}

