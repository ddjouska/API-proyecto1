package com.example.persona.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//Longbok creacion getters y setters
@Data
//Longbok creacion de constructores con argumentos
@AllArgsConstructor
//Longbok creacion de constructor vacio
@NoArgsConstructor
public class Persona {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
}
