package co.softlond.ejemploreactorweb.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private RabbitTemplate template;

    @Value("${rabbitmq.exchange}")
    String exchange;
    @Value("${rabbitmq.routingKey}")
    String routingKey;

    public void enviar(String msg) {
        logger.info("Enviando mensaje...");
        template.convertAndSend(exchange, routingKey, msg);
        logger.info("Mensaje enviado. " + msg);
    }
}
