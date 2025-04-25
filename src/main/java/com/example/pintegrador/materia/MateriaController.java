package com.example.pintegrador.materia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/materia")
@Tag(name = "Materia", description = "Controlador para manejar materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping("/")
    @Operation(summary = "Guardar una nueva materia")
    public Materia guardar(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todas las materias")
    public List<Materia> getAll() {
        return materiaService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una materia por ID")
    public Materia getById(@PathVariable("id") String id) {
        return materiaService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una materia existente")
    public Materia actualizar(@PathVariable("id") String id, @RequestBody Materia materiaActualizada) {
        return materiaService.actualizar(id, materiaActualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una materia por ID")
    public void deleteById(@PathVariable("id") String id) {
        materiaService.deleteById(id);
    }
}
