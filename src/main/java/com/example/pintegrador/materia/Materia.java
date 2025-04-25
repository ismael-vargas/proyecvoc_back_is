package com.example.pintegrador.materia;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "materias")
@Data
public class Materia {
    @Id
    private String id;
    private String nombre;
    private String descripcion; // ← Agregado este campo
    private String profesorId; // Referencia al profesor
}
