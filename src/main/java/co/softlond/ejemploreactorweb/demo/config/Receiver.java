package co.softlond.ejemploreactorweb.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "queue-demo")
public class Receiver {

    private final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void receive(String msg) {
        logger.info("***********************************");
        logger.info("Llegó: " + msg);
        logger.info("***********************************");
    }
}
