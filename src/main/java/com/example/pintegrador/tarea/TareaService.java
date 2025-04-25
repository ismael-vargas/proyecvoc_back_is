package com.example.pintegrador.tarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    // Crear tarea
    public Tarea guardar(Tarea entity) {
        return tareaRepository.save(entity);
    }

    // Obtener una tarea por ID
    public Tarea getById(String id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada"));
    }

    // Obtener todas las tareas
    public List<Tarea> getAll() {
        return tareaRepository.findAll();
    }

    // Actualizar tarea
    public Tarea actualizar(String id, Tarea tareaActualizada) {
        Tarea tareaExistente = tareaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada"));

        tareaExistente.setTitulo(tareaActualizada.getTitulo());
        tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
        tareaExistente.setEnlaceExterno(tareaActualizada.getEnlaceExterno());
        tareaExistente.setMateriaId(tareaActualizada.getMateriaId());

        return tareaRepository.save(tareaExistente);
    }

    // Eliminar tarea
    public void deleteById(String id) {
        if (!tareaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        tareaRepository.deleteById(id);
    }
}
