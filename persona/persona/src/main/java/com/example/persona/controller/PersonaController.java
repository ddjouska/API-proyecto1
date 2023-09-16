package com.example.persona.controller;

import com.example.persona.model.Persona;
import com.example.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonaController {
@Autowired
    PersonaService personaService;
@GetMapping ("/personas")
public List<Persona> getPersona(){
    return personaService.getPersonas();
}
@GetMapping("/persona/{id}")
    public Persona getPersona(@PathVariable Long id){
    return personaService.getPersona(id);
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
