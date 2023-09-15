package com.example.persona.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
   @Id
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
}
