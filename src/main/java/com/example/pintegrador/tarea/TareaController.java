package com.example.pintegrador.tarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tarea")
@Tag(name = "Tarea", description = "Controlador para manejar tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping("/")
    @Operation(summary = "Guardar una tarea")
    public Tarea guardar(@RequestBody Tarea entity) {
        return tareaService.guardar(entity);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID")
    public Tarea getById(@PathVariable("id") String id) {
        return tareaService.getById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todas las tareas")
    public List<Tarea> getAll() {
        return tareaService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una tarea")
    public Tarea actualizar(@PathVariable("id") String id, @RequestBody Tarea tareaActualizada) {
        return tareaService.actualizar(id, tareaActualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea por ID")
    public void deleteById(@PathVariable("id") String id) {
        tareaService.deleteById(id);
    }
}
