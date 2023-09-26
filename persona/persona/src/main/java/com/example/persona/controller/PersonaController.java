package com.example.persona.controller;

import com.example.persona.model.Persona;
import com.example.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(PersonaController.class));

@Autowired
    PersonaService personaService;
@GetMapping ("/{id}")
public ResponseEntity<?> getPersona(@PathVariable Long id){
    LOGGER.info("Entramos al endpoint getPersonas");
    try {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.getPersona(id));
    }
    catch (Exception e){
        LOGGER.info("No se pudo encontrar la persona");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro persona");
    }
}
    @GetMapping()
    public ResponseEntity<?> getPersonas() {

        LOGGER.info("Entramos el endpoint getPersonas");
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.getPersonas());

        } catch (Exception e) {
            LOGGER.info("No se encontraron personas");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron personas");
        }
    }

@PostMapping ("/save")
    public ResponseEntity<?> savePersona(@RequestBody Persona persona){
LOGGER.info("Entramos al endpoint savePersona");
try{

    return ResponseEntity.status(HttpStatus.CREATED).body(personaService.savePersona(persona));
}catch (Exception e){
    LOGGER.info(("No se guardaron personas"));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se guardaron personas");
}
}
@DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){
    LOGGER.info("Entramos al endpoint deletePersona");
    try{personaService.deletePersona(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se pudo eliminar la persona");

    }
catch (Exception e){
        LOGGER.info("No se eliminaron las personas");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se eliminaron las personas");
}
}
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona, @PathVariable Long id) {
        LOGGER.info("Entramos al endpoit updatePersona");
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.updatePersona(persona, id));
        }
        catch (Exception e){
            LOGGER.info("No se pudo actualizar la persona");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se actualizaron las personas");
        }
    }
}
