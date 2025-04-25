package com.example.pintegrador.tarea;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "tareas")
@Data
public class Tarea {
    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String enlaceExterno;
    private String materiaId; 
}
