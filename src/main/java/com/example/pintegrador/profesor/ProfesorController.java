package com.example.pintegrador.profesor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/profesor")
@Tag(name = "Profesor", description = "Controlador para manejar profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/")
    @Operation(summary = "Guardar un profesor")
    public Profesor guardar(@RequestBody Profesor entity) {
        return profesorService.guardar(entity);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un profesor por ID")
    public Profesor getById(@PathVariable("id") String id) {
        return profesorService.getById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los profesores")
    public List<Profesor> getAll() {
        return profesorService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un profesor")
    public Profesor actualizar(@PathVariable("id") String id, @RequestBody Profesor entity) {
        return profesorService.actualizar(id, entity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un profesor por ID")
    public void deleteById(@PathVariable("id") String id) {
        profesorService.deleteById(id);
    }
}
