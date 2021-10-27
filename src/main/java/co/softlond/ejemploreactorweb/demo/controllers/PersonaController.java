package co.softlond.ejemploreactorweb.demo.controllers;

import co.softlond.ejemploreactorweb.demo.models.Persona;
import co.softlond.ejemploreactorweb.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping(value = "personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE) // data: {}
    public Flux<Persona> getPersonas() {
        return personaService.getPersonas()
                .delayElements(Duration.ofSeconds(1));
    }
}
