package co.softlond.ejemploreactorweb.demo.services;

import co.softlond.ejemploreactorweb.demo.models.Persona;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonaService {

    private List<Persona> crearLista() {
        return Arrays.asList(
                new Persona("Juan", 20),
                new Persona("Luisa", 30),
                new Persona("Pedro", 40),
                new Persona("Ana", 50),
                new Persona("Juan", 20),
                new Persona("Luisa", 30),
                new Persona("Pedro", 40),
                new Persona("Ana", 50),
                new Persona("Juan", 20),
                new Persona("Luisa", 30),
                new Persona("Pedro", 40),
                new Persona("Ana", 50)
        );
    }

    public Flux<Persona> getPersonas() {
        return Flux.fromIterable(crearLista());
    }
}
