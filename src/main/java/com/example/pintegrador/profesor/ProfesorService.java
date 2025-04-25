package com.example.pintegrador.profesor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor guardar(Profesor entity) {
        return profesorRepository.save(entity);
    }

    public Profesor getById(String id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    public void deleteById(String id) {
        profesorRepository.deleteById(id);
    }

    public Profesor actualizar(String id, Profesor profesorActualizado) {
        Profesor profesorExistente = profesorRepository.findById(id).orElse(null);
        if (profesorExistente != null) {
            profesorExistente.setNombre(profesorActualizado.getNombre());
            profesorExistente.setCorreo(profesorActualizado.getCorreo());
            profesorExistente.setContrasena(profesorActualizado.getContrasena());
            profesorExistente.setFechaNacimiento(profesorActualizado.getFechaNacimiento());
            profesorExistente.setGenero(profesorActualizado.getGenero());
            return profesorRepository.save(profesorExistente);
        } else {
            return null;
        }
    }
}
