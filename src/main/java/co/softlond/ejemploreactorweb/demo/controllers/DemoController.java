package co.softlond.ejemploreactorweb.demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {
    @GetMapping
    public Integer numero() {
        return 100;
    }

    @GetMapping("/numero-reactivo")
    public Mono<Integer> numeroReactivo() {
        return Mono.just(1000);
    }

    @GetMapping("/numeros")
    public Integer[] numeros() throws InterruptedException {
        Integer[] numeros = new Integer[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
            Thread.sleep(1000);
        }
        return numeros;
    }

    @GetMapping(value = "/numeros-reactivo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> numerosReactivo() {
        return Flux.create(sink -> {
            for (int i = 0; i < 10; i ++) {
                try {
                    Thread.sleep(1000);
                    sink.next(i + 1);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            sink.complete();
        });
    }
}
