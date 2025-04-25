package com.example.pintegrador.materia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    // Crear
    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }

    // Obtener por ID
    public Materia getById(String id) {
        return materiaRepository.findById(id).orElse(null);
    }

    // Obtener todos
    public List<Materia> getAll() {
        return materiaRepository.findAll();
    }

    // Actualizar
    public Materia actualizar(String id, Materia materiaActualizada) {
        Materia materiaExistente = materiaRepository.findById(id).orElse(null);
        if (materiaExistente != null) {
            materiaExistente.setNombre(materiaActualizada.getNombre());
            materiaExistente.setDescripcion(materiaActualizada.getDescripcion());
            materiaExistente.setProfesorId(materiaActualizada.getProfesorId());
            return materiaRepository.save(materiaExistente);
        }
        return null;
    }

    // Eliminar
    public void deleteById(String id) {
        materiaRepository.deleteById(id);
    }
}
