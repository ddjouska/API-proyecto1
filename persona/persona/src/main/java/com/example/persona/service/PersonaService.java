package com.example.persona.service;

import com.example.persona.model.Persona;
import com.example.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public Persona getPersona(Long id){
      Optional<Persona> persona = personaRepository.findById(id);
    return persona.get();
    }
    public Persona savePersona (Persona persona){
        return personaRepository.save(persona);
    }
    public Persona updatePersona (Persona persona){
        return personaRepository.save(persona);
        }
        public void deletePersona (Long id){
        personaRepository.deleteById(id);
}
}
