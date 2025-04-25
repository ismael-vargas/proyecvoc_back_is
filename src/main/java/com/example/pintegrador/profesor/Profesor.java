package com.example.pintegrador.profesor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.time.LocalDate;

@Document(collection = "profesores")
@Data
public class Profesor {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String contrasena; // Campo para la contraseña
    private LocalDate fechaNacimiento; // Campo para la fecha de nacimiento
    private String genero; // Campo para el género
}
