package co.softlond.ejemploreactorweb.demo.controllers;

import co.softlond.ejemploreactorweb.demo.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("mensajes")
public class MensajeController {

    @Autowired
    private Sender sender;

    @PostMapping
    public Mono<String> enviarMensaje(@RequestBody String msg) {
        sender.enviar(msg);
        return Mono.just(msg);
    }
}
