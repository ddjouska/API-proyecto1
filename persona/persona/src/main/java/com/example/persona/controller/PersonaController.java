package com.example.persona.controller;

import com.example.persona.model.Persona;
import com.example.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class PersonaController {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(PersonaController.class));

@Autowired
    PersonaService personaService;
@GetMapping ("/personas")
public List<Persona> getPersona(){
    LOGGER.info("Este es un mensaje informativo.");
    return personaService.getPersonas();
}
@GetMapping("/persona/{id}")
    public Persona getPersona(@PathVariable Long id){
    try {
        return personaService.getPersona(id);
    } catch (Exception e) {
        LOGGER.info("No se encontro la persona con el id: " + id);

    }
    return null;
}
@PostMapping ("/save")
    public Persona savePersona(@RequestBody Persona persona){
    return personaService.savePersona(persona);
}
@DeleteMapping ("/delete/{id}")
    public void deletePersona(@PathVariable Long id){
    personaService.deletePersona(id);
}
    @PostMapping("/update/{id}")
    public Persona updatePersona(@RequestBody Persona persona, @PathVariable Long id) {
        return personaService.updatePersona(persona, id);
    }
}
